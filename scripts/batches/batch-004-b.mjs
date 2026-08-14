const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default { batchId: 'batch-004', problems: [
  {
    id: 27, slug: 'remove-element', title: '移除元素', studyTags: ['快慢指针', '原地修改', '稳定覆盖'],
    summary: '原地移除数组中等于指定值的元素，并返回保留下来的元素数量。',
    insight: '用写指针维护有效前缀，读指针遇到需要保留的元素时才写入并前进。',
    pitfalls: ['只保证返回长度以内的前缀有效', '空数组应返回零', '覆盖过程不需要额外数组'],
    solutions: [s('stable-compaction', '稳定快慢指针', '读指针扫描全部元素，写指针只记录非目标值。', ['初始化 write=0', '遇到不等于 val 的元素就写入 nums[write]', '返回 write'], 'O(n)', 'O(1)',
      `class Solution {
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int value : nums) if (value != val) nums[write++] = value;
        return write;
    }
}`,
      `class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        var write = 0
        for (item in nums) if (item != value) nums[write++] = item
        return write
    }
}`,
      `class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int write = 0;
        for (int value : nums) if (value != val) nums[write++] = value;
        return write;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'removeElement', parameterTypes: ['intArray','int'], returnType: 'int', cases: [
      { name: '移除首尾目标值', args: [[3,2,2,3],3], expected: 2, expectedArgs: [{ index: 0, type: 'intArray', expected: [2,2,2,3] }] },
      { name: '多次稳定覆盖', args: [[0,1,2,2,3,0,4,2],2], expected: 5, expectedArgs: [{ index: 0, type: 'intArray', expected: [0,1,3,0,4,0,4,2] }] },
      { name: '空数组', args: [[],7], expected: 0, expectedArgs: [{ index: 0, type: 'intArray', expected: [] }] },
    ] },
  },
  {
    id: 28, slug: 'find-the-index-of-the-first-occurrence-in-a-string', title: '找出字符串中第一个匹配项的下标', studyTags: ['字符串匹配', '滑动起点', '逐字符比较'],
    summary: '返回模式串在文本串中第一次完整出现的起始下标，不存在时返回 -1。',
    insight: '枚举所有仍容得下模式串的起点，并逐字符验证；首个完全匹配的位置就是答案。',
    pitfalls: ['起点最多枚举到 n-m', '模式串比文本长时直接不存在', '题目要求第一次出现的位置'],
    solutions: [s('naive-matching', '枚举起点匹配', '从左到右检查每个候选起点，发现完整匹配立即返回。', ['枚举 start 从 0 到 n-m', '比较 needle 的每个字符', '全部相等时返回 start，否则最终返回 -1'], 'O(nm)', 'O(1)',
      `class Solution {
    public int strStr(String haystack, String needle) {
        for (int start = 0; start + needle.length() <= haystack.length(); start++) {
            int index = 0;
            while (index < needle.length() && haystack.charAt(start + index) == needle.charAt(index)) index++;
            if (index == needle.length()) return start;
        }
        return -1;
    }
}`,
      `class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (start in 0..haystack.length - needle.length) {
            var index = 0
            while (index < needle.length && haystack[start + index] == needle[index]) index++
            if (index == needle.length) return start
        }
        return -1
    }
}`,
      `class Solution {
public:
    int strStr(string haystack, string needle) {
        for (int start = 0; start + (int)needle.size() <= (int)haystack.size(); ++start) {
            int index = 0;
            while (index < (int)needle.size() && haystack[start + index] == needle[index]) ++index;
            if (index == (int)needle.size()) return start;
        }
        return -1;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'strStr', parameterTypes: ['string','string'], returnType: 'int', cases: [
      { name: '开头首次匹配', args: ['sadbutsad','sad'], expected: 0 }, { name: '不存在匹配项', args: ['leetcode','leeto'], expected: -1 }, { name: '中间匹配', args: ['mississippi','issip'], expected: 4 },
    ] },
  },
  {
    id: 38, slug: 'count-and-say', title: '外观数列', studyTags: ['游程编码', '字符串模拟', '迭代'],
    summary: '从字符串“1”开始，反复描述上一项中连续相同字符的数量和值，求第 n 项。',
    insight: '每一轮都是对上一字符串做一次游程编码：统计连续段长度，再追加长度和字符。',
    pitfalls: ['描述的是连续分组而非字符总频次', '第一项直接是 1', '每轮末尾的连续段也要写入'],
    solutions: [s('run-length-iteration', '逐轮游程编码', '从第一项开始迭代 n-1 次，每次压缩连续相同字符段。', ['answer 初始化为 1', '扫描连续相同字符的右边界', '追加段长和字符并进入下一轮'], 'O(Ln)', 'O(Ln)',
      `class Solution {
    public String countAndSay(int n) {
        String answer = "1";
        for (int round = 1; round < n; round++) {
            StringBuilder next = new StringBuilder();
            for (int start = 0; start < answer.length();) { int end = start + 1; while (end < answer.length() && answer.charAt(end) == answer.charAt(start)) end++; next.append(end - start).append(answer.charAt(start)); start = end; }
            answer = next.toString();
        }
        return answer;
    }
}`,
      `class Solution {
    fun countAndSay(n: Int): String {
        var answer = "1"
        repeat(n - 1) { val next = StringBuilder(); var start = 0; while (start < answer.length) { var end = start + 1; while (end < answer.length && answer[end] == answer[start]) end++; next.append(end - start).append(answer[start]); start = end }; answer = next.toString() }
        return answer
    }
}`,
      `class Solution {
public:
    string countAndSay(int n) {
        string answer = "1";
        for (int round = 1; round < n; ++round) { string next; for (int start = 0; start < (int)answer.size();) { int end = start + 1; while (end < (int)answer.size() && answer[end] == answer[start]) ++end; next += to_string(end - start); next += answer[start]; start = end; } answer = next; }
        return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'countAndSay', parameterTypes: ['int'], returnType: 'string', cases: [
      { name: '第一项', args: [1], expected: '1' }, { name: '第四项', args: [4], expected: '1211' }, { name: '第六项', args: [6], expected: '312211' },
    ] },
  },
  {
    id: 50, slug: 'powx-n', title: 'Pow(x, n)', studyTags: ['快速幂', '二进制拆分', '负指数'],
    summary: '计算浮点数 x 的整数次幂，并正确处理负指数和 32 位指数边界。',
    insight: '把指数按二进制拆分；每轮平方底数，当前位为一时乘入答案，使乘法次数降为对数级。',
    pitfalls: ['先把指数转成长整型再取负，避免最小整数溢出', '负指数等价于底数取倒数', '指数为零时结果为一'],
    solutions: [s('binary-exponentiation', '迭代快速幂', '用指数二进制位决定是否乘入当前底数，并逐轮平方。', ['将 n 转为 long，负数时底数取倒数并翻转指数', '若当前最低位为一则 answer*=base', 'base 自乘，指数右移'], 'O(log |n|)', 'O(1)',
      `class Solution {
    public double myPow(double x, int n) {
        long power = n; if (power < 0) { x = 1.0 / x; power = -power; }
        double answer = 1.0;
        while (power > 0) { if ((power & 1) == 1) answer *= x; x *= x; power >>= 1; }
        return answer;
    }
}`,
      `class Solution {
    fun myPow(input: Double, n: Int): Double {
        var base = input; var power = n.toLong(); if (power < 0) { base = 1.0 / base; power = -power }
        var answer = 1.0
        while (power > 0) { if (power and 1L == 1L) answer *= base; base *= base; power = power shr 1 }
        return answer
    }
}`,
      `class Solution {
public:
    double myPow(double x, int n) {
        long long power = n; if (power < 0) { x = 1.0 / x; power = -power; }
        double answer = 1.0;
        while (power > 0) { if (power & 1LL) answer *= x; x *= x; power >>= 1; }
        return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'myPow', parameterTypes: ['double','int'], returnType: 'double', cases: [
      { name: '正指数', args: [2.0,10], expected: 1024.0 }, { name: '负指数', args: [2.0,-2], expected: 0.25 }, { name: '负底数奇数次幂', args: [-2.0,3], expected: -8.0 },
    ] },
  },
  {
    id: 58, slug: 'length-of-last-word', title: '最后一个单词的长度', studyTags: ['反向扫描', '字符串', '空格跳过'],
    summary: '给定由单词和空格组成的字符串，返回最后一个单词包含的字符数量。',
    insight: '从末尾先跳过尾随空格，再连续统计非空格字符，避免拆分整个字符串。',
    pitfalls: ['字符串末尾可能有多个空格', '单词之间也可能有多个空格', '只统计最后一段非空格字符'],
    solutions: [s('reverse-scan', '从尾部线性扫描', '定位最后一个单词末尾后向前计数直到空格或开头。', ['index 从末尾开始跳过空格', '持续向前统计非空格字符', '返回计数'], 'O(n)', 'O(1)',
      `class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1; while (index >= 0 && s.charAt(index) == ' ') index--;
        int length = 0; while (index >= 0 && s.charAt(index) != ' ') { length++; index--; }
        return length;
    }
}`,
      `class Solution {
    fun lengthOfLastWord(s: String): Int {
        var index = s.lastIndex; while (index >= 0 && s[index] == ' ') index--
        var length = 0; while (index >= 0 && s[index] != ' ') { length++; index-- }
        return length
    }
}`,
      `class Solution {
public:
    int lengthOfLastWord(string s) {
        int index = s.size() - 1; while (index >= 0 && s[index] == ' ') --index;
        int length = 0; while (index >= 0 && s[index] != ' ') { ++length; --index; }
        return length;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'lengthOfLastWord', parameterTypes: ['string'], returnType: 'int', cases: [
      { name: '普通句子', args: ['Hello World'], expected: 5 }, { name: '包含多余空格', args: ['   fly me   to   the moon  '], expected: 4 }, { name: '单个长单词', args: ['luffy'], expected: 5 },
    ] },
  },
] }
