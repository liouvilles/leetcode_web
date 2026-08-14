const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 154, slug: 'find-minimum-in-rotated-sorted-array-ii', title: '寻找旋转排序数组中的最小值 II', studyTags: ['二分查找', '旋转数组', '重复元素'],
    summary: '在可能含重复元素的旋转非递减数组中找出最小元素。',
    insight: '比较中点与右端点：中点较大时最小值在右侧，较小时中点仍可能是答案；相等时只能安全丢弃一个右端点。',
    pitfalls: ['重复值会使复杂度最坏退化为线性', 'middle 小于 right 时不能排除 middle', '相等时不能直接跳过半个区间'],
    solutions: [s('right-boundary-binary-search', '与右端点比较的二分', '维持最小值位于闭区间内，并根据 middle 与 right 的关系收缩。', ['初始化 left=0,right=n-1', 'middle>rightValue 时 left=middle+1', 'middle<rightValue 时 right=middle，否则 right--'], 'O(n) worst, O(log n) average', 'O(1)',
      `class Solution {
    public int findMin(int[] nums) { int left = 0, right = nums.length - 1; while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else if (nums[middle] < nums[right]) right = middle; else right--; } return nums[left]; }
}`,
      `class Solution {
    fun findMin(nums: IntArray): Int { var left = 0; var right = nums.lastIndex; while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1 else if (nums[middle] < nums[right]) right = middle else right-- }; return nums[left] }
}`,
      `class Solution {
public:
    int findMin(vector<int>& nums) { int left = 0, right = nums.size() - 1; while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else if (nums[middle] < nums[right]) right = middle; else --right; } return nums[left]; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'findMin', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '重复值后发生旋转', args: [[2,2,2,0,1]], expected: 0 }, { name: '未旋转数组', args: [[1,3,5]], expected: 1 }, { name: '重复端点遮蔽最小值', args: [[10,1,10,10,10]], expected: 1 },
    ] },
  },
  {
    id: 165, slug: 'compare-version-numbers', title: '比较版本号', studyTags: ['字符串解析', '双指针', '分段比较'],
    summary: '逐段比较两个点分十进制版本号，忽略每段前导零以及末尾缺省的零段。',
    insight: '把两个版本拆成修订号数组，逐位置解析数值；缺少的修订号视为零，第一次不同即决定大小。',
    pitfalls: ['不能按字符串字典序比较数字段', '前导零不影响数值', '较短版本的缺失段等价于零'],
    solutions: [s('revision-by-revision', '逐修订号数值比较', '同步遍历最长段数，每次取对应数值或零并比较。', ['按点拆分两个版本', '枚举到较长数组末尾', '解析对应段，首次不同返回 -1 或 1，否则返回 0'], 'O(m+n)', 'O(m+n)',
      `class Solution {
    public int compareVersion(String version1, String version2) { String[] first = version1.split("[.]"); String[] second = version2.split("[.]"); int count = Math.max(first.length, second.length); for (int index = 0; index < count; index++) { long left = index < first.length ? Long.parseLong(first[index]) : 0; long right = index < second.length ? Long.parseLong(second[index]) : 0; if (left < right) return -1; if (left > right) return 1; } return 0; }
}`,
      `class Solution {
    fun compareVersion(version1: String, version2: String): Int { val first = version1.split('.'); val second = version2.split('.'); for (index in 0 until maxOf(first.size, second.size)) { val left = if (index < first.size) first[index].toLong() else 0L; val right = if (index < second.size) second[index].toLong() else 0L; if (left < right) return -1; if (left > right) return 1 }; return 0 }
}`,
      `class Solution {
    vector<long long> parse(const string& version) { vector<long long> values; string part; stringstream stream(version); while (getline(stream, part, '.')) values.push_back(stoll(part)); return values; }
public:
    int compareVersion(string version1, string version2) { vector<long long> first = parse(version1), second = parse(version2); for (int index = 0; index < (int)max(first.size(), second.size()); ++index) { long long left = index < (int)first.size() ? first[index] : 0, right = index < (int)second.size() ? second[index] : 0; if (left < right) return -1; if (left > right) return 1; } return 0; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'compareVersion', parameterTypes: ['string','string'], returnType: 'int', cases: [
      { name: '按数值而非字典序', args: ['1.2','1.10'], expected: -1 }, { name: '忽略前导零', args: ['1.01','1.001'], expected: 0 }, { name: '忽略末尾零段', args: ['1.0','1.0.0.0'], expected: 0 },
    ] },
  },
  {
    id: 168, slug: 'excel-sheet-column-title', title: 'Excel 表列名称', studyTags: ['进制转换', '字符串', '一基数位'],
    summary: '把正整数列序号转换为 Excel 使用的 A 到 Z、AA 到 ZZ 等列名称。',
    insight: '这是没有零位的一基二十六进制；每轮先减一，再对二十六取余就能映射到 A 到 Z。',
    pitfalls: ['取余前必须先减一', '结果从低位到高位生成后要反转', 'Z 对应余数二十五而不是零'],
    solutions: [s('bijective-base-26', '一基二十六进制转换', '通过先减一把一基数位映射为普通的 0..25 余数。', ['while columnNumber>0', 'columnNumber-- 后追加余数对应字符', '整除 26 继续，最后反转'], 'O(log26 n)', 'O(log26 n)',
      `class Solution {
    public String convertToTitle(int columnNumber) { StringBuilder answer = new StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append((char)('A' + columnNumber % 26)); columnNumber /= 26; } return answer.reverse().toString(); }
}`,
      `class Solution {
    fun convertToTitle(input: Int): String { var columnNumber = input; val answer = StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append(('A'.code + columnNumber % 26).toChar()); columnNumber /= 26 }; return answer.reverse().toString() }
}`,
      `class Solution {
public:
    string convertToTitle(int columnNumber) { string answer; while (columnNumber > 0) { --columnNumber; answer += char('A' + columnNumber % 26); columnNumber /= 26; } reverse(answer.begin(), answer.end()); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'convertToTitle', parameterTypes: ['int'], returnType: 'string', cases: [
      { name: '第一列', args: [1], expected: 'A' }, { name: '跨过 Z', args: [28], expected: 'AB' }, { name: '两位最大附近', args: [701], expected: 'ZY' },
    ] },
  },
  {
    id: 171, slug: 'excel-sheet-column-number', title: 'Excel 表列序号', studyTags: ['进制转换', '字符串', '位权累积'],
    summary: '把 Excel 的字母列名称转换为对应的正整数列序号。',
    insight: '从左到右把已有结果乘二十六，再加当前字母对应的 1 到 26，等价于一基二十六进制求值。',
    pitfalls: ['A 映射为一而不是零', '每读一个字符都要先扩大原位权', '输入只含大写英文字母'],
    solutions: [s('base-26-accumulation', '从高位到低位累积', '像解析普通进制整数一样逐字符更新结果。', ['answer 初始化为零', '对每个字符执行 answer*=26', '加上 character-A+1'], 'O(n)', 'O(1)',
      `class Solution {
    public int titleToNumber(String columnTitle) { int answer = 0; for (char value : columnTitle.toCharArray()) answer = answer * 26 + value - 'A' + 1; return answer; }
}`,
      `class Solution {
    fun titleToNumber(columnTitle: String): Int { var answer = 0; for (value in columnTitle) answer = answer * 26 + (value - 'A') + 1; return answer }
}`,
      `class Solution {
public:
    int titleToNumber(string columnTitle) { int answer = 0; for (char value : columnTitle) answer = answer * 26 + value - 'A' + 1; return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'titleToNumber', parameterTypes: ['string'], returnType: 'int', cases: [
      { name: '第一列', args: ['A'], expected: 1 }, { name: '两字符列名', args: ['AB'], expected: 28 }, { name: 'Z 开头列名', args: ['ZY'], expected: 701 },
    ] },
  },
  {
    id: 172, slug: 'factorial-trailing-zeroes', title: '阶乘后的零', studyTags: ['数学', '因子计数', '整除'],
    summary: '计算 n 的阶乘十进制表示末尾连续零的数量。',
    insight: '每个末尾零需要一对因子 2 和 5，而阶乘中 2 更多，因此只需累计 5、25、125 等贡献的五因子数量。',
    pitfalls: ['25 的倍数会额外贡献一个五因子', '无需真正计算阶乘', '循环不断令 n 除以五即可覆盖所有幂次'],
    solutions: [s('count-factors-of-five', '累计五因子', '反复整除五，每轮商表示至少还能贡献一个五因子的数的数量。', ['answer 初始化为零', 'n/=5', '把当前 n 加入 answer，直到 n 为零'], 'O(log5 n)', 'O(1)',
      `class Solution {
    public int trailingZeroes(int n) { int answer = 0; while (n > 0) { n /= 5; answer += n; } return answer; }
}`,
      `class Solution {
    fun trailingZeroes(input: Int): Int { var n = input; var answer = 0; while (n > 0) { n /= 5; answer += n }; return answer }
}`,
      `class Solution {
public:
    int trailingZeroes(int n) { int answer = 0; while (n > 0) { n /= 5; answer += n; } return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'trailingZeroes', parameterTypes: ['int'], returnType: 'int', cases: [
      { name: '不足五', args: [3], expected: 0 }, { name: '一个五因子', args: [5], expected: 1 }, { name: '包含二十五倍数', args: [100], expected: 24 },
    ] },
  },
] }
