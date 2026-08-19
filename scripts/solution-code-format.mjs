const continuationWords = new Set(['as', 'catch', 'else', 'finally', 'is', 'while'])
const continuationCharacters = new Set(['!', ')', ',', '.', ':', ';', '?', '[', ']'])
const kotlinBreakWords = new Set([
  'break',
  'class',
  'continue',
  'do',
  'for',
  'fun',
  'if',
  'interface',
  'object',
  'return',
  'throw',
  'try',
  'typealias',
  'val',
  'var',
  'when',
])

function nextToken(source, start, language) {
  let index = start
  while (index < source.length && /\s/.test(source[index])) index++
  if (index >= source.length) return { keepWithBrace: false }

  const character = source[index]
  const word = /^[A-Za-z_][A-Za-z0-9_]*/.exec(source.slice(index))?.[0]

  if (language === 'kotlin') {
    return { keepWithBrace: character !== '}' && !kotlinBreakWords.has(word) }
  }

  if (continuationCharacters.has(character) || source.startsWith('->', index)) {
    return { keepWithBrace: true }
  }

  return { keepWithBrace: continuationWords.has(word) }
}

function isEscaped(source, index) {
  let backslashes = 0
  for (let cursor = index - 1; cursor >= 0 && source[cursor] === '\\'; cursor--) backslashes++
  return backslashes % 2 === 1
}

function isNumericSeparator(source, index, language) {
  if (language !== 'cpp' || !/[0-9A-Fa-f]/.test(source[index + 1] ?? '')) return false
  let start = index - 1
  while (start >= 0 && /[0-9A-Fa-fXxBb]/.test(source[start])) start--
  return /^[0-9]/.test(source.slice(start + 1, index))
}

function rawStringEnd(source, start) {
  if (!source.startsWith('R"', start)) return -1
  const openingParenthesis = source.indexOf('(', start + 2)
  if (openingParenthesis < 0 || openingParenthesis - start - 2 > 16) return -1
  const delimiter = source.slice(start + 2, openingParenthesis)
  if (/[\s\\)]/.test(delimiter)) return -1
  const closing = `)${delimiter}"`
  const closingStart = source.indexOf(closing, openingParenthesis + 1)
  return closingStart < 0 ? -1 : closingStart + closing.length
}

function formatSingleLine(source, language) {
  const lines = []
  const parentheses = []
  let current = ''
  let indent = 0
  let quote = null
  let blockComment = false

  const emit = () => {
    const text = current.trim()
    if (text) lines.push(`${'    '.repeat(indent)}${text}`)
    current = ''
  }

  for (let index = 0; index < source.length; index++) {
    const character = source[index]

    if (blockComment) {
      current += character
      if (source.startsWith('*/', index)) {
        current += '/'
        index++
        blockComment = false
      }
      continue
    }

    if (quote === 'triple') {
      if (source.startsWith('"""', index)) {
        current += '"""'
        index += 2
        quote = null
      } else {
        current += character
      }
      continue
    }

    if (quote) {
      current += character
      if (character === quote && !isEscaped(source, index)) quote = null
      continue
    }

    if (source.startsWith('//', index)) {
      current += source.slice(index)
      break
    }

    if (source.startsWith('/*', index)) {
      current += '/*'
      index++
      blockComment = true
      continue
    }

    if (language === 'cpp' && source.startsWith('R"', index)) {
      const end = rawStringEnd(source, index)
      if (end > index) {
        current += source.slice(index, end)
        index = end - 1
        continue
      }
    }

    if (source.startsWith('"""', index)) {
      current += '"""'
      index += 2
      quote = 'triple'
      continue
    }

    if (character === "'" && isNumericSeparator(source, index, language)) {
      current += character
      continue
    }

    if (character === '"' || character === "'" || character === '`') {
      current += character
      quote = character
      continue
    }

    if (character === '(') {
      const context = /(^|[^A-Za-z0-9_])for\s*$/.test(current.trimEnd()) ? 'for' : 'normal'
      parentheses.push(context)
      current += character
      continue
    }

    if (character === ')') {
      parentheses.pop()
      current += character
      continue
    }

    if (character === '{') {
      current += character
      emit()
      indent++
      continue
    }

    if (character === '}') {
      emit()
      indent = Math.max(0, indent - 1)
      if (nextToken(source, index + 1, language).keepWithBrace) {
        current = '}'
      } else {
        lines.push(`${'    '.repeat(indent)}}`)
      }
      continue
    }

    if (character === ';' && !parentheses.includes('for')) {
      current += character
      emit()
      continue
    }

    if (/\s/.test(character)) {
      if (current && !/\s$/.test(current)) current += ' '
      continue
    }

    current += character
  }

  emit()
  return lines.join('\n')
}

export function isSingleLineSolutionCode(source) {
  return source.trim().split(/\r?\n/).length === 1
}

export function formatSolutionCode(source, language) {
  const trimmed = source.trim()
  if (!trimmed) return ''
  if (!isSingleLineSolutionCode(trimmed)) return `${trimmed}\n`
  return `${formatSingleLine(trimmed, language)}\n`
}
