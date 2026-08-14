const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 162, slug: 'find-peak-element', title: '寻找峰值',
      studyTags: ['二分查找', '局部趋势', '峰值'],
      summary: '在相邻元素互不相等的数组中返回任意一个严格大于左右相邻值的峰值下标，边界外视为负无穷。',
      insight: '若中点小于右邻，沿上坡向右一定能到达峰值；否则中点本身或左侧存在峰值。',
      pitfalls: ['答案可以是任意峰值', '比较 middle 与 middle+1 可避免访问左边界外', '右边界更新为 middle 以保留可能峰值'],
      solutions: [s('slope-binary-search', '沿上坡方向二分', '最优', '根据中点右侧斜率选择必含峰值的一半区间。', ['维护 [left,right] 峰值区间', '上坡则 left=middle+1', '下坡则 right=middle，最终两者相等'], 'O(log n)', 'O(1)',
        `class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1; else right = middle; }
        return left;
    }
}`,
        `class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0; var right = nums.lastIndex
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1 else right = middle }
        return left
    }
}`,
        `class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < nums[middle + 1]) left = middle + 1; else right = middle; }
        return left;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findPeakElement', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '唯一峰值位于中部', args: [[1, 2, 3, 1]], expected: 2 },
        { name: '二分选择右侧峰值', args: [[1, 2, 1, 3, 5, 6, 4]], expected: 5 },
        { name: '单元素是峰值', args: [[1]], expected: 0 },
      ] },
    },
    {
      id: 167, slug: 'two-sum-ii-input-array-is-sorted', title: '两数之和 II：输入有序数组',
      studyTags: ['双指针', '有序数组', '一基下标'],
      summary: '在非递减数组中找出两个不同元素之和等于目标值，并返回从一开始计数的两个下标。',
      insight: '两端之和偏小只能增大左端，偏大只能减小右端，有序性保证不会漏掉唯一答案。',
      pitfalls: ['返回下标从一开始', '不能重复使用同一个元素', '题目保证恰有一个答案'],
      solutions: [s('two-pointers', '相向双指针', '最优', '根据当前两端和与目标的大小单调收缩搜索区间。', ['left=0、right=n-1', '和偏小左移，偏大右移', '命中后返回 left+1 与 right+1'], 'O(n)', 'O(1)',
        `class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) { int sum = numbers[left] + numbers[right]; if (sum == target) return new int[] {left + 1, right + 1}; if (sum < target) left++; else right--; }
        return new int[0];
    }
}`,
        `class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0; var right = numbers.lastIndex
        while (left < right) { val sum = numbers[left] + numbers[right]; if (sum == target) return intArrayOf(left + 1, right + 1); if (sum < target) left++ else right-- }
        return intArrayOf()
    }
}`,
        `class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int left = 0, right = numbers.size() - 1;
        while (left < right) { int sum = numbers[left] + numbers[right]; if (sum == target) return {left + 1, right + 1}; if (sum < target) ++left; else --right; }
        return {};
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'twoSum', parameterTypes: ['intArray', 'int'], returnType: 'intArray', cases: [
        { name: '首两个元素命中', args: [[2, 7, 11, 15], 9], expected: [1, 2] },
        { name: '跨越负数和正数', args: [[-1, 0], -1], expected: [1, 2] },
        { name: '答案位于两端', args: [[1, 2, 3, 4, 4, 9, 56, 90], 8], expected: [4, 5] },
      ] },
    },
    {
      id: 179, slug: 'largest-number', title: '最大数',
      studyTags: ['自定义排序', '字符串拼接', '全零处理'],
      summary: '重新排列非负整数数组，使拼接得到的十进制字符串表示最大的数。',
      insight: '两个字符串 a、b 的相对顺序应比较 a+b 与 b+a，较大的拼接组合放在前面。',
      pitfalls: ['不能按数值大小或普通字典序排序', '全部为零时只返回一个零', '结果可能超过整数范围，必须以字符串返回'],
      solutions: [s('concatenation-comparator', '拼接比较器排序', '最优', '把数字转成字符串后按 b+a 与 a+b 的降序关系排列。', ['转换所有数字为字符串', '自定义比较器决定两两顺序', '首字符为零时返回 0，否则连接全部字符串'], 'O(n log n · k)', 'O(nk)',
        `class Solution {
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length]; for (int index = 0; index < nums.length; index++) values[index] = String.valueOf(nums[index]);
        Arrays.sort(values, (first, second) -> (second + first).compareTo(first + second));
        if (values[0].equals("0")) return "0";
        return String.join("", values);
    }
}`,
        `class Solution {
    fun largestNumber(nums: IntArray): String {
        val values = nums.map(Int::toString).sortedWith(Comparator { first, second -> (second + first).compareTo(first + second) })
        return if (values[0] == "0") "0" else values.joinToString("")
    }
}`,
        `class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> values; for (int value : nums) values.push_back(to_string(value));
        sort(values.begin(), values.end(), [](const string& first, const string& second) { return first + second > second + first; });
        if (values[0] == "0") return "0";
        return accumulate(values.begin(), values.end(), string());
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'largestNumber', parameterTypes: ['intArray'], returnType: 'string', cases: [
        { name: '两个数字比较拼接顺序', args: [[10, 2]], expected: '210' },
        { name: '多种前缀关系', args: [[3, 30, 34, 5, 9]], expected: '9534330' },
        { name: '全零压缩为一个零', args: [[0, 0]], expected: '0' },
      ] },
    },
    {
      id: 190, slug: 'reverse-bits', title: '颠倒二进制位',
      studyTags: ['位运算', '固定 32 位', '无符号右移'],
      summary: '把一个 32 位整数的所有二进制位顺序颠倒并返回结果。',
      insight: '重复 32 次：把答案左移一位并加入输入最低位，再对输入执行无符号右移。',
      pitfalls: ['必须处理固定 32 位，包括前导零', 'Java 和 Kotlin 要使用无符号右移', '循环次数不能根据数值最高位提前结束'],
      solutions: [s('bit-by-bit', '逐位反转', '最优', '每轮从输入低位取一位，按相反顺序追加到结果。', ['结果左移并或上 n&1', '输入无符号右移一位', '固定执行 32 轮'], 'O(32)', 'O(1)',
        `class Solution {
    public int reverseBits(int n) {
        int answer = 0;
        for (int bit = 0; bit < 32; bit++) { answer = (answer << 1) | (n & 1); n >>>= 1; }
        return answer;
    }
}`,
        `class Solution {
    fun reverseBits(input: Int): Int {
        var value = input; var answer = 0
        repeat(32) { answer = (answer shl 1) or (value and 1); value = value ushr 1 }
        return answer
    }
}`,
        `class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t answer = 0;
        for (int bit = 0; bit < 32; ++bit) { answer = (answer << 1) | (n & 1U); n >>= 1; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'reverseBits', parameterTypes: ['int'], returnType: 'int', cases: [
        { name: '普通三十二位模式', args: [43261596], expected: 964176192 },
        { name: '全零位模式', args: [0], expected: 0 },
        { name: '最低第二位移到次高位', args: [2], expected: 1073741824 },
      ] },
    },
    {
      id: 191, slug: 'number-of-1-bits', title: '位 1 的个数',
      studyTags: ['位运算', 'Brian Kernighan', '清除最低位一'],
      summary: '返回 32 位整数二进制表示中值为一的位数。',
      insight: '表达式 value & (value-1) 会清除最低的一个一位，因此循环次数正好等于一位数量。',
      pitfalls: ['输入按 32 位模式处理', '不能依赖算术右移处理负数', '零的答案为零'],
      solutions: [s('clear-lowest-one', '逐次清除最低位一', '最优', '每轮删除一个已设置位并增加计数。', ['answer 初始化为零', 'value 非零时执行 value&=value-1', '每轮计数加一'], 'O(number of 1 bits)', 'O(1)',
        `class Solution {
    public int hammingWeight(int n) {
        int answer = 0;
        while (n != 0) { n &= n - 1; answer++; }
        return answer;
    }
}`,
        `class Solution {
    fun hammingWeight(input: Int): Int {
        var value = input; var answer = 0
        while (value != 0) { value = value and (value - 1); answer++ }
        return answer
    }
}`,
        `class Solution {
public:
    int hammingWeight(int n) {
        unsigned int value = n; int answer = 0;
        while (value) { value &= value - 1; ++answer; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'hammingWeight', parameterTypes: ['int'], returnType: 'int', cases: [
        { name: '三个一位', args: [11], expected: 3 },
        { name: '单个高位一', args: [128], expected: 1 },
        { name: '零没有一位', args: [0], expected: 0 },
      ] },
    },
  ],
}
