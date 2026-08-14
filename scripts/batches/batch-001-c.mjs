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
      id: 55,
      slug: 'jump-game',
      title: '跳跃游戏',
      studyTags: ['贪心', '最远覆盖', '不可达检测'],
      summary: '数组元素表示从当前位置最多可以向前跳跃的距离，判断能否从第一个位置到达最后一个位置。',
      insight: '只需维护已经能够到达的最远下标；当前下标一旦超过该边界，后续位置都不可能被访问。',
      pitfalls: ['数组值表示最大跳跃距离而不是必须跳的距离', '遍历范围不能超过当前可达边界', '长度为一的数组已经位于终点'],
      solutions: [
        makeSolution(
          'greedy-farthest',
          '最远覆盖贪心',
          '最优',
          '遍历所有可达位置，并持续扩大可以覆盖到的最远下标。',
          ['初始化最远位置为 0', '若当前下标超过最远位置则立即失败', '用当前位置加跳跃长度更新最远位置'],
          'O(n)',
          'O(1)',
          `class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index > farthest) return false;
            farthest = Math.max(farthest, index + nums[index]);
            if (farthest >= nums.length - 1) return true;
        }
        return true;
    }
}`,
          `class Solution {
    fun canJump(nums: IntArray): Boolean {
        var farthest = 0
        for (index in nums.indices) {
            if (index > farthest) return false
            farthest = maxOf(farthest, index + nums[index])
            if (farthest >= nums.lastIndex) return true
        }
        return true
    }
}`,
          `class Solution {
public:
    bool canJump(vector<int>& nums) {
        int farthest = 0;
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (index > farthest) return false;
            farthest = max(farthest, index + nums[index]);
            if (farthest >= (int)nums.size() - 1) return true;
        }
        return true;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'canJump',
        parameterTypes: ['intArray'],
        returnType: 'boolean',
        cases: [
          { name: '可以跨过中间位置到终点', args: [[2, 3, 1, 1, 4]], expected: true },
          { name: '被零阻断无法到达', args: [[3, 2, 1, 0, 4]], expected: false },
          { name: '单元素已经到达终点', args: [[0]], expected: true },
        ],
      },
    },
    {
      id: 56,
      slug: 'merge-intervals',
      title: '合并区间',
      studyTags: ['区间排序', '扫描合并', '边界维护'],
      summary: '合并一组可能互相重叠的闭区间，返回覆盖范围相同且互不重叠的区间集合。',
      insight: '按起点排序后，新区间只可能与当前合并结果的最后一个区间重叠。',
      pitfalls: ['端点相等的闭区间也应合并', '重叠时右端点要取两者最大值', '输入顺序不能直接用于线性合并'],
      solutions: [
        makeSolution(
          'sort-and-scan',
          '排序后线性扫描',
          '最优',
          '先按左端点排序，再维护当前尚未结束的合并区间。',
          ['按区间起点升序排序', '若新区间起点超过当前右端点则开始新区间', '否则扩大当前区间的右端点'],
          'O(n log n)',
          'O(n)',
          `class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {interval[0], interval[1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}`,
          `class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy<IntArray> { it[0] })
        val merged = ArrayList<IntArray>()
        for (interval in intervals) {
            if (merged.isEmpty() || interval[0] > merged.last()[1]) {
                merged.add(intArrayOf(interval[0], interval[1]))
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}`,
          `class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> merged;
        for (const auto& interval : intervals) {
            if (merged.empty() || interval[0] > merged.back()[1]) {
                merged.push_back(interval);
            } else {
                merged.back()[1] = max(merged.back()[1], interval[1]);
            }
        }
        return merged;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'merge',
        parameterTypes: ['intMatrix'],
        returnType: 'intMatrix',
        cases: [
          { name: '两组区间发生重叠', args: [[[1, 3], [2, 6], [8, 10], [15, 18]]], expected: [[1, 6], [8, 10], [15, 18]] },
          { name: '端点相接也要合并', args: [[[1, 4], [4, 5]]], expected: [[1, 5]] },
          { name: '排序后一个区间被包含', args: [[[1, 4], [0, 4]]], expected: [[0, 4]] },
        ],
      },
    },
    {
      id: 62,
      slug: 'unique-paths',
      title: '不同路径',
      studyTags: ['网格动态规划', '状态压缩', '路径计数'],
      summary: '机器人从网格左上角出发，每次只能向右或向下移动，计算到达右下角的不同路径数量。',
      insight: '到达一个格子的最后一步只能来自上方或左方，因此路径数是这两个方向路径数之和。',
      pitfalls: ['第一行和第一列都只有一种到达方式', '更新一维数组时 dp[column] 仍代表上方路径数', '题目计算路径数量而不是最短步数'],
      solutions: [
        makeSolution(
          'one-dimensional-dp',
          '一维动态规划',
          '最优',
          '用一行数组保存当前行每个格子的路径数，原值代表上方，左侧值代表左方。',
          ['把第一行初始化为全 1', '从第二行开始由左向右更新', '执行 dp[col] += dp[col - 1]'],
          'O(mn)',
          'O(n)',
          `class Solution {
    public int uniquePaths(int m, int n) {
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[n - 1];
    }
}`,
          `class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val paths = IntArray(n) { 1 }
        for (row in 1 until m) {
            for (column in 1 until n) {
                paths[column] += paths[column - 1]
            }
        }
        return paths[n - 1]
    }
}`,
          `class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> paths(n, 1);
        for (int row = 1; row < m; ++row) {
            for (int column = 1; column < n; ++column) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[n - 1];
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'uniquePaths',
        parameterTypes: ['int', 'int'],
        returnType: 'int',
        cases: [
          { name: '三行七列网格', args: [3, 7], expected: 28 },
          { name: '三行两列网格', args: [3, 2], expected: 3 },
          { name: '起点就是终点', args: [1, 1], expected: 1 },
        ],
      },
    },
    {
      id: 76,
      slug: 'minimum-window-substring',
      title: '最小覆盖子串',
      studyTags: ['滑动窗口', '字符欠账', '最短合法区间'],
      summary: '在字符串 s 中寻找包含字符串 t 全部字符及其出现次数的最短连续子串，不存在时返回空字符串。',
      insight: '右端扩张用来偿还目标字符欠账；全部满足后持续移动左端，直到窗口即将失去合法性。',
      pitfalls: ['重复字符需要满足对应次数', '非目标字符可以进入窗口但不改变欠账', '更新答案必须发生在窗口仍合法时'],
      solutions: [
        makeSolution(
          'sliding-window-debt',
          '欠账计数滑动窗口',
          '最优',
          '计数数组保存仍需要的字符数量，missing 表示尚未匹配的目标字符总数。',
          ['统计 t 中字符并初始化 missing', '右端字符若仍被需要则减少 missing', 'missing 为零时收缩左端并更新最短区间'],
          'O(|s| + |t|)',
          'O(|Σ|)',
          `class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] need = new int[128];
        for (int index = 0; index < t.length(); index++) need[t.charAt(index)]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLength = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char added = s.charAt(right);
            if (need[added] > 0) missing--;
            need[added]--;
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                char removed = s.charAt(left++);
                need[removed]++;
                if (need[removed] > 0) missing++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}`,
          `class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) return ""
        val need = IntArray(128)
        for (char in t) need[char.code]++
        var missing = t.length
        var left = 0
        var bestStart = 0
        var bestLength = Int.MAX_VALUE
        for (right in s.indices) {
            val added = s[right].code
            if (need[added] > 0) missing--
            need[added]--
            while (missing == 0) {
                val length = right - left + 1
                if (length < bestLength) { bestLength = length; bestStart = left }
                val removed = s[left++].code
                need[removed]++
                if (need[removed] > 0) missing++
            }
        }
        return if (bestLength == Int.MAX_VALUE) "" else s.substring(bestStart, bestStart + bestLength)
    }
}`,
          `class Solution {
public:
    string minWindow(string s, string t) {
        if (t.size() > s.size()) return "";
        array<int, 128> need{};
        for (unsigned char value : t) ++need[value];
        int missing = t.size(), left = 0, bestStart = 0, bestLength = INT_MAX;
        for (int right = 0; right < (int)s.size(); ++right) {
            unsigned char added = s[right];
            if (need[added] > 0) --missing;
            --need[added];
            while (missing == 0) {
                int length = right - left + 1;
                if (length < bestLength) { bestLength = length; bestStart = left; }
                unsigned char removed = s[left++];
                ++need[removed];
                if (need[removed] > 0) ++missing;
            }
        }
        return bestLength == INT_MAX ? "" : s.substr(bestStart, bestLength);
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'minWindow',
        parameterTypes: ['string', 'string'],
        returnType: 'string',
        cases: [
          { name: '窗口需要跨过无关字符', args: ['ADOBECODEBANC', 'ABC'], expected: 'BANC' },
          { name: '单字符完全匹配', args: ['a', 'a'], expected: 'a' },
          { name: '目标字符数量不足', args: ['a', 'aa'], expected: '' },
        ],
      },
    },
    {
      id: 78,
      slug: 'subsets',
      title: '子集',
      studyTags: ['回溯', '组合枚举', '空集'],
      summary: '给定一个不含重复元素的整数数组，返回它的所有子集，包括空集和数组本身。',
      insight: '当前路径本身就是一个合法子集；随后只从更大的下标继续选择，便能保证每个子集只出现一次。',
      pitfalls: ['空集必须包含在答案中', '递归下一层从 index + 1 开始', '保存当前路径时需要创建副本'],
      solutions: [
        makeSolution(
          'backtracking',
          '递增下标回溯',
          '最优',
          '每到一个递归节点先保存当前路径，再依次选择后续元素继续扩展。',
          ['保存当前路径作为一个子集', '从 start 开始枚举下一元素', '递归后删除最后加入的元素'],
          'O(n · 2ⁿ)',
          'O(n)',
          `class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        build(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void build(int[] nums, int start, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int index = start; index < nums.length; index++) {
            path.add(nums[index]);
            build(nums, index + 1, path, answer);
            path.remove(path.size() - 1);
        }
    }
}`,
          `class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = ArrayList<List<Int>>()
        build(nums, 0, ArrayList(), answer)
        return answer
    }

    private fun build(nums: IntArray, start: Int, path: MutableList<Int>, answer: MutableList<List<Int>>) {
        answer.add(ArrayList(path))
        for (index in start until nums.size) {
            path.add(nums[index])
            build(nums, index + 1, path, answer)
            path.removeAt(path.lastIndex)
        }
    }
}`,
          `class Solution {
    void build(const vector<int>& nums, int start, vector<int>& path, vector<vector<int>>& answer) {
        answer.push_back(path);
        for (int index = start; index < (int)nums.size(); ++index) {
            path.push_back(nums[index]);
            build(nums, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        vector<int> path;
        build(nums, 0, path, answer);
        return answer;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'subsets',
        parameterTypes: ['intArray'],
        returnType: 'intListMatrix',
        cases: [
          { name: '三个元素产生八个子集', args: [[1, 2, 3]], expected: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]] },
          { name: '空数组只有空集', args: [[]], expected: [[]] },
          { name: '单元素数组', args: [[0]], expected: [[], [0]] },
        ],
      },
    },
  ],
}
