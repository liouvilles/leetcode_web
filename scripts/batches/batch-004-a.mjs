const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 6, slug: 'zigzag-conversion', title: 'Z 字形变换', studyTags: ['按行模拟', '方向切换', '字符串'],
    summary: '把字符串按指定行数上下折返排列，再逐行连接得到变换后的字符串。',
    insight: '只需维护当前行和移动方向；到达第一行或最后一行时反转方向。',
    pitfalls: ['行数为一时直接返回原串', '有效行数可能大于字符串长度', '方向应在写入当前字符后按边界切换'],
    solutions: [s('row-simulation', '逐字符折返模拟', '用每行一个构造器记录字符，行指针在上下边界间往返。', ['创建 min(numRows,length) 行', '字符加入当前行', '到达首尾行切换步长正负，最后连接所有行'], 'O(n)', 'O(n)',
      `class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        List<StringBuilder> rows = new ArrayList<>(); for (int row = 0; row < numRows; row++) rows.add(new StringBuilder());
        int row = 0, step = 1;
        for (char value : s.toCharArray()) { rows.get(row).append(value); if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        StringBuilder answer = new StringBuilder(); for (StringBuilder value : rows) answer.append(value); return answer.toString();
    }
}`,
      `class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length) return s
        val rows = List(numRows) { StringBuilder() }; var row = 0; var step = 1
        for (value in s) { rows[row].append(value); if (row == 0) step = 1 else if (row == numRows - 1) step = -1; row += step }
        return rows.joinToString("")
    }
}`,
      `class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || numRows >= (int)s.size()) return s;
        vector<string> rows(numRows); int row = 0, step = 1;
        for (char value : s) { rows[row] += value; if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        return accumulate(rows.begin(), rows.end(), string());
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'convert', parameterTypes: ['string','int'], returnType: 'string', cases: [
      { name: '三行折返', args: ['PAYPALISHIRING',3], expected: 'PAHNAPLSIIGYIR' }, { name: '四行折返', args: ['PAYPALISHIRING',4], expected: 'PINALSIGYAHRPI' }, { name: '单行不变', args: ['A',1], expected: 'A' },
    ] },
  },
  {
    id: 7, slug: 'reverse-integer', title: '整数反转', studyTags: ['数字反转', '溢出判断', '十进制'],
    summary: '反转 32 位有符号整数的十进制数字，结果溢出 32 位范围时返回零。',
    insight: '逐位取余构造反转值，并用更宽的长整型暂存以检测最终范围。',
    pitfalls: ['负数取余得到负数位，可用同一循环处理', '反转后的前导零自然消失', '溢出时必须返回零'],
    solutions: [s('digit-reversal', '长整型逐位反转', '每轮把末位追加到长整型结果，结束后检查整数边界。', ['digit=x%10', 'answer=answer*10+digit 并令 x/=10', '范围外返回零，否则转换为 int'], 'O(log |x|)', 'O(1)',
      `class Solution {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE ? 0 : (int) answer;
    }
}`,
      `class Solution {
    fun reverse(input: Int): Int {
        var x = input; var answer = 0L
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10 }
        return if (answer < Int.MIN_VALUE || answer > Int.MAX_VALUE) 0 else answer.toInt()
    }
}`,
      `class Solution {
public:
    int reverse(int x) {
        long long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < INT_MIN || answer > INT_MAX ? 0 : answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'reverse', parameterTypes: ['int'], returnType: 'int', cases: [
      { name: '正整数反转', args: [123], expected: 321 }, { name: '负整数反转', args: [-123], expected: -321 }, { name: '反转后溢出', args: [1534236469], expected: 0 },
    ] },
  },
  {
    id: 12, slug: 'integer-to-roman', title: '整数转罗马数字', studyTags: ['贪心', '符号表', '减法组合'],
    summary: '把给定范围内的正整数转换为标准罗马数字表示。',
    insight: '把普通符号和六种减法组合一起按数值降序排列，反复取当前最大可用符号即可。',
    pitfalls: ['必须把 4、9、40 等减法组合放进符号表', '每个数值可能重复使用', '符号选择顺序必须从大到小'],
    solutions: [s('greedy-symbol-table', '降序符号贪心', '按降序表不断减去最大不超过剩余值的数并追加符号。', ['准备数值与符号对应表', '对每项在剩余值足够时重复追加', '剩余值归零后返回结果'], 'O(1)', 'O(1)',
      `class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < values.length; index++) while (num >= values[index]) { num -= values[index]; answer.append(symbols[index]); }
        return answer.toString();
    }
}`,
      `class Solution {
    fun intToRoman(input: Int): String {
        val values = intArrayOf(1000,900,500,400,100,90,50,40,10,9,5,4,1); val symbols = arrayOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
        var num = input; val answer = StringBuilder()
        for (index in values.indices) while (num >= values[index]) { num -= values[index]; answer.append(symbols[index]) }
        return answer.toString()
    }
}`,
      `class Solution {
public:
    string intToRoman(int num) {
        vector<int> values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; vector<string> symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; string answer;
        for (int index = 0; index < (int)values.size(); ++index) while (num >= values[index]) { num -= values[index]; answer += symbols[index]; }
        return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'intToRoman', parameterTypes: ['int'], returnType: 'string', cases: [
      { name: '包含四的减法组合', args: [3749], expected: 'MMMDCCXLIX' }, { name: '五十八', args: [58], expected: 'LVIII' }, { name: '多个减法组合', args: [1994], expected: 'MCMXCIV' },
    ] },
  },
  {
    id: 14, slug: 'longest-common-prefix', title: '最长公共前缀', studyTags: ['纵向扫描', '字符串数组', '边界'],
    summary: '返回字符串数组中所有字符串共有的最长开头片段，不存在时返回空串。',
    insight: '以第一个字符串为基准逐列比较；任一字符串结束或字符不同，当前位置就是公共前缀终点。',
    pitfalls: ['最短字符串限制了最大前缀长度', '数组至少含一个字符串', '空字符串会立即得到空前缀'],
    solutions: [s('vertical-scan', '逐列纵向扫描', '对基准串的每个字符检查所有其他字符串同位置字符。', ['遍历第一个字符串的字符下标', '检查每个其他字符串是否越界或不相等', '首次失败返回基准串前缀，否则返回整个基准串'], 'O(total characters checked)', 'O(1)',
      `class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int index = 0; index < first.length(); index++) for (int item = 1; item < strs.length; item++) if (index == strs[item].length() || strs[item].charAt(index) != first.charAt(index)) return first.substring(0, index);
        return first;
    }
}`,
      `class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val first = strs[0]
        for (index in first.indices) for (item in 1 until strs.size) if (index == strs[item].length || strs[item][index] != first[index]) return first.substring(0, index)
        return first
    }
}`,
      `class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        const string& first = strs[0];
        for (int index = 0; index < (int)first.size(); ++index) for (int item = 1; item < (int)strs.size(); ++item) if (index == (int)strs[item].size() || strs[item][index] != first[index]) return first.substr(0, index);
        return first;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'longestCommonPrefix', parameterTypes: ['stringArray'], returnType: 'string', cases: [
      { name: '共有两个字符前缀', args: [['flower','flow','flight']], expected: 'fl' }, { name: '没有公共前缀', args: [['dog','racecar','car']], expected: '' }, { name: '单字符串', args: [['alone']], expected: 'alone' },
    ] },
  },
  {
    id: 16, slug: '3sum-closest', title: '最接近的三数之和', studyTags: ['排序', '双指针', '距离更新'],
    summary: '从整数数组中选择三个不同位置，使三数之和与目标值最接近，并返回该和。',
    insight: '排序后固定一个数，用双指针按当前和与目标的大小单调移动，并持续更新绝对距离更小的和。',
    pitfalls: ['返回的是三数之和而不是距离', '恰好命中目标可立即返回', '比较距离时用长整型更稳妥'],
    solutions: [s('sort-two-pointers', '排序 + 双指针', '固定首元素后在线性区间内寻找最接近目标的两数和。', ['数组排序并初始化 best', '枚举 first，左右指针求当前和', '距离更小时更新；和偏小左移，偏大右移'], 'O(n²)', 'O(log n)',
      `class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length - 2; first++) { int left = first + 1, right = nums.length - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (Math.abs((long)sum - target) < Math.abs((long)best - target)) best = sum; if (sum == target) return target; if (sum < target) left++; else right--; } }
        return best;
    }
}`,
      `class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort(); var best = nums[0] + nums[1] + nums[2]
        for (first in 0 until nums.size - 2) { var left = first + 1; var right = nums.lastIndex; while (left < right) { val sum = nums[first] + nums[left] + nums[right]; if (kotlin.math.abs(sum.toLong() - target) < kotlin.math.abs(best.toLong() - target)) best = sum; if (sum == target) return target; if (sum < target) left++ else right-- } }
        return best
    }
}`,
      `class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end()); int best = nums[0] + nums[1] + nums[2];
        for (int first = 0; first + 2 < (int)nums.size(); ++first) { int left = first + 1, right = nums.size() - 1; while (left < right) { int sum = nums[first] + nums[left] + nums[right]; if (llabs((long long)sum - target) < llabs((long long)best - target)) best = sum; if (sum == target) return target; if (sum < target) ++left; else --right; } }
        return best;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'threeSumClosest', parameterTypes: ['intArray','int'], returnType: 'int', cases: [
      { name: '最接近目标二', args: [[-1,2,1,-4],1], expected: 2 }, { name: '全零数组', args: [[0,0,0],1], expected: 0 }, { name: '恰好命中目标', args: [[1,1,1,0],-100], expected: 2 },
    ] },
  },
] }
