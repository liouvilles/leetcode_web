const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 438, slug: 'find-all-anagrams-in-a-string', title: '找到字符串中所有字母异位词',
      studyTags: ['定长滑动窗口', '字符计数', '异位词'],
      summary: '返回字符串 s 中所有与 p 字母异位的连续子串起始下标。',
      insight: '长度固定为 p.length 的窗口若与 p 的 26 个字符频次完全相同，就是一个答案。',
      pitfalls: ['窗口长度必须固定', '右端加入与左端移除要同步更新计数', 'p 比 s 长时直接返回空列表'],
      solutions: [s('fixed-window-counts', '定长计数窗口', '最优', '维护目标频次和当前窗口频次，在每次窗口成形时比较。', ['统计 p 的字符频次', '右端字符加入窗口', '超长时移除 left，长度相等时比较数组'], 'O(26n)', 'O(1)',
        `class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>(); if (p.length() > s.length()) return answer;
        int[] target = new int[26], window = new int[26]; for (char value : p.toCharArray()) target[value - 'a']++;
        for (int right = 0; right < s.length(); right++) { window[s.charAt(right) - 'a']++; if (right >= p.length()) window[s.charAt(right - p.length()) - 'a']--; if (right >= p.length() - 1 && Arrays.equals(target, window)) answer.add(right - p.length() + 1); }
        return answer;
    }
}`,
        `class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()
        val target = IntArray(26); val window = IntArray(26); for (value in p) target[value - 'a']++
        val answer = ArrayList<Int>()
        for (right in s.indices) { window[s[right] - 'a']++; if (right >= p.length) window[s[right - p.length] - 'a']--; if (right >= p.length - 1 && target.contentEquals(window)) answer.add(right - p.length + 1) }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (p.size() > s.size()) return {};
        array<int, 26> target{}, window{}; for (char value : p) ++target[value - 'a']; vector<int> answer;
        for (int right = 0; right < (int)s.size(); ++right) { ++window[s[right] - 'a']; if (right >= (int)p.size()) --window[s[right - p.size()] - 'a']; if (right >= (int)p.size() - 1 && target == window) answer.push_back(right - p.size() + 1); }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findAnagrams', parameterTypes: ['string', 'string'], returnType: 'intList', cases: [
        { name: '两个相距较远的异位词', args: ['cbaebabacd', 'abc'], expected: [0, 6] },
        { name: '重叠异位词', args: ['abab', 'ab'], expected: [0, 1, 2] },
        { name: '模式比文本更长', args: ['a', 'ab'], expected: [] },
      ] },
    },
    {
      id: 543, slug: 'diameter-of-binary-tree', title: '二叉树的直径',
      studyTags: ['后序遍历', '子树高度', '全局最优'],
      summary: '求二叉树中任意两个节点之间最长路径所经过的边数，路径不一定经过根。',
      insight: '以某节点为最高点的最长路径边数等于左子树高度加右子树高度，后序遍历所有节点即可取最大。',
      pitfalls: ['直径按边数而不是节点数计算', '最优路径可能完全位于某个子树', '高度返回较大子树高度加一'],
      solutions: [s('postorder-heights', '后序高度合并', '最优', '递归返回节点高度，并用左右高度之和更新全局直径。', ['空节点高度为零', '递归求左右高度', '更新直径并返回 max(left,right)+1'], 'O(n)', 'O(h)',
        `class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) { diameter = 0; height(root); return diameter; }
    private int height(TreeNode node) { if (node == null) return 0; int left = height(node.left), right = height(node.right); diameter = Math.max(diameter, left + right); return Math.max(left, right) + 1; }
}`,
        `class Solution {
    private var diameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int { diameter = 0; height(root); return diameter }
    private fun height(node: TreeNode?): Int { node ?: return 0; val left = height(node.left); val right = height(node.right); diameter = maxOf(diameter, left + right); return maxOf(left, right) + 1 }
}`,
        `class Solution {
    int diameter = 0;
    int height(TreeNode* node) { if (!node) return 0; int left = height(node->left), right = height(node->right); diameter = max(diameter, left + right); return max(left, right) + 1; }
public:
    int diameterOfBinaryTree(TreeNode* root) { diameter = 0; height(root); return diameter; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'diameterOfBinaryTree', parameterTypes: ['treeNode'], returnType: 'int', cases: [
        { name: '最长路径穿过根', args: [[1, 2, 3, 4, 5]], expected: 3 },
        { name: '两节点树', args: [[1, 2]], expected: 1 },
        { name: '单节点树直径为零', args: [[1]], expected: 0 },
      ] },
    },
    {
      id: 560, slug: 'subarray-sum-equals-k', title: '和为 K 的子数组',
      studyTags: ['前缀和', '哈希计数', '连续子数组'],
      summary: '统计整数数组中元素和恰好等于 k 的非空连续子数组数量。',
      insight: '当前前缀和为 prefix 时，每个此前出现的 prefix-k 都对应一个以当前位置结尾的合法子数组。',
      pitfalls: ['数组包含负数，不能使用普通滑动窗口', '前缀和零需要预先出现一次', '哈希表保存出现次数而不是只保存是否存在'],
      solutions: [s('prefix-frequency', '前缀和频次表', '最优', '边扫描边查询所需旧前缀，再登记当前前缀。', ['counts[0]=1', '累加当前元素到 prefix', '答案增加 counts[prefix-k]，再增加 prefix 频次'], 'O(n)', 'O(n)',
        `class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(); counts.put(0, 1); int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts.getOrDefault(prefix - k, 0); counts.put(prefix, counts.getOrDefault(prefix, 0) + 1); }
        return answer;
    }
}`,
        `class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val counts = HashMap<Int, Int>(); counts[0] = 1; var prefix = 0; var answer = 0
        for (value in nums) { prefix += value; answer += counts[prefix - k] ?: 0; counts[prefix] = (counts[prefix] ?: 0) + 1 }
        return answer
    }
}`,
        `class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> counts{{0, 1}}; int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts[prefix - k]; ++counts[prefix]; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'subarraySum', parameterTypes: ['intArray', 'int'], returnType: 'int', cases: [
        { name: '两个单元素子数组', args: [[1, 1, 1], 2], expected: 2 },
        { name: '不同长度的两个答案', args: [[1, 2, 3], 3], expected: 2 },
        { name: '零和产生多个子数组', args: [[0, 0], 0], expected: 3 },
      ] },
    },
    {
      id: 567, slug: 'permutation-in-string', title: '字符串的排列',
      studyTags: ['定长滑动窗口', '频次差', '排列匹配'],
      summary: '判断字符串 s2 是否包含一个连续子串，它是字符串 s1 的某种排列。',
      insight: '排列长度固定且字符频次不变，维护与 s1 等长窗口的 26 个计数即可判断。',
      pitfalls: ['s1 比 s2 长时必然失败', '窗口每右移一步要同时加入和移除字符', '只比较字符集合会漏掉重复次数'],
      solutions: [s('fixed-frequency-window', '定长频次数组', '最优', '先建立第一个窗口，再逐步滑动并比较频次。', ['统计 s1 与 s2 首窗口频次', '每轮先检查数组是否相等', '加入新右端并移除旧左端'], 'O(26n)', 'O(1)',
        `class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] target = new int[26], window = new int[26];
        for (int index = 0; index < s1.length(); index++) { target[s1.charAt(index) - 'a']++; window[s2.charAt(index) - 'a']++; }
        for (int left = 0; left <= s2.length() - s1.length(); left++) { if (Arrays.equals(target, window)) return true; int next = left + s1.length(); if (next < s2.length()) { window[s2.charAt(left) - 'a']--; window[s2.charAt(next) - 'a']++; } }
        return false;
    }
}`,
        `class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val target = IntArray(26); val window = IntArray(26)
        for (index in s1.indices) { target[s1[index] - 'a']++; window[s2[index] - 'a']++ }
        for (left in 0..s2.length - s1.length) { if (target.contentEquals(window)) return true; val next = left + s1.length; if (next < s2.length) { window[s2[left] - 'a']--; window[s2[next] - 'a']++ } }
        return false
    }
}`,
        `class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.size() > s2.size()) return false;
        array<int, 26> target{}, window{};
        for (int index = 0; index < (int)s1.size(); ++index) { ++target[s1[index] - 'a']; ++window[s2[index] - 'a']; }
        for (int left = 0; left <= (int)s2.size() - (int)s1.size(); ++left) { if (target == window) return true; int next = left + s1.size(); if (next < (int)s2.size()) { --window[s2[left] - 'a']; ++window[s2[next] - 'a']; } }
        return false;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'checkInclusion', parameterTypes: ['string', 'string'], returnType: 'boolean', cases: [
        { name: '中间窗口为一个排列', args: ['ab', 'eidbaooo'], expected: true },
        { name: '没有频次相同窗口', args: ['ab', 'eidboaoo'], expected: false },
        { name: '模式比文本长', args: ['abcd', 'abc'], expected: false },
      ] },
    },
    {
      id: 647, slug: 'palindromic-substrings', title: '回文子串',
      studyTags: ['中心扩展', '回文计数', '奇偶中心'],
      summary: '统计字符串中所有回文连续子串的数量，不同起止位置即视为不同子串。',
      insight: '每个回文子串都有唯一中心，枚举单字符中心和字符间隙中心并向外扩展即可恰好计数一次。',
      pitfalls: ['相同文本但位置不同的子串分别计数', '偶数长度回文中心在两个字符之间', '每成功扩展一层就新增一个回文子串'],
      solutions: [s('expand-centers', '枚举 2n-1 个中心', '最优', '对每个位置分别扩展奇数与偶数回文并累计成功次数。', ['遍历每个字符位置', '从 (center,center) 扩展奇数回文', '从 (center,center+1) 扩展偶数回文'], 'O(n²)', 'O(1)',
        `class Solution {
    public int countSubstrings(String s) {
        int answer = 0; for (int center = 0; center < s.length(); center++) answer += expand(s, center, center) + expand(s, center, center + 1); return answer;
    }
    private int expand(String s, int left, int right) { int count = 0; while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) count++; return count; }
}`,
        `class Solution {
    fun countSubstrings(s: String): Int { var answer = 0; for (center in s.indices) answer += expand(s, center, center) + expand(s, center, center + 1); return answer }
    private fun expand(s: String, startLeft: Int, startRight: Int): Int { var left = startLeft; var right = startRight; var count = 0; while (left >= 0 && right < s.length && s[left] == s[right]) { count++; left--; right++ }; return count }
}`,
        `class Solution {
    int expand(const string& s, int left, int right) { int count = 0; while (left >= 0 && right < (int)s.size() && s[left] == s[right]) { ++count; --left; ++right; } return count; }
public:
    int countSubstrings(string s) { int answer = 0; for (int center = 0; center < (int)s.size(); ++center) answer += expand(s, center, center) + expand(s, center, center + 1); return answer; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'countSubstrings', parameterTypes: ['string'], returnType: 'int', cases: [
        { name: '只有单字符回文', args: ['abc'], expected: 3 },
        { name: '三个相同字符', args: ['aaa'], expected: 6 },
        { name: '偶数长度回文', args: ['abba'], expected: 6 },
      ] },
    },
  ],
}
