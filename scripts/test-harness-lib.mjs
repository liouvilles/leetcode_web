function quote(value) {
  return JSON.stringify(value)
}

function kotlinQuote(value) {
  return JSON.stringify(value).replaceAll('$', '\\$')
}

function values(value, mapper) {
  if (!Array.isArray(value)) throw new Error(`测试值应为数组：${JSON.stringify(value)}`)
  return value.map(mapper).join(', ')
}

function javaLiteral(type, value) {
  switch (type) {
    case 'int': return String(value)
    case 'long': return `${value}L`
    case 'longArray': return `new long[] {${values(value, (item) => javaLiteral('long', item))}}`
    case 'double': return Number.isInteger(value) ? `${value}.0` : String(value)
    case 'doubleArray': return `new double[] {${values(value, (item) => javaLiteral('double', item))}}`
    case 'boolean': return String(value)
    case 'booleanArray': return `new boolean[] {${values(value, String)}}`
    case 'string': return quote(value)
    case 'char': return `${quote(value)}.charAt(0)`
    case 'charArray': return `new char[] {${values(value, (item) => `${quote(item)}.charAt(0)`)}}`
    case 'charMatrix': return `new char[][] {${values(value, (row) => javaLiteral('charArray', row))}}`
    case 'intArray': return `new int[] {${values(value, String)}}`
    case 'stringArray': return `new String[] {${values(value, quote)}}`
    case 'intMatrix': return `new int[][] {${values(value, (row) => javaLiteral('intArray', row))}}`
    case 'intList': return `Arrays.asList(${values(value, String)})`
    case 'longList': return `Arrays.asList(${values(value, (item) => javaLiteral('long', item))})`
    case 'booleanList': return `Arrays.asList(${values(value, String)})`
    case 'doubleList': return `Arrays.asList(${values(value, (item) => javaLiteral('double', item))})`
    case 'stringList': return `Arrays.asList(${values(value, quote)})`
    case 'intListMatrix': return `Arrays.asList(${values(value, (row) => javaLiteral('intList', row))})`
    case 'longListMatrix': return `Arrays.asList(${values(value, (row) => `Arrays.asList(${values(row, (item) => javaLiteral('long', item))})`)})`
    case 'stringListMatrix': return `Arrays.asList(${values(value, (row) => javaLiteral('stringList', row))})`
    case 'listNode': return `AtlasTest.buildList(${javaLiteral('intArray', value)})`
    case 'treeNode': return `AtlasTest.buildTree(new Integer[] {${values(value, (item) => item === null ? 'null' : String(item))}})`
    case 'treeNodeList': return `Arrays.asList(${values(value, (tree) => javaLiteral('treeNode', tree))})`
    case 'mountainArray': return `new MountainArray(${javaLiteral('intArray', value)})`
    case 'customFunction': return `new CustomFunction(${quote(value)})`
    default: throw new Error(`Java 不支持测试类型：${type}`)
  }
}

