const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 300, slug: 'longest-increasing-subsequence', title: '最长递增子序列',
      studyTags: ['贪心', '二分查找', '最小结尾'],
      summary: '求整数数组中严格递增子序列的最大长度，子序列元素不要求连续。',
      insight: '对每个长度维护可能的最小结尾值；结尾越小越容易接入后续元素，新值用二分替换第一个不小于它的位置。',
      pitfalls: ['子序列不要求连续', '严格递增要求使用 lower bound', 'tails 保存的是最优结尾而不一定是原序列中的最终答案序列'],
      solutions: [s('patience-binary-search', '最小结尾二分', '最优', '用 tails[length-1] 表示长度为 length 的递增子序列最小末值。', ['在有效 tails 中找首个 >= value 的位置', '存在则用 value 替换', '不存在则把有效长度加一'], 'O(n log n)', 'O(n)',
        `class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length]; int size = 0;
        for (int value : nums) { int left = 0, right = size; while (left < right) { int middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1; else right = middle; } tails[left] = value; if (left == size) size++; }
        return size;
    }
}`,
        `class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = IntArray(nums.size); var size = 0
        for (value in nums) { var left = 0; var right = size; while (left < right) { val middle = left + (right - left) / 2; if (tails[middle] < value) left = middle + 1 else right = middle }; tails[left] = value; if (left == size) size++ }
        return size
    }
}`,
        `class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> tails;
        for (int value : nums) { auto position = lower_bound(tails.begin(), tails.end(), value); if (position == tails.end()) tails.push_back(value); else *position = value; }
        return tails.size();
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'lengthOfLIS', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '多次下降后形成长度四', args: [[10, 9, 2, 5, 3, 7, 101, 18]], expected: 4 },
        { name: '多个等值不增加长度', args: [[0, 1, 0, 3, 2, 3]], expected: 4 },
        { name: '全相等数组', args: [[7, 7, 7, 7]], expected: 1 },
      ] },
    },
    {
      id: 347, slug: 'top-k-frequent-elements', title: '前 K 个高频元素',
      studyTags: ['桶排序', '频次统计', '线性选择'],
      summary: '返回整数数组中出现频率最高的 k 个不同元素，答案顺序不限。',
      insight: '元素频率最大不超过数组长度，可以把频率作为桶下标，再从高频桶向低频桶收集。',
      pitfalls: ['k 指不同元素数量', '同频元素的输出顺序不影响正确性', '收集到 k 个后应立即结束'],
      solutions: [s('frequency-buckets', '频率桶', '最优', '先按首次出现顺序计数，再把元素放进对应频率的桶中。', ['统计每个元素频率', '将元素加入 buckets[frequency]', '从最高频桶向下收集 k 个元素'], 'O(n)', 'O(n)',
        `class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new LinkedHashMap<>(); for (int value : nums) counts.put(value, counts.getOrDefault(value, 0) + 1);
        List<List<Integer>> buckets = new ArrayList<>(); for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) buckets.get(entry.getValue()).add(entry.getKey());
        int[] answer = new int[k]; int index = 0;
        for (int frequency = nums.length; frequency > 0 && index < k; frequency--) for (int value : buckets.get(frequency)) { answer[index++] = value; if (index == k) break; }
        return answer;
    }
}`,
        `class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = linkedMapOf<Int, Int>(); for (value in nums) counts[value] = (counts[value] ?: 0) + 1
        val buckets = List(nums.size + 1) { ArrayList<Int>() }; for ((value, frequency) in counts) buckets[frequency].add(value)
        val answer = IntArray(k); var index = 0
        for (frequency in nums.size downTo 1) for (value in buckets[frequency]) { if (index < k) answer[index++] = value }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts; vector<int> order;
        for (int value : nums) { if (!counts.count(value)) order.push_back(value); ++counts[value]; }
        vector<vector<int>> buckets(nums.size() + 1); for (int value : order) buckets[counts[value]].push_back(value);
        vector<int> answer; answer.reserve(k);
        for (int frequency = nums.size(); frequency > 0 && (int)answer.size() < k; --frequency) for (int value : buckets[frequency]) { if ((int)answer.size() < k) answer.push_back(value); }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'topKFrequent', parameterTypes: ['intArray', 'int'], returnType: 'intArray', cases: [
        { name: '两种最高频元素', args: [[1, 1, 1, 2, 2, 3], 2], expected: [1, 2] },
        { name: '单元素数组', args: [[1], 1], expected: [1] },
        { name: '包含负数且频率不同', args: [[4, 4, -1, -1, -1, 2], 2], expected: [-1, 4] },
      ] },
    },
    {
      id: 394, slug: 'decode-string', title: '字符串解码',
      studyTags: ['栈', '嵌套结构', '多位数字'],
      summary: '把 k[片段] 形式的编码字符串展开，编码可以嵌套且重复次数可能有多位。',
      insight: '遇到左括号时保存外层已构造字符串和重复次数，右括号时完成当前层并拼回外层。',
      pitfalls: ['重复次数可能超过一位', '嵌套层需要成对保存次数和字符串', '普通字母直接追加到当前层'],
      solutions: [s('two-stacks', '次数栈 + 字符串栈', '最优', '扫描字符并在括号边界切换当前构造层。', ['数字连续累积为 repeat', '左括号时压入外层状态并清空当前层', '右括号时弹出状态并重复拼接当前层'], 'O(output length)', 'O(n)',
        `class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>(); Deque<StringBuilder> prefixes = new ArrayDeque<>(); StringBuilder current = new StringBuilder(); int repeat = 0;
        for (char symbol : s.toCharArray()) { if (Character.isDigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push(repeat); prefixes.push(current); current = new StringBuilder(); repeat = 0; } else if (symbol == ']') { int times = counts.pop(); StringBuilder expanded = prefixes.pop(); while (times-- > 0) expanded.append(current); current = expanded; } else current.append(symbol); }
        return current.toString();
    }
}`,
        `class Solution {
    fun decodeString(s: String): String {
        val counts = ArrayDeque<Int>(); val prefixes = ArrayDeque<StringBuilder>(); var current = StringBuilder(); var repeat = 0
        for (symbol in s) { when { symbol.isDigit() -> repeat = repeat * 10 + symbol.digitToInt(); symbol == '[' -> { counts.addLast(repeat); prefixes.addLast(current); current = StringBuilder(); repeat = 0 }; symbol == ']' -> { var times = counts.removeLast(); val expanded = prefixes.removeLast(); while (times-- > 0) expanded.append(current); current = expanded }; else -> current.append(symbol) } }
        return current.toString()
    }
}`,
        `class Solution {
public:
    string decodeString(string s) {
        vector<int> counts; vector<string> prefixes; string current; int repeat = 0;
        for (char symbol : s) { if (isdigit(symbol)) repeat = repeat * 10 + symbol - '0'; else if (symbol == '[') { counts.push_back(repeat); prefixes.push_back(current); current.clear(); repeat = 0; } else if (symbol == ']') { int times = counts.back(); counts.pop_back(); string expanded = prefixes.back(); prefixes.pop_back(); while (times-- > 0) expanded += current; current = move(expanded); } else current.push_back(symbol); }
        return current;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'decodeString', parameterTypes: ['string'], returnType: 'string', cases: [
        { name: '两个连续编码片段', args: ['3[a]2[bc]'], expected: 'aaabcbc' },
        { name: '嵌套编码', args: ['3[a2[c]]'], expected: 'accaccacc' },
        { name: '多位重复次数', args: ['10[a]'], expected: 'aaaaaaaaaa' },
      ] },
    },
    {
      id: 416, slug: 'partition-equal-subset-sum', title: '分割等和子集',
      studyTags: ['0-1 背包', '可达性 DP', '倒序枚举'],
      summary: '判断正整数数组能否划分为两个元素和相等的子集。',
      insight: '总和必须为偶数，问题等价于是否能从每个元素至多选一次凑出总和的一半。',
      pitfalls: ['总和为奇数可直接失败', '容量必须倒序更新以防重复使用当前元素', 'dp[0] 初始为真'],
      solutions: [s('zero-one-knapsack', '一维 0-1 背包', '最优', '布尔数组记录使用已处理元素能否凑出每个容量。', ['计算总和并排除奇数', 'target=sum/2 且 possible[0]=true', '对每个值从 target 倒序更新'], 'O(n·sum)', 'O(sum)',
        `class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; for (int value : nums) sum += value; if ((sum & 1) == 1) return false;
        int target = sum / 2; boolean[] possible = new boolean[target + 1]; possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; current--) possible[current] |= possible[current - value];
        return possible[target];
    }
}`,
        `class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum(); if (sum % 2 != 0) return false
        val target = sum / 2; val possible = BooleanArray(target + 1); possible[0] = true
        for (value in nums) for (current in target downTo value) possible[current] = possible[current] || possible[current - value]
        return possible[target]
    }
}`,
        `class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0); if (sum & 1) return false;
        int target = sum / 2; vector<bool> possible(target + 1); possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; --current) possible[current] = possible[current] || possible[current - value];
        return possible[target];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'canPartition', parameterTypes: ['intArray'], returnType: 'boolean', cases: [
        { name: '存在等和划分', args: [[1, 5, 11, 5]], expected: true },
        { name: '无法凑出一半总和', args: [[1, 2, 3, 5]], expected: false },
        { name: '两个相等元素', args: [[2, 2]], expected: true },
      ] },
    },
    {
      id: 437, slug: 'path-sum-iii', title: '路径总和 III',
      studyTags: ['前缀和', '树上 DFS', '回溯计数'],
      summary: '统计二叉树中节点值之和等于目标值的向下路径数量；路径可以从任意节点开始，但必须沿父子方向连续。',
      insight: '若当前根到节点前缀和为 current，之前出现过 current-target 的前缀次数就是以当前节点结尾的合法路径数。',
      pitfalls: ['路径不必从根开始或在叶结束', '节点值累加需要长整型', '离开子树时必须撤销当前前缀计数'],
      solutions: [s('prefix-sum-dfs', '树上前缀和回溯', '最优', 'DFS 路径上维护前缀和频次，进入节点增加、退出节点撤销。', ['初始化前缀零出现一次', '累加当前值并查询 current-target', '登记当前前缀、递归孩子、最后撤销'], 'O(n)', 'O(h)',
        `class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> counts = new HashMap<>(); counts.put(0L, 1); return visit(root, 0L, targetSum, counts);
    }
    private int visit(TreeNode node, long prefix, long target, Map<Long, Integer> counts) {
        if (node == null) return 0;
        long current = prefix + node.val; int answer = counts.getOrDefault(current - target, 0); counts.put(current, counts.getOrDefault(current, 0) + 1);
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts);
        counts.put(current, counts.get(current) - 1); return answer;
    }
}`,
        `class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int { val counts = HashMap<Long, Int>(); counts[0L] = 1; return visit(root, 0L, targetSum.toLong(), counts) }
    private fun visit(node: TreeNode?, prefix: Long, target: Long, counts: MutableMap<Long, Int>): Int {
        node ?: return 0
        val current = prefix + node.\`val\`; var answer = counts[current - target] ?: 0; counts[current] = (counts[current] ?: 0) + 1
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts)
        counts[current] = counts.getValue(current) - 1; return answer
    }
}`,
        `class Solution {
    int visit(TreeNode* node, long long prefix, long long target, unordered_map<long long, int>& counts) {
        if (!node) return 0;
        long long current = prefix + node->val; int answer = counts[current - target]; ++counts[current];
        answer += visit(node->left, current, target, counts) + visit(node->right, current, target, counts);
        --counts[current]; return answer;
    }
public:
    int pathSum(TreeNode* root, int targetSum) { unordered_map<long long, int> counts{{0, 1}}; return visit(root, 0, targetSum, counts); }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'pathSum', parameterTypes: ['treeNode', 'int'], returnType: 'int', cases: [
        { name: '多条路径和为八', args: [[10, 5, -3, 3, 2, null, 11, 3, -2, null, 1], 8], expected: 3 },
        { name: '路径可以从中间节点开始', args: [[5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1], 22], expected: 3 },
        { name: '单节点匹配', args: [[1], 1], expected: 1 },
      ] },
    },
  ],
}
