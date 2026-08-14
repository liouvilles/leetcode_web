import type { Problem } from '../types'

export const arrayProblems: Problem[] = [
  {
    id: 1,
    slug: 'two-sum',
    title: '两数之和',
    titleEn: 'Two Sum',
    difficulty: '简单',
    category: '数组与哈希',
    officialTags: ['数组', '哈希表'],
    studyTags: ['查找互补值', '空间换时间', '入门必做'],
    summary: '在整数数组中找到两个不同位置，使它们的元素之和等于目标值，并返回这两个位置。',
    insight: '枚举当前数字时，真正需要查找的不是另一个数字本身，而是 target - nums[i]。',
    pitfalls: ['不能重复使用同一位置', '先查询再写入哈希表可自然规避重复使用', '排序法必须保留原下标'],
    sourceUrl: 'https://leetcode.cn/problems/two-sum/',
    solutions: [
      {
        id: 'brute-force',
        title: '双重枚举',
        kind: '基础',
        idea: '枚举所有下标对，直接检查它们的和。这是最容易验证的基线解法。',
        steps: ['固定第一个下标 i', '从 i + 1 开始枚举 j', '命中目标和后立即返回'],
        complexity: { time: 'O(n²)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}`,
          kotlin: `class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}`,
          cpp: `class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < (int)nums.size(); ++i) {
            for (int j = i + 1; j < (int)nums.size(); ++j) {
                if (nums[i] + nums[j] == target) return {i, j};
            }
        }
        return {};
    }
};`,
        },
      },
      {
        id: 'one-pass-hash',
        title: '一次遍历哈希表',
        kind: '最优',
        idea: '哈希表记录已经见过的数字及其下标；处理当前元素时只需寻找互补值。',
        steps: ['计算 complement = target - nums[i]', '在表中查询 complement', '未命中则记录 nums[i] 与 i'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }
}`,
          kotlin: `class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            seen[complement]?.let { return intArrayOf(it, i) }
            seen[nums[i]] = i
        }
        return intArrayOf()
    }
}`,
          cpp: `class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;
        for (int i = 0; i < (int)nums.size(); ++i) {
            int complement = target - nums[i];
            auto it = seen.find(complement);
            if (it != seen.end()) return {it->second, i};
            seen[nums[i]] = i;
        }
        return {};
    }
};`,
        },
      },
      {
        id: 'sort-two-pointers',
        title: '排序 + 双指针',
        kind: '进阶',
        idea: '把值与原下标绑定后排序，再根据当前和的大小移动左右指针。',
        steps: ['建立 (值, 原下标) 数组并排序', '左右端点求和', '和偏小移动左端，偏大移动右端'],
        complexity: { time: 'O(n log n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) pairs[i] = new int[] {nums[i], i};
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) return new int[] {pairs[left][1], pairs[right][1]};
            if (sum < target) left++; else right--;
        }
        return new int[0];
    }
}`,
          kotlin: `class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairs = nums.mapIndexed { index, value -> intArrayOf(value, index) }
            .sortedBy { it[0] }
        var left = 0
        var right = pairs.lastIndex
        while (left < right) {
            val sum = pairs[left][0] + pairs[right][0]
            when {
                sum == target -> return intArrayOf(pairs[left][1], pairs[right][1])
                sum < target -> left++
                else -> right--
            }
        }
        return intArrayOf()
    }
}`,
          cpp: `class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> pairs;
        for (int i = 0; i < (int)nums.size(); ++i) pairs.push_back({nums[i], i});
        sort(pairs.begin(), pairs.end());
        int left = 0, right = (int)pairs.size() - 1;
        while (left < right) {
            int sum = pairs[left].first + pairs[right].first;
            if (sum == target) return {pairs[left].second, pairs[right].second};
            if (sum < target) ++left; else --right;
        }
        return {};
    }
};`,
        },
      },
    ],
  },
  {
    id: 3,
    slug: 'longest-substring-without-repeating-characters',
    title: '无重复字符的最长子串',
    titleEn: 'Longest Substring Without Repeating Characters',
    difficulty: '中等',
    category: '滑动窗口',
    officialTags: ['字符串', '哈希表', '滑动窗口'],
    studyTags: ['不定长窗口', '维护区间合法性', '下标跳跃'],
    summary: '寻找字符串中不包含重复字符的最长连续片段，返回它的长度。',
    insight: '窗口右端持续扩展；一旦重复，只需让左端越过冲突字符上一次出现的位置。',
    pitfalls: ['子串必须连续', '左边界只能向右移动，不能被旧记录拉回', 'Java 与 Kotlin 的 Char 可直接作为哈希键'],
    sourceUrl: 'https://leetcode.cn/problems/longest-substring-without-repeating-characters/',
    solutions: [
      {
        id: 'window-set',
        title: '集合维护窗口',
        kind: '基础',
        idea: '集合保存当前窗口内的字符；遇到重复时逐个移除左端字符。',
        steps: ['尝试加入右端字符', '若重复则收缩左端直至合法', '更新最大窗口长度'],
        complexity: { time: 'O(n)', space: 'O(|Σ|)' },
        code: {
          java: `class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val window = HashSet<Char>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            while (s[right] in window) window.remove(s[left++])
            window.add(s[right])
            best = maxOf(best, right - left + 1)
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> window;
        int left = 0, best = 0;
        for (int right = 0; right < (int)s.size(); ++right) {
            while (window.count(s[right])) window.erase(s[left++]);
            window.insert(s[right]);
            best = max(best, right - left + 1);
        }
        return best;
    }
};`,
        },
      },
      {
        id: 'last-position',
        title: '记录最后位置',
        kind: '最优',
        idea: '保存每个字符最近出现的下标，让左边界一步跳过冲突点。',
        steps: ['读取当前字符的最近位置', '令 left = max(left, last + 1)', '记录新位置并更新答案'],
        complexity: { time: 'O(n)', space: 'O(|Σ|)' },
        code: {
          java: `class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last.containsKey(c)) left = Math.max(left, last.get(c) + 1);
            last.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val last = HashMap<Char, Int>()
        var left = 0
        var best = 0
        for (right in s.indices) {
            val c = s[right]
            left = maxOf(left, (last[c] ?: -1) + 1)
            last[c] = right
            best = maxOf(best, right - left + 1)
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> last;
        int left = 0, best = 0;
        for (int right = 0; right < (int)s.size(); ++right) {
            if (last.count(s[right])) left = max(left, last[s[right]] + 1);
            last[s[right]] = right;
            best = max(best, right - left + 1);
        }
        return best;
    }
};`,
        },
      },
    ],
  },
  {
    id: 42,
    slug: 'trapping-rain-water',
    title: '接雨水',
    titleEn: 'Trapping Rain Water',
    difficulty: '困难',
    category: '双指针',
    officialTags: ['栈', '数组', '双指针', '动态规划', '单调栈'],
    studyTags: ['前后缀最大值', '短板原理', '空间优化'],
    summary: '给定一组非负柱高，计算下雨后这些柱子之间能够留住的水量。',
    insight: '位置 i 的水位由左侧最高柱和右侧最高柱中的较矮者决定，再减去当前位置高度。',
    pitfalls: ['边界位置无法蓄水', '累加的是每个位置上方的水量', '双指针移动哪侧取决于两侧当前高度'],
    sourceUrl: 'https://leetcode.cn/problems/trapping-rain-water/',
    solutions: [
      {
        id: 'enumerate-columns',
        title: '逐列向两侧扫描',
        kind: '基础',
        idea: '对每个内部位置分别扫描左侧和右侧最高柱，再计算这一列能够容纳的水。',
        steps: ['枚举每个非边界位置', '向两侧扫描得到 leftMax 与 rightMax', '累加 min(leftMax, rightMax) - height[i]'],
        complexity: { time: 'O(n²)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int trap(int[] height) {
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left <= i; left++) leftMax = Math.max(leftMax, height[left]);
            for (int right = i; right < height.length; right++) rightMax = Math.max(rightMax, height[right]);
            water += Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}`,
          kotlin: `class Solution {
    fun trap(height: IntArray): Int {
        var water = 0
        for (i in 1 until height.lastIndex) {
            var leftMax = 0
            var rightMax = 0
            for (left in 0..i) leftMax = maxOf(leftMax, height[left])
            for (right in i..height.lastIndex) rightMax = maxOf(rightMax, height[right])
            water += minOf(leftMax, rightMax) - height[i]
        }
        return water
    }
}`,
          cpp: `class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        for (int i = 1; i + 1 < (int)height.size(); ++i) {
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left <= i; ++left) leftMax = max(leftMax, height[left]);
            for (int right = i; right < (int)height.size(); ++right) rightMax = max(rightMax, height[right]);
            water += min(leftMax, rightMax) - height[i];
        }
        return water;
    }
};`,
        },
      },
      {
        id: 'prefix-suffix-max',
        title: '前后缀最大值',
        kind: '进阶',
        idea: '预先计算每个位置左侧与右侧最高柱，把重复扫描变成常数时间查询。',
        steps: ['从左到右构造 leftMax', '从右到左构造 rightMax', '逐位置计算并累加水量'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; i++) water += Math.min(leftMax[i], rightMax[i]) - height[i];
        return water;
    }
}`,
          kotlin: `class Solution {
    fun trap(height: IntArray): Int {
        val leftMax = IntArray(height.size)
        val rightMax = IntArray(height.size)
        leftMax[0] = height[0]
        for (i in 1 until height.size) leftMax[i] = maxOf(leftMax[i - 1], height[i])
        rightMax[height.lastIndex] = height.last()
        for (i in height.lastIndex - 1 downTo 0) rightMax[i] = maxOf(rightMax[i + 1], height[i])
        var water = 0
        for (i in height.indices) water += minOf(leftMax[i], rightMax[i]) - height[i]
        return water
    }
}`,
          cpp: `class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> leftMax(n), rightMax(n);
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) leftMax[i] = max(leftMax[i - 1], height[i]);
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) rightMax[i] = max(rightMax[i + 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; ++i) water += min(leftMax[i], rightMax[i]) - height[i];
        return water;
    }
};`,
        },
      },
      {
        id: 'two-pointers',
        title: '双指针空间优化',
        kind: '最优',
        idea: '较矮一侧的最高值已经足以确定该侧当前位置水量，因此可以边移动边结算。',
        steps: ['左右指针从两端出发并维护两侧最高值', '处理当前高度较矮的一侧', '用该侧最高值减去当前高度并移动指针'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
}`,
          kotlin: `class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var leftMax = 0
        var rightMax = 0
        var water = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = maxOf(leftMax, height[left])
                water += leftMax - height[left++]
            } else {
                rightMax = maxOf(rightMax, height[right])
                water += rightMax - height[right--]
            }
        }
        return water
    }
}`,
          cpp: `class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = max(leftMax, height[left]);
                water += leftMax - height[left++];
            } else {
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right--];
            }
        }
        return water;
    }
};`,
        },
      },
    ],
  },
  {
    id: 53,
    slug: 'maximum-subarray',
    title: '最大子数组和',
    titleEn: 'Maximum Subarray',
    difficulty: '中等',
    category: '动态规划',
    officialTags: ['数组', '动态规划', '分治'],
    studyTags: ['Kadane', '以当前位置结尾', '状态压缩'],
    summary: '在数组的所有非空连续片段中，求元素总和的最大值。',
    insight: '以 i 结尾的最优片段，要么只包含 nums[i]，要么接在以 i-1 结尾的最优片段之后。',
    pitfalls: ['数组可能全为负数，答案不能初始化为 0', '求的是连续片段', '先更新当前状态再更新全局答案'],
    sourceUrl: 'https://leetcode.cn/problems/maximum-subarray/',
    solutions: [
      {
        id: 'dp-array',
        title: '动态规划数组',
        kind: '基础',
        idea: 'dp[i] 表示必须以 i 结尾的最大子数组和，显式保存每个状态。',
        steps: ['初始化 dp[0]', '在重新开始与接续前一状态之间取最大值', '扫描所有 dp 状态求全局最大值'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int best = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        var best = dp[0]
        for (i in 1 until nums.size) {
            dp[i] = maxOf(nums[i], dp[i - 1] + nums[i])
            best = maxOf(best, dp[i])
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        int best = dp[0];
        for (int i = 1; i < (int)nums.size(); ++i) {
            dp[i] = max(nums[i], dp[i - 1] + nums[i]);
            best = max(best, dp[i]);
        }
        return best;
    }
};`,
        },
      },
      {
        id: 'kadane',
        title: 'Kadane 状态压缩',
        kind: '最优',
        idea: '当前状态只依赖前一个状态，因此用一个变量代替整个 dp 数组。',
        steps: ['current 保存以上一位置结尾的最优和', '决定接续还是从当前元素重启', '同步维护 best'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var current = nums[0]
        var best = nums[0]
        for (i in 1 until nums.size) {
            current = maxOf(nums[i], current + nums[i])
            best = maxOf(best, current)
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < (int)nums.size(); ++i) {
            current = max(nums[i], current + nums[i]);
            best = max(best, current);
        }
        return best;
    }
};`,
        },
      },
    ],
  },
  {
    id: 121,
    slug: 'best-time-to-buy-and-sell-stock',
    title: '买卖股票的最佳时机',
    titleEn: 'Best Time to Buy and Sell Stock',
    difficulty: '简单',
    category: '数组与贪心',
    officialTags: ['数组', '动态规划'],
    studyTags: ['前缀最值', '单次交易', '贪心'],
    summary: '只能先买入再卖出一次，根据每日价格求可获得的最大利润，也可以选择不交易。',
    insight: '把每一天当作卖出日，最优买入价就是它之前出现过的最低价格。',
    pitfalls: ['买入必须早于卖出', '价格持续下降时答案为 0', '不要把单次交易写成可重复交易'],
    sourceUrl: 'https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/',
    solutions: [
      {
        id: 'enumerate-pairs',
        title: '枚举买卖日',
        kind: '基础',
        idea: '枚举所有合法的买入日和更晚的卖出日，记录最大价差。',
        steps: ['枚举买入位置', '枚举其后的卖出位置', '用价差更新最大利润'],
        complexity: { time: 'O(n²)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        for (int buy = 0; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                best = Math.max(best, prices[sell] - prices[buy]);
            }
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun maxProfit(prices: IntArray): Int {
        var best = 0
        for (buy in prices.indices) {
            for (sell in buy + 1 until prices.size) {
                best = maxOf(best, prices[sell] - prices[buy])
            }
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int best = 0;
        for (int buy = 0; buy < (int)prices.size(); ++buy)
            for (int sell = buy + 1; sell < (int)prices.size(); ++sell)
                best = max(best, prices[sell] - prices[buy]);
        return best;
    }
};`,
        },
      },
      {
        id: 'prefix-min',
        title: '维护前缀最低价',
        kind: '最优',
        idea: '一次扫描，同时维护到目前为止的最低价格和最大利润。',
        steps: ['用首日价格初始化最低价', '计算今天卖出的利润', '更新答案与最低价'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = Math.max(best, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return best;
    }
}`,
          kotlin: `class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var best = 0
        for (price in prices) {
            best = maxOf(best, price - minPrice)
            minPrice = minOf(minPrice, price)
        }
        return best
    }
}`,
          cpp: `class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = prices[0], best = 0;
        for (int price : prices) {
            best = max(best, price - minPrice);
            minPrice = min(minPrice, price);
        }
        return best;
    }
};`,
        },
      },
    ],
  },
  {
    id: 215,
    slug: 'kth-largest-element-in-an-array',
    title: '数组中的第 K 个最大元素',
    titleEn: 'Kth Largest Element in an Array',
    difficulty: '中等',
    category: '选择算法',
    officialTags: ['数组', '堆', '分治', '快速选择'],
    studyTags: ['Top K', '小顶堆', 'Quickselect'],
    summary: '在未排序数组中找到按大小排序后的第 k 个元素，重复值按出现次数计算。',
    insight: '只关心最大的 k 个数时无需完全排序；固定容量的小顶堆或快速选择都能缩小工作量。',
    pitfalls: ['第 k 大对应升序下标 n-k', '重复元素不能去重', '快速选择的平均与最坏复杂度不同'],
    sourceUrl: 'https://leetcode.cn/problems/kth-largest-element-in-an-array/',
    solutions: [
      {
        id: 'min-heap',
        title: '容量为 K 的小顶堆',
        kind: '进阶',
        idea: '堆中始终保留目前最大的 k 个元素，堆顶就是其中最小者。',
        steps: ['把元素加入小顶堆', '容量超过 k 时弹出堆顶', '扫描结束后返回堆顶'],
        complexity: { time: 'O(n log k)', space: 'O(k)' },
        code: {
          java: `class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}`,
          kotlin: `class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = java.util.PriorityQueue<Int>()
        for (num in nums) {
            heap.offer(num)
            if (heap.size > k) heap.poll()
        }
        return heap.peek()
    }
}`,
          cpp: `class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> heap;
        for (int num : nums) {
            heap.push(num);
            if ((int)heap.size() > k) heap.pop();
        }
        return heap.top();
    }
};`,
        },
      },
      {
        id: 'quickselect',
        title: '随机快速选择',
        kind: '最优',
        idea: '利用分区操作只进入目标下标所在的一侧，不必把两侧都排好序。',
        steps: ['把第 k 大换算为升序目标下标 n-k', '随机选择枢轴并分区', '根据枢轴位置缩小搜索边界'],
        complexity: { time: '平均 O(n)，最坏 O(n²)', space: 'O(1)' },
        code: {
          java: `class Solution {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k, left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        throw new IllegalStateException();
    }

    private int partition(int[] a, int left, int right) {
        int pick = left + random.nextInt(right - left + 1);
        swap(a, pick, right);
        int store = left;
        for (int i = left; i < right; i++) if (a[i] < a[right]) swap(a, store++, i);
        swap(a, store, right);
        return store;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}`,
          kotlin: `class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val target = nums.size - k
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val pivot = partition(nums, left, right)
            when {
                pivot == target -> return nums[pivot]
                pivot < target -> left = pivot + 1
                else -> right = pivot - 1
            }
        }
        error("unreachable")
    }

    private fun partition(a: IntArray, left: Int, right: Int): Int {
        val pick = kotlin.random.Random.nextInt(left, right + 1)
        a[pick] = a[right].also { a[right] = a[pick] }
        var store = left
        for (i in left until right) {
            if (a[i] < a[right]) a[store] = a[i].also { a[i] = a[store++] }
        }
        a[store] = a[right].also { a[right] = a[store] }
        return store
    }
}`,
          cpp: `class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        int target = nums.size() - k, left = 0, right = nums.size() - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) return nums[pivot];
            if (pivot < target) left = pivot + 1; else right = pivot - 1;
        }
        return -1;
    }