function kotlinLiteral(type, value) {
  switch (type) {
    case 'int': return String(value)
    case 'long': return `${value}L`
    case 'longArray': return `longArrayOf(${values(value, (item) => kotlinLiteral('long', item))})`
    case 'double': return Number.isInteger(value) ? `${value}.0` : String(value)
    case 'doubleArray': return `doubleArrayOf(${values(value, (item) => kotlinLiteral('double', item))})`
    case 'boolean': return String(value)
    case 'booleanArray': return `booleanArrayOf(${values(value, String)})`
    case 'string': return kotlinQuote(value)
    case 'char': return `${kotlinQuote(value)}[0]`
    case 'charArray': return `charArrayOf(${values(value, (item) => `${kotlinQuote(item)}[0]`)})`
    case 'charMatrix': return value.length === 0
      ? 'emptyArray<CharArray>()'
      : `arrayOf(${values(value, (row) => kotlinLiteral('charArray', row))})`
    case 'intArray': return `intArrayOf(${values(value, String)})`
    case 'stringArray': return value.length === 0
      ? 'emptyArray<String>()'
      : `arrayOf(${values(value, kotlinQuote)})`
    case 'intMatrix': return value.length === 0
      ? 'emptyArray<IntArray>()'
      : `arrayOf(${values(value, (row) => kotlinLiteral('intArray', row))})`
    case 'intList': return `listOf<Int>(${values(value, String)})`
    case 'longList': return `listOf<Long>(${values(value, (item) => kotlinLiteral('long', item))})`
    case 'booleanList': return `listOf<Boolean>(${values(value, String)})`
    case 'doubleList': return `listOf<Double>(${values(value, (item) => kotlinLiteral('double', item))})`
    case 'stringList': return `listOf<String>(${values(value, kotlinQuote)})`
    case 'intListMatrix': return `listOf<List<Int>>(${values(value, (row) => kotlinLiteral('intList', row))})`
    case 'longListMatrix': return `listOf<List<Long>>(${values(value, (row) => `listOf<Long>(${values(row, (item) => kotlinLiteral('long', item))})`)})`
    case 'stringListMatrix': return `listOf<List<String>>(${values(value, (row) => kotlinLiteral('stringList', row))})`
    case 'listNode': return `buildList(${kotlinLiteral('intArray', value)})`
    case 'treeNode': return `buildTree(arrayOf<Int?>(${values(value, (item) => item === null ? 'null' : String(item))}))!!`
    case 'treeNodeList': return `listOf<TreeNode?>(${values(value, (tree) => kotlinLiteral('treeNode', tree))})`
    case 'mountainArray': return `MountainArray(${kotlinLiteral('intArray', value)})`
    case 'customFunction': return `CustomFunction(${kotlinQuote(value)})`
    default: throw new Error(`Kotlin 不支持测试类型：${type}`)
  }
}

function cppLiteral(type, value) {
  switch (type) {
    case 'int': return String(value)
    case 'long': return `${value}LL`
    case 'longArray': return `vector<long long>{${values(value, (item) => cppLiteral('long', item))}}`
    case 'double': return Number.isInteger(value) ? `${value}.0` : String(value)
    case 'doubleArray': return `vector<double>{${values(value, (item) => cppLiteral('double', item))}}`
    case 'boolean': return String(value)
    case 'booleanArray': return `vector<bool>{${values(value, String)}}`
    case 'string': return quote(value)
    case 'char': return `${quote(value)}[0]`
    case 'charArray': return `vector<char>{${values(value, (item) => `${quote(item)}[0]`)}}`
    case 'charMatrix': return `vector<vector<char>>{${values(value, (row) => cppLiteral('charArray', row))}}`
    case 'intArray':
    case 'intList': return `vector<int>{${values(value, String)}}`
    case 'longList': return `vector<long long>{${values(value, (item) => cppLiteral('long', item))}}`
    case 'booleanList': return `vector<bool>{${values(value, String)}}`
    case 'doubleList': return `vector<double>{${values(value, (item) => cppLiteral('double', item))}}`
    case 'stringArray':
    case 'stringList': return `vector<string>{${values(value, quote)}}`
    case 'intMatrix':
    case 'intListMatrix': return `vector<vector<int>>{${values(value, (row) => cppLiteral('intArray', row))}}`
    case 'longListMatrix': return `vector<vector<long long>>{${values(value, (row) => `vector<long long>{${values(row, (item) => cppLiteral('long', item))}}`)}}`
    case 'stringListMatrix': return `vector<vector<string>>{${values(value, (row) => cppLiteral('stringArray', row))}}`
    case 'listNode': return `buildList(${cppLiteral('intArray', value)})`
    case 'treeNode': return `buildTree(vector<optional<int>>{${values(value, (item) => item === null ? 'nullopt' : String(item))}})`
    case 'treeNodeList': return `vector<TreeNode*>{${values(value, (tree) => cppLiteral('treeNode', tree))}}`
    case 'mountainArray': return `MountainArray(${cppLiteral('intArray', value)})`
    case 'customFunction': return `CustomFunction(${quote(value)})`
    default: throw new Error(`C++ 不支持测试类型：${type}`)
  }
}

