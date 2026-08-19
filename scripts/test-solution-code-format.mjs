import assert from 'node:assert/strict'
import { formatSolutionCode } from './solution-code-format.mjs'

const java = formatSolutionCode(
  'class Solution { public int value(){for(int i=0;i<3;i++){if(i==2)return i;}return -1;} }',
  'java',
)
assert.match(java, /class Solution \{\n/)
assert.match(java, /for\(int i=0;i<3;i\+\+\)\{/)
assert.match(java, /\n\s+return -1;/)

const kotlinOperator = formatSolutionCode(
  'class Solution { fun value(items:IntArray)=items.count{it>0}-1 }',
  'kotlin',
)
assert.doesNotMatch(kotlinOperator, /}\n\s*-/)
assert.match(kotlinOperator, /}-1/)

const kotlinInfix = formatSolutionCode(
  'class Solution { fun value(a:IntArray,b:IntArray)=a.fold(0){x,y->x xor y} custom b.fold(0){x,y->x xor y} }',
  'kotlin',
)
assert.doesNotMatch(kotlinInfix, /}\n\s*custom\b/)

const kotlinSoftKeywordInfix = formatSolutionCode(
  'class Solution { fun value(items:IntArray)=items.count{it>0} value 2 }',
  'kotlin',
)
assert.doesNotMatch(kotlinSoftKeywordInfix, /}\n\s*value\b/)

const cppNumber = formatSolutionCode(
  "class Solution { public: int value(){const int mod=1'000'000'007;return mod;} };",
  'cpp',
)
assert.match(cppNumber, /1'000'000'007;/)
assert.match(cppNumber, /\n\s+return mod;/)

const cppCharacter = formatSolutionCode(
  "class Solution { public: bool value(char c){switch(c){case'a':return true;default:return false;}} };",
  'cpp',
)
assert.match(cppCharacter, /case'a':return true;/)
assert.match(cppCharacter, /\n\s+default:return false;/)

const cppRawString = formatSolutionCode(
  'class Solution { public:string value(){return R"tag(a"b;{c})tag";} };',
  'cpp',
)
assert.match(cppRawString, /R"tag\(a"b;\{c\}\)tag";/)

const trailingComment = formatSolutionCode(
  'class Solution { public int value(){return 1;} } // note; braces {} stay in the comment',
  'java',
)
assert.match(trailingComment, /\/\/ note; braces \{\} stay in the comment/)

const blockComment = formatSolutionCode(
  'class Solution { /* semicolon; brace } */ public int value(){return 1;} }',
  'java',
)
assert.match(blockComment, /\/\* semicolon; brace } \*\//)

console.log('Solution code formatter tests passed.')
