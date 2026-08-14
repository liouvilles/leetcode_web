const makeSolution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({
  id,
  title,
  kind,
  idea,
  steps,
  complexity: { time, space },
  code: { java, kotlin, cpp },
})

export default {
  batchId: 'batch-001',
  problems: [
    {
      id: 22,
      slug: 'generate-parentheses',
      title: '括号生成',
      studyTags: ['回溯', '合法前缀', '剪枝'],
      summary: '给定括号对数 n，生成所有由 n 对圆括号组成且整体合法的不同字符串。',
      insight: '构造过程中只要保证右括号使用数不超过左括号，当前前缀就仍有机会扩展成合法答案。',
      pitfalls: ['左括号和右括号都必须恰好使用 n 个', '不能等到生成完整字符串后才判断合法性', '回溯返回前要撤销刚加入的字符'],
      solutions: [
        makeSolution(
          'backtracking',
          '合法前缀回溯',
          '最优',
          '记录已经使用的左右括号数量，只扩展仍满足合法前缀条件的分支。',
          ['左括号不足 n 个时可以继续添加', '右括号少于左括号时才允许添加右括号', '字符串长度达到 2n 时保存答案'],
          'O(Cₙ · n)',
          'O(n)',
          `class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        build(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(int n, int open, int close, StringBuilder path, List<String> answer) {
        if (path.length() == 2 * n) {
            answer.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            build(n, open + 1, close, path, answer);
            path.setLength(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            build(n, open, close + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}`,
          `class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val answer = ArrayList<String>()
        build(n, 0, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(n: Int, open: Int, close: Int, path: StringBuilder, answer: MutableList<String>) {
        if (path.length == 2 * n) {
            answer.add(path.toString())
            return
        }
        if (open < n) {
            path.append('(')
            build(n, open + 1, close, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
        if (close < open) {
            path.append(')')
            build(n, open, close + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}`,
          `class Solution {
    void build(int n, int open, int close, string& path, vector<string>& answer) {
        if ((int)path.size() == 2 * n) {
            answer.push_back(path);
            return;
        }
        if (open < n) {
            path.push_back('(');
            build(n, open + 1, close, path, answer);
            path.pop_back();
        }
        if (close < open) {
            path.push_back(')');
            build(n, open, close + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        string path;
        build(n, 0, 0, path, answer);
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'generateParenthesis',
        parameterTypes: ['int'],
        returnType: 'stringList',
        cases: [
          { name: '一对括号', args: [1], expected: ['()'] },
          { name: '两对括号', args: [2], expected: ['(())', '()()'] },
          { name: '三对括号', args: [3], expected: ['((()))', '(()())', '(())()', '()(())', '()()()'] },
        ],
      },
    },
    {
      id: 33,
      slug: 'search-in-rotated-sorted-array',
      title: '搜索旋转排序数组',
      studyTags: ['二分查找', '有序半区', '旋转数组'],
      summary: '在一个元素互不相同、经过未知位置旋转的升序数组中查找目标值下标，不存在时返回 -1。',
      insight: '任意二分区间至少有一半仍然有序，判断目标是否落在该有序半区即可排除另一半。',
      pitfalls: ['边界比较要统一使用闭区间', '先确定哪一半有序，再判断目标范围', '目标不存在时必须返回 -1'],
      solutions: [
        makeSolution(
          'modified-binary-search',
          '识别有序半区的二分',
          '最优',
          '每轮利用端点和中点识别有序的一半，再根据目标范围缩小搜索区间。',
          ['计算中点并直接检查目标', '比较左端与中点判断左半区是否有序', '依据目标是否位于有序范围更新左右边界'],
          'O(log n)',
          'O(1)',
          `class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }
        }
        return -1;
    }
}`,
          `class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (nums[middle] == target) return middle
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target < nums[middle]) right = middle - 1
                else left = middle + 1
            } else {
                if (target > nums[middle] && target <= nums[right]) left = middle + 1
                else right = middle - 1
            }
        }
        return -1
    }
}`,
          `class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = (int)nums.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            } else {
                if (nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }
        }
        return -1;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'search',
        parameterTypes: ['intArray', 'int'],
        returnType: 'int',
        cases: [
          { name: '目标位于旋转点右侧', args: [[4, 5, 6, 7, 0, 1, 2], 0], expected: 4 },
          { name: '目标不存在', args: [[4, 5, 6, 7, 0, 1, 2], 3], expected: -1 },
          { name: '单元素数组命中', args: [[1], 1], expected: 0 },
        ],
      },
    },
    {
      id: 39,
      slug: 'combination-sum',
      title: '组合总和',
      studyTags: ['回溯', '可重复选择', '排序剪枝'],
      summary: '从互不相同的正整数候选值中选取若干个数，使总和等于目标值；每个候选值可以重复使用。',
      insight: '回溯时继续从当前下标选择即可允许重复，同时避免因选择顺序不同而产生重复组合。',
      pitfalls: ['同一个候选值允许选多次', '下一层从当前下标而不是下一个下标开始', '排序后当前值超过剩余目标即可停止枚举'],
      solutions: [
        makeSolution(
          'sorted-backtracking',
          '排序剪枝回溯',
          '最优',
          '维护剩余目标和起始下标，以非递减顺序构造组合。',
          ['候选数组排序', '从 start 开始尝试不超过 remaining 的值', '选择后仍传入当前下标，返回时撤销选择'],
          'O(S)',
          'O(target / min(candidates))',
          `class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void search(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> answer) {
        if (remaining == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = start; index < candidates.length && candidates[index] <= remaining; index++) {
            path.add(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.remove(path.size() - 1);
        }
    }
}`,
          `class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val answer = ArrayList<List<Int>>()
        search(candidates, target, 0, ArrayList(), answer)
        return answer
    }

    private fun search(candidates: IntArray, remaining: Int, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (remaining == 0) {
            answer.add(ArrayList(path))
            return
        }
        for (index in start until candidates.size) {
            if (candidates[index] > remaining) break
            path.add(candidates[index])
            search(candidates, remaining - candidates[index], index, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}`,
          `class Solution {
    void search(const vector<int>& candidates, int remaining, int start, vector<int>& path, vector<vector<int>>& answer) {
        if (remaining == 0) {
            answer.push_back(path);
            return;
        }
        for (int index = start; index < (int)candidates.size() && candidates[index] <= remaining; ++index) {
            path.push_back(candidates[index]);
            search(candidates, remaining - candidates[index], index, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> answer;
        vector<int> path;
        search(candidates, target, 0, path, answer);
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'combinationSum',
        parameterTypes: ['intArray', 'int'],
        returnType: 'intListMatrix',
        cases: [
          { name: '重复选择得到目标', args: [[2, 3, 6, 7], 7], expected: [[2, 2, 3], [7]] },
          { name: '存在三种组合', args: [[2, 3, 5], 8], expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]] },
          { name: '最小候选值也超过目标', args: [[2], 1], expected: [] },
        ],
      },
    },
    {
      id: 46,
      slug: 'permutations',
      title: '全排列',
      studyTags: ['回溯', '使用标记', '决策树'],
      summary: '给定一个不含重复元素的整数数组，返回其中所有可能的排列。',
      insight: '排列的每个位置都可以从尚未使用的元素中选择，使用布尔数组即可维护当前路径的可选集合。',
      pitfalls: ['同一个下标在一条路径中只能使用一次', '保存答案时必须复制当前路径', '回溯后要同时撤销路径和使用标记'],
      solutions: [
        makeSolution(
          'used-array-backtracking',
          '使用标记回溯',
          '最优',
          '逐位置选择尚未进入路径的元素，路径长度等于数组长度时得到一个排列。',
          ['建立 used 数组', '枚举所有未使用元素加入路径', '递归返回后恢复 used 并删除路径末尾'],
          'O(n · n!)',
          'O(n)',
          `class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (used[index]) continue;
            used[index] = true;
            path.add(nums[index]);
            build(nums, used, path, answer);
            path.remove(path.size() - 1);
            used[index] = false;
        }
    }
}`,
          `class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, BooleanArray(nums.size), ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, used: BooleanArray, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (path.size == nums.size) {
            answer.add(ArrayList(path))
            return
        }
        for (index in nums.indices) {
            if (used[index]) continue
            used[index] = true
            path.add(nums[index])
            build(nums, used, path, answer)
            path.removeAt(path.lastIndex)
            used[index] = false
        }
    }
}`,
          `class Solution {
    void build(const vector<int>& nums, vector<bool>& used, vector<int>& path, vector<vector<int>>& answer) {
        if (path.size() == nums.size()) {
            answer.push_back(path);
            return;
        }
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (used[index]) continue;
            used[index] = true;
            path.push_back(nums[index]);
            build(nums, used, path, answer);
            path.pop_back();
            used[index] = false;
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        vector<bool> used(nums.size());
        build(nums, used, path, answer);
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'permute',
        parameterTypes: ['intArray'],
        returnType: 'intListMatrix',
        cases: [
          { name: '三个元素的全部排列', args: [[1, 2, 3]], expected: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]] },
          { name: '两个元素互换', args: [[0, 1]], expected: [[0, 1], [1, 0]] },
          { name: '单元素只有一种排列', args: [[1]], expected: [[1]] },
        ],
      },
    },
    {
      id: 49,
      slug: 'group-anagrams',
      title: '字母异位词分组',
      studyTags: ['规范化键', '哈希分组', '排序字符'],
      summary: '把字符串数组中由相同字符以不同顺序组成的字符串归入同一组。',
      insight: '字母异位词排序后会得到完全相同的字符串，因此排序结果可以作为稳定的分组键。',
      pitfalls: ['空字符串也需要形成合法分组', '每个分组中的原字符串不能被排序后替换', '题目不要求组之间的固定顺序'],
      solutions: [
        makeSolution(
          'sorted-key-hash',
          '排序键哈希分组',
          '最优',
          '为每个字符串生成排序后的规范键，用映射收集相同键对应的原字符串。',
          ['把字符串转成字符数组并排序', '用排序字符串查找或创建分组', '按首次出现顺序返回所有分组'],
          'O(n · k log k)',
          'O(n · k)',
          `class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String value : strs) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(value);
        }
        return new ArrayList<>(groups.values());
    }
}`,
          `class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = linkedMapOf<String, MutableList<String>>()
        for (value in strs) {
            val chars = value.toCharArray()
            chars.sort()
            val key = chars.concatToString()
            groups.getOrPut(key) { ArrayList() }.add(value)
        }
        return groups.values.map { it.toList() }
    }
}`,
          `class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> indexByKey;
        vector<vector<string>> groups;
        for (const string& value : strs) {
            string key = value;
            sort(key.begin(), key.end());
            auto [it, inserted] = indexByKey.emplace(key, groups.size());
            if (inserted) groups.push_back({});
            groups[it->second].push_back(value);
        }
        return groups;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'groupAnagrams',
        parameterTypes: ['stringArray'],
        returnType: 'stringListMatrix',
        cases: [
          { name: '三个异位词分组', args: [['eat', 'tea', 'tan', 'ate', 'nat', 'bat']], expected: [['eat', 'tea', 'ate'], ['tan', 'nat'], ['bat']] },
          { name: '空字符串单独成组', args: [['']], expected: [['']] },
          { name: '单字符字符串', args: [['a']], expected: [['a']] },
        ],
      },
    },
  ],
}