function javaAssertion(type, actual, expected) {
  if (type === 'listNode') return `Arrays.equals(AtlasTest.listValues(${actual}), ${javaLiteral('intArray', expected)})`
  if (type === 'treeNode') {
    return `AtlasTest.treeValues(${actual}).equals(Arrays.asList(${values(expected, (item) => item === null ? 'null' : String(item))}))`
  }
  if (type === 'treeNodeList') {
    return `AtlasTest.treeListValues(${actual}).equals(Arrays.asList(${values(expected, (tree) => `Arrays.asList(${values(tree, (item) => item === null ? 'null' : String(item))})`)}))`
  }
  if (type === 'charArray' || type === 'longArray' || type === 'doubleArray' || type === 'booleanArray' || type === 'intArray' || type === 'stringArray') return `Arrays.equals(${actual}, ${javaLiteral(type, expected)})`
  if (type === 'charMatrix' || type === 'intMatrix') return `Arrays.deepEquals(${actual}, ${javaLiteral(type, expected)})`
  if (type === 'double') return `Math.abs(${actual} - ${javaLiteral(type, expected)}) <= 1e-9`
  if (type === 'int' || type === 'long' || type === 'boolean') return `${actual} == ${javaLiteral(type, expected)}`
  return `Objects.equals(${actual}, ${javaLiteral(type, expected)})`
}

function javaType(type) {
  const types = {
    int: 'int',
    long: 'long',
    longArray: 'long[]',
    double: 'double',
    doubleArray: 'double[]',
    boolean: 'boolean',
    booleanArray: 'boolean[]',
    string: 'String',
    char: 'char',
    charArray: 'char[]',
    charMatrix: 'char[][]',
    intArray: 'int[]',
    stringArray: 'String[]',
    intMatrix: 'int[][]',
    intList: 'List<Integer>',
    longList: 'List<Long>',
    booleanList: 'List<Boolean>',
    doubleList: 'List<Double>',
    stringList: 'List<String>',
    intListMatrix: 'List<List<Integer>>',
    longListMatrix: 'List<List<Long>>',
    stringListMatrix: 'List<List<String>>',
    listNode: 'ListNode',
    treeNode: 'TreeNode',
    treeNodeList: 'List<TreeNode>',
    mountainArray: 'MountainArray',
    customFunction: 'CustomFunction',
  }
  if (!types[type]) throw new Error(`Java 不支持参数类型：${type}`)
  return types[type]
}

function kotlinAssertion(type, actual, expected) {
  if (type === 'listNode') return `listValues(${actual}).contentEquals(${kotlinLiteral('intArray', expected)})`
  if (type === 'treeNode') return `treeValues(${actual}) == listOf<Int?>(${values(expected, (item) => item === null ? 'null' : String(item))})`
  if (type === 'treeNodeList') return `${actual}.map { treeValues(it) } == listOf<List<Int?>>(${values(expected, (tree) => `listOf<Int?>(${values(tree, (item) => item === null ? 'null' : String(item))})`)})`
  if (type === 'charArray' || type === 'longArray' || type === 'doubleArray' || type === 'booleanArray' || type === 'intArray' || type === 'stringArray') return `${actual}.contentEquals(${kotlinLiteral(type, expected)})`
  if (type === 'charMatrix' || type === 'intMatrix') return `${actual}.contentDeepEquals(${kotlinLiteral(type, expected)})`
  if (type === 'double') return `kotlin.math.abs(${actual} - ${kotlinLiteral(type, expected)}) <= 1e-9`
  return `${actual} == ${kotlinLiteral(type, expected)}`
}

function cppAssertion(type, actual, expected) {
  if (type === 'listNode') return `listValues(${actual}) == ${cppLiteral('intArray', expected)}`
  if (type === 'treeNode') {
    return `treeValues(${actual}) == vector<optional<int>>{${values(expected, (item) => item === null ? 'nullopt' : String(item))}}`
  }
  if (type === 'treeNodeList') {
    return `treeListValues(${actual}) == vector<vector<optional<int>>>{${values(expected, (tree) => `vector<optional<int>>{${values(tree, (item) => item === null ? 'nullopt' : String(item))}}`)}}`
  }
  if (type === 'double') return `abs(${actual} - ${cppLiteral(type, expected)}) <= 1e-9`
  return `${actual} == ${cppLiteral(type, expected)}`
}

const javaPrefix = `import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
class MountainArray {
    private final int[] data;
    MountainArray(int[] data) { this.data = data; }
    public int get(int index) { return data[index]; }
    public int length() { return data.length; }
}
class CustomFunction {
    private final String mode;
    CustomFunction(String mode) { this.mode = mode; }
    public int f(int x, int y) { return mode.equals("multiply") ? x * y : x + y; }
}
`