private:
    int partition(vector<int>& a, int left, int right) {
        int pick = left + rand() % (right - left + 1);
        swap(a[pick], a[right]);
        int store = left;
        for (int i = left; i < right; ++i) if (a[i] < a[right]) swap(a[store++], a[i]);
        swap(a[store], a[right]);
        return store;
    }
};`,
        },
      },
    ],
  },
  {
    id: 283,
    slug: 'move-zeroes',
    title: '移动零',
    titleEn: 'Move Zeroes',
    difficulty: '简单',
    category: '双指针',
    officialTags: ['数组', '双指针'],
    studyTags: ['原地修改', '稳定移动', '快慢指针'],
    summary: '原地把数组中的零移动到末尾，同时保持所有非零元素的相对顺序。',
    insight: '慢指针表示下一个非零元素应该写入的位置，快指针负责发现非零元素。',
    pitfalls: ['必须保持非零元素顺序', '要求原地修改', '覆盖写法结束后要补零'],
    sourceUrl: 'https://leetcode.cn/problems/move-zeroes/',
    solutions: [
      {
        id: 'compact-fill',
        title: '压缩后补零',
        kind: '基础',
        idea: '先把非零元素依次写到数组前部，再把剩余位置统一写成零。',
        steps: ['write 指向下一个写入位置', '顺序复制所有非零元素', '将 write 之后的位置补零'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        for (int num : nums) if (num != 0) nums[write++] = num;
        while (write < nums.length) nums[write++] = 0;
    }
}`,
          kotlin: `class Solution {
    fun moveZeroes(nums: IntArray) {
        var write = 0
        for (num in nums) if (num != 0) nums[write++] = num
        while (write < nums.size) nums[write++] = 0
    }
}`,
          cpp: `class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int write = 0;
        for (int num : nums) if (num != 0) nums[write++] = num;
        while (write < (int)nums.size()) nums[write++] = 0;
    }
};`,
        },
      },
      {
        id: 'swap-two-pointers',
        title: '交换式快慢指针',
        kind: '最优',
        idea: '每发现一个非零元素，就与慢指针位置交换；每个位置最多处理一次。',
        steps: ['slow 指向首个未安置位置', 'fast 找到非零元素后交换', 'slow 向前推进'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = temp;
            }
        }
    }
}`,
          kotlin: `class Solution {
    fun moveZeroes(nums: IntArray) {
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast].also { nums[fast] = nums[slow] }
                slow++
            }
        }
    }
}`,
          cpp: `class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int slow = 0;
        for (int fast = 0; fast < (int)nums.size(); ++fast) {
            if (nums[fast] != 0) swap(nums[slow++], nums[fast]);
        }
    }
};`,
        },
      },
    ],
  },
  {
    id: 704,
    slug: 'binary-search',
    title: '二分查找',
    titleEn: 'Binary Search',
    difficulty: '简单',
    category: '二分查找',
    officialTags: ['数组', '二分查找'],
    studyTags: ['有序数组', '闭区间模板', '边界控制'],
    summary: '在升序整数数组中查找目标值；存在则返回下标，否则返回 -1。',
    insight: '每次比较都能排除一半候选区间，关键是区间定义与循环条件保持一致。',
    pitfalls: ['闭区间模板使用 left <= right', '计算中点时避免 left + right 溢出', '更新边界必须排除 mid'],
    sourceUrl: 'https://leetcode.cn/problems/binary-search/',
    solutions: [
      {
        id: 'iterative',
        title: '迭代二分',
        kind: '最优',
        idea: '维护包含目标候选位置的闭区间 [left, right]，直到区间为空。',
        steps: ['计算安全中点', '命中则返回', '根据大小关系排除左半或右半'],
        complexity: { time: 'O(log n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1; else right = mid - 1;
        }
        return -1;
    }
}`,
          kotlin: `class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }
}`,
          cpp: `class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1; else right = mid - 1;
        }
        return -1;
    }
};`,
        },
      },
      {
        id: 'recursive',
        title: '递归二分',
        kind: '进阶',
        idea: '把每次缩小后的区间交给下一层递归处理，结构接近数学定义。',
        steps: ['区间为空时返回 -1', '比较中点', '递归进入仍可能包含目标的一半'],
        complexity: { time: 'O(log n)', space: 'O(log n)' },
        code: {
          java: `class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] < target
            ? search(nums, target, mid + 1, right)
            : search(nums, target, left, mid - 1);
    }
}`,
          kotlin: `class Solution {
    fun search(nums: IntArray, target: Int): Int =
        search(nums, target, 0, nums.lastIndex)

    private fun search(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        return if (nums[mid] < target) search(nums, target, mid + 1, right)
        else search(nums, target, left, mid - 1)
    }
}`,
          cpp: `class Solution {
public:
    int search(vector<int>& nums, int target) {
        return search(nums, target, 0, nums.size() - 1);
    }

private:
    int search(vector<int>& nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] < target ? search(nums, target, mid + 1, right)
                                  : search(nums, target, left, mid - 1);
    }
};`,
        },
      },
    ],
  },
]