const kotlinPrefix = `import java.util.*
class ListNode(var \`val\`: Int) { var next: ListNode? = null }
class TreeNode(var \`val\`: Int) { var left: TreeNode? = null; var right: TreeNode? = null }
class MountainArray(private val data: IntArray) { fun get(index: Int): Int = data[index]; fun length(): Int = data.size }
class CustomFunction(private val mode: String) { fun f(x: Int, y: Int): Int = if (mode == "multiply") x * y else x + y }
`

const cppPrefix = `#include <bits/stdc++.h>
using namespace std;
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int value = 0, ListNode* nextNode = nullptr) : val(value), next(nextNode) {}
};
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int value = 0) : val(value), left(nullptr), right(nullptr) {}
};
class MountainArray {
    vector<int> data;
public:
    MountainArray(vector<int> values) : data(move(values)) {}
    int get(int index) { return data[index]; }
    int length() { return data.size(); }
};
class CustomFunction {
    string mode;
public:
    CustomFunction(string mode) : mode(move(mode)) {}
    int f(int x, int y) { return mode == "multiply" ? x * y : x + y; }
};
`

function javaFunctionHarness(solution, tests) {
  const cases = tests.cases.map((testCase, index) => {
    const declarations = testCase.args.map((value, argIndex) =>
      `        ${javaType(tests.parameterTypes[argIndex])} arg${index}_${argIndex} = ${javaLiteral(tests.parameterTypes[argIndex], value)};`,
    ).join('\n')
    const args = testCase.args.map((_, argIndex) => `arg${index}_${argIndex}`).join(', ')
    const actual = `actual${index}`
    const invocation = tests.returnType === 'void'
      ? `        new Solution().${tests.method}(${args});`
      : `        var ${actual} = new Solution().${tests.method}(${args});\n        if (!(${javaAssertion(tests.returnType, actual, testCase.expected)})) {\n            throw new AssertionError(${quote(testCase.name)});\n        }`
    const argumentAssertions = (testCase.expectedArgs ?? []).map((expectedArg) =>
      `        if (!(${javaAssertion(expectedArg.type, `arg${index}_${expectedArg.index}`, expectedArg.expected)})) throw new AssertionError(${quote(`${testCase.name} / arg ${expectedArg.index}`)});`,
    ).join('\n')
    return `${declarations}
${invocation}
${argumentAssertions}`
  }).join('\n')
  return `${javaPrefix}${solution}
class AtlasTest {
    static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int value : values) { tail.next = new ListNode(value); tail = tail.next; }
        return dummy.next;
    }
    static int[] listValues(ListNode node) {
        ArrayList<Integer> values = new ArrayList<>();
        while (node != null) { values.add(node.val); node = node.next; }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }
    static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();
            if (index < values.length && values[index] != null) { node.left = new TreeNode(values[index]); queue.offer(node.left); }
            index++;
            if (index < values.length && values[index] != null) { node.right = new TreeNode(values[index]); queue.offer(node.right); }
            index++;
        }
        return root;
    }
    static List<Integer> treeValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayList<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) { values.add(null); continue; }
            values.add(node.val); queue.offer(node.left); queue.offer(node.right);
        }
        while (!values.isEmpty() && values.get(values.size() - 1) == null) values.remove(values.size() - 1);
        return values;
    }
    static List<List<Integer>> treeListValues(List<TreeNode> roots) {
        ArrayList<List<Integer>> values = new ArrayList<>();
        for (TreeNode root : roots) values.add(treeValues(root));
        return values;
    }
    public static void main(String[] args) {
${cases}
    }
}
`
}

function kotlinFunctionHarness(solution, tests, packageName) {
  const cases = tests.cases.map((testCase, index) => {
    const declarations = testCase.args.map((value, argIndex) =>
      `    val arg${index}_${argIndex} = ${kotlinLiteral(tests.parameterTypes[argIndex], value)}`,
    ).join('\n')
    const args = testCase.args.map((_, argIndex) => `arg${index}_${argIndex}`).join(', ')
    const actual = `actual${index}`
    const invocation = tests.returnType === 'void'
      ? `    Solution().${tests.method}(${args})`
      : `    val ${actual} = Solution().${tests.method}(${args})\n    check(${kotlinAssertion(tests.returnType, actual, testCase.expected)}) { ${kotlinQuote(testCase.name)} }`
    const argumentAssertions = (testCase.expectedArgs ?? []).map((expectedArg) =>
      `    check(${kotlinAssertion(expectedArg.type, `arg${index}_${expectedArg.index}`, expectedArg.expected)}) { ${kotlinQuote(`${testCase.name} / arg ${expectedArg.index}`)} }`,
    ).join('\n')
    return `${declarations}
${invocation}
${argumentAssertions}`
  }).join('\n')
  return `package ${packageName}
${kotlinPrefix}${solution}
fun buildList(values: IntArray): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in values) { tail.next = ListNode(value); tail = tail.next!! }
    return dummy.next
}
fun listValues(nodeValue: ListNode?): IntArray {
    val values = ArrayList<Int>()
    var node = nodeValue
    while (node != null) { values.add(node.\`val\`); node = node.next }
    return values.toIntArray()
}
fun buildTree(values: Array<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.add(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeFirst()
        if (index < values.size && values[index] != null) { node.left = TreeNode(values[index]!!); queue.add(node.left!!) }
        index++
        if (index < values.size && values[index] != null) { node.right = TreeNode(values[index]!!); queue.add(node.right!!) }
        index++
    }
    return root
}
fun treeValues(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val values = ArrayList<Int?>()
    val queue = LinkedList<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (node == null) { values.add(null); continue }
        values.add(node.\`val\`); queue.add(node.left); queue.add(node.right)
    }
    while (values.isNotEmpty() && values.last() == null) values.removeAt(values.lastIndex)
    return values
}
fun main() {
${cases}
}
`
}

function cppFunctionHarness(solution, tests) {
  const cases = tests.cases.map((testCase, index) => {
    const declarations = testCase.args.map((value, argIndex) =>
      `    auto arg${index}_${argIndex} = ${cppLiteral(tests.parameterTypes[argIndex], value)};`,
    ).join('\n')
    const args = testCase.args.map((_, argIndex) => `arg${index}_${argIndex}`).join(', ')
    const actual = `actual${index}`
    const invocation = tests.returnType === 'void'
      ? `    Solution().${tests.method}(${args});`
      : `    auto ${actual} = Solution().${tests.method}(${args});\n    if (!(${cppAssertion(tests.returnType, actual, testCase.expected)})) throw runtime_error(${quote(testCase.name)});`
    const argumentAssertions = (testCase.expectedArgs ?? []).map((expectedArg) =>
      `    if (!(${cppAssertion(expectedArg.type, `arg${index}_${expectedArg.index}`, expectedArg.expected)})) throw runtime_error(${quote(`${testCase.name} / arg ${expectedArg.index}`)});`,
    ).join('\n')
    return `${declarations}
${invocation}
${argumentAssertions}`
  }).join('\n')
  return `${cppPrefix}${solution}
ListNode* buildList(const vector<int>& values) {
    ListNode dummy;
    ListNode* tail = &dummy;
    for (int value : values) { tail->next = new ListNode(value); tail = tail->next; }
    return dummy.next;
}
vector<int> listValues(ListNode* node) {
    vector<int> values;
    while (node) { values.push_back(node->val); node = node->next; }
    return values;
}
TreeNode* buildTree(const vector<optional<int>>& values) {
    if (values.empty() || !values[0].has_value()) return nullptr;
    TreeNode* root = new TreeNode(*values[0]);
    queue<TreeNode*> pending;
    pending.push(root);
    size_t index = 1;
    while (!pending.empty() && index < values.size()) {
        TreeNode* node = pending.front(); pending.pop();
        if (index < values.size() && values[index].has_value()) { node->left = new TreeNode(*values[index]); pending.push(node->left); }
        ++index;
        if (index < values.size() && values[index].has_value()) { node->right = new TreeNode(*values[index]); pending.push(node->right); }
        ++index;
    }
    return root;
}
vector<optional<int>> treeValues(TreeNode* root) {
    if (!root) return {};
    vector<optional<int>> values;
    queue<TreeNode*> pending;
    pending.push(root);
    while (!pending.empty()) {
        TreeNode* node = pending.front(); pending.pop();
        if (!node) { values.push_back(nullopt); continue; }
        values.push_back(node->val); pending.push(node->left); pending.push(node->right);
    }
    while (!values.empty() && !values.back().has_value()) values.pop_back();
    return values;
}
vector<vector<optional<int>>> treeListValues(const vector<TreeNode*>& roots) {
    vector<vector<optional<int>>> values;
    for (TreeNode* root : roots) values.push_back(treeValues(root));
    return values;
}
int main() {
${cases}
    return 0;
}
`
}

export function createTestHarness(language, solution, tests, packageName = '') {
  if (tests.mode === 'design') {
    if (language === 'java') return javaDesignHarness(solution, tests)
    if (language === 'kotlin') return kotlinDesignHarness(solution, tests, packageName)
    if (language === 'cpp') return cppDesignHarness(solution, tests)
  }
  if (language === 'java') return javaFunctionHarness(solution, tests)
  if (language === 'kotlin') return kotlinFunctionHarness(solution, tests, packageName)
  if (language === 'cpp') return cppFunctionHarness(solution, tests)
  throw new Error(`未知语言：${language}`)
}

function javaDesignHarness(solution, tests) {
  const cases = tests.cases.map((testCase, caseIndex) => {
    const constructorArgs = testCase.constructorArgs.map((value, index) => javaLiteral(tests.constructorTypes[index], value)).join(', ')
    const calls = testCase.calls.map((call, callIndex) => {
      const args = call.args.map((value, index) => javaLiteral(call.parameterTypes[index], value)).join(', ')
      if (!Object.hasOwn(call, 'expected')) return `        instance${caseIndex}.${call.method}(${args});`
      const actual = `actual${caseIndex}_${callIndex}`
      return `        var ${actual} = instance${caseIndex}.${call.method}(${args});
        if (!(${javaAssertion(call.returnType, actual, call.expected)})) throw new AssertionError(${quote(`${testCase.name} / ${call.method} #${callIndex + 1}`)});`
    }).join('\n')
    return `        ${tests.className} instance${caseIndex} = new ${tests.className}(${constructorArgs});
${calls}`
  }).join('\n')
  return `${javaPrefix}${solution}
class AtlasTest {
    static ListNode buildList(int[] values) { ListNode dummy = new ListNode(), tail = dummy; for (int value : values) { tail.next = new ListNode(value); tail = tail.next; } return dummy.next; }
    static int[] listValues(ListNode node) { ArrayList<Integer> values = new ArrayList<>(); while (node != null) { values.add(node.val); node = node.next; } return values.stream().mapToInt(Integer::intValue).toArray(); }
    static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();
            if (index < values.length && values[index] != null) { node.left = new TreeNode(values[index]); queue.offer(node.left); }
            index++;
            if (index < values.length && values[index] != null) { node.right = new TreeNode(values[index]); queue.offer(node.right); }
            index++;
        }
        return root;
    }
    static List<Integer> treeValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayList<Integer> values = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) { values.add(null); continue; }
            values.add(node.val); queue.offer(node.left); queue.offer(node.right);
        }
        while (!values.isEmpty() && values.get(values.size() - 1) == null) values.remove(values.size() - 1);
        return values;
    }
    static List<List<Integer>> treeListValues(List<TreeNode> roots) {
        ArrayList<List<Integer>> values = new ArrayList<>();
        for (TreeNode root : roots) values.add(treeValues(root));
        return values;
    }
    public static void main(String[] args) {
${cases}
    }
}
`
}

function kotlinDesignHarness(solution, tests, packageName) {
  const cases = tests.cases.map((testCase, caseIndex) => {
    const constructorArgs = testCase.constructorArgs.map((value, index) => kotlinLiteral(tests.constructorTypes[index], value)).join(', ')
    const calls = testCase.calls.map((call, callIndex) => {
      const args = call.args.map((value, index) => kotlinLiteral(call.parameterTypes[index], value)).join(', ')
      if (!Object.hasOwn(call, 'expected')) return `    instance${caseIndex}.${call.method}(${args})`
      const actual = `actual${caseIndex}_${callIndex}`
      return `    val ${actual} = instance${caseIndex}.${call.method}(${args})
    check(${kotlinAssertion(call.returnType, actual, call.expected)}) { ${kotlinQuote(`${testCase.name} / ${call.method} #${callIndex + 1}`)} }`
    }).join('\n')
    return `    val instance${caseIndex} = ${tests.className}(${constructorArgs})
${calls}`
  }).join('\n')
  return `package ${packageName}
${kotlinPrefix}${solution}
fun buildList(values: IntArray): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    for (value in values) { tail.next = ListNode(value); tail = tail.next!! }
    return dummy.next
}
fun listValues(nodeValue: ListNode?): IntArray {
    val values = ArrayList<Int>()
    var node = nodeValue
    while (node != null) { values.add(node.\`val\`); node = node.next }
    return values.toIntArray()
}
fun buildTree(values: Array<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.add(root)
    var index = 1
    while (queue.isNotEmpty() && index < values.size) {
        val node = queue.removeFirst()
        if (index < values.size && values[index] != null) { node.left = TreeNode(values[index]!!); queue.add(node.left!!) }
        index++
        if (index < values.size && values[index] != null) { node.right = TreeNode(values[index]!!); queue.add(node.right!!) }
        index++
    }
    return root
}
fun treeValues(root: TreeNode?): List<Int?> {
    if (root == null) return emptyList()
    val values = ArrayList<Int?>()
    val queue = LinkedList<TreeNode?>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (node == null) { values.add(null); continue }
        values.add(node.\`val\`); queue.add(node.left); queue.add(node.right)
    }
    while (values.isNotEmpty() && values.last() == null) values.removeAt(values.lastIndex)
    return values
}
fun main() {
${cases}
}
`
}

function cppDesignHarness(solution, tests) {
  const cases = tests.cases.map((testCase, caseIndex) => {
    const constructorDeclarations = testCase.constructorArgs.map((value, index) =>
      `    auto constructorArg${caseIndex}_${index} = ${cppLiteral(tests.constructorTypes[index], value)};`,
    ).join('\n')
    const constructorArgs = testCase.constructorArgs.map((_, index) => `constructorArg${caseIndex}_${index}`).join(', ')
    const calls = testCase.calls.map((call, callIndex) => {
      const declarations = call.args.map((value, index) => `    auto arg${caseIndex}_${callIndex}_${index} = ${cppLiteral(call.parameterTypes[index], value)};`).join('\n')
      const args = call.args.map((_, index) => `arg${caseIndex}_${callIndex}_${index}`).join(', ')
      if (!Object.hasOwn(call, 'expected')) return `${declarations}
    instance${caseIndex}.${call.method}(${args});`
      const actual = `actual${caseIndex}_${callIndex}`
      return `${declarations}
    auto ${actual} = instance${caseIndex}.${call.method}(${args});
    if (!(${cppAssertion(call.returnType, actual, call.expected)})) throw runtime_error(${quote(`${testCase.name} / ${call.method} #${callIndex + 1}`)});`
    }).join('\n')
    const construction = constructorArgs
      ? `    ${tests.className} instance${caseIndex}(${constructorArgs});`
      : `    ${tests.className} instance${caseIndex};`
    return `${constructorDeclarations}${constructorDeclarations ? '\n' : ''}${construction}
${calls}`
  }).join('\n')
  return `${cppPrefix}${solution}
ListNode* buildList(const vector<int>& values) {
    ListNode dummy;
    ListNode* tail = &dummy;
    for (int value : values) { tail->next = new ListNode(value); tail = tail->next; }
    return dummy.next;
}
vector<int> listValues(ListNode* node) {
    vector<int> values;
    while (node) { values.push_back(node->val); node = node->next; }
    return values;
}
TreeNode* buildTree(const vector<optional<int>>& values) {
    if (values.empty() || !values[0].has_value()) return nullptr;
    TreeNode* root = new TreeNode(*values[0]);
    queue<TreeNode*> pending;
    pending.push(root);
    size_t index = 1;
    while (!pending.empty() && index < values.size()) {
        TreeNode* node = pending.front(); pending.pop();
        if (index < values.size() && values[index].has_value()) { node->left = new TreeNode(*values[index]); pending.push(node->left); }
        ++index;
        if (index < values.size() && values[index].has_value()) { node->right = new TreeNode(*values[index]); pending.push(node->right); }
        ++index;
    }
    return root;
}
vector<optional<int>> treeValues(TreeNode* root) {
    if (!root) return {};
    vector<optional<int>> values;
    queue<TreeNode*> pending;
    pending.push(root);
    while (!pending.empty()) {
        TreeNode* node = pending.front(); pending.pop();
        if (!node) { values.push_back(nullopt); continue; }
        values.push_back(node->val); pending.push(node->left); pending.push(node->right);
    }
    while (!values.empty() && !values.back().has_value()) values.pop_back();
    return values;
}
int main() {
${cases}
    return 0;
}
`
}
