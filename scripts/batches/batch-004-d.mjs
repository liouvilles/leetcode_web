const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 67, slug: 'add-binary', title: '二进制求和', studyTags: ['双指针', '进位模拟', '字符串'],
    summary: '给定两个二进制字符串，返回它们相加后的二进制字符串。',
    insight: '从两个字符串末尾同步取位，加上进位后写入结果最低位，并把商作为下一位进位。',
    pitfalls: ['两个字符串长度可能不同', '循环结束后可能仍有最高位进位', '逆序生成后需要反转结果'],
    solutions: [s('digit-carry', '逆序逐位进位', '用两个下标从低位向高位模拟二进制竖式加法。', ['下标从两串末尾开始', '累加有效位和 carry，追加 sum%2', '更新 carry=sum/2，最后反转'], 'O(m+n)', 'O(m+n)',
      `class Solution {
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder(); int left = a.length() - 1, right = b.length() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry != 0) { int sum = carry; if (left >= 0) sum += a.charAt(left--) - '0'; if (right >= 0) sum += b.charAt(right--) - '0'; answer.append(sum & 1); carry = sum >> 1; }
        return answer.reverse().toString();
    }
}`,
      `class Solution {
    fun addBinary(a: String, b: String): String {
        val answer = StringBuilder(); var left = a.lastIndex; var right = b.lastIndex; var carry = 0
        while (left >= 0 || right >= 0 || carry != 0) { var sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer.append(sum and 1); carry = sum shr 1 }
        return answer.reverse().toString()
    }
}`,
      `class Solution {
public:
    string addBinary(string a, string b) {
        string answer; int left = a.size() - 1, right = b.size() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry) { int sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer += char('0' + (sum & 1)); carry = sum >> 1; }
        reverse(answer.begin(), answer.end()); return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'addBinary', parameterTypes: ['string','string'], returnType: 'string', cases: [
      { name: '产生最高位进位', args: ['11','1'], expected: '100' }, { name: '不同长度相加', args: ['1010','1011'], expected: '10101' }, { name: '两个零', args: ['0','0'], expected: '0' },
    ] },
  },
  {
    id: 71, slug: 'simplify-path', title: '简化路径', studyTags: ['栈', '路径解析', '字符串'],
    summary: '把 Unix 风格绝对路径规范化，消除重复斜杠、当前目录和可回退的父目录片段。',
    insight: '按斜杠分段，用栈保存有效目录名；普通名称入栈，两个点弹栈，一个点和空段忽略。',
    pitfalls: ['根目录不能继续向上回退', '多个连续斜杠等同一个', '三个及以上点是普通目录名'],
    solutions: [s('directory-stack', '目录栈归一化', '逐段解释路径语义，栈中始终保存规范路径的目录序列。', ['按 / 拆分片段', '忽略空串和 .，对 .. 弹栈', '普通片段入栈，最后用 / 连接'], 'O(n)', 'O(n)',
      `class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) { if (part.isEmpty() || part.equals(".")) continue; if (part.equals("..")) { if (!stack.isEmpty()) stack.removeLast(); } else stack.addLast(part); }
        return "/" + String.join("/", stack);
    }
}`,
      `class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        for (part in path.split('/')) { if (part.isEmpty() || part == ".") continue; if (part == "..") { if (stack.isNotEmpty()) stack.removeLast() } else stack.addLast(part) }
        return "/" + stack.joinToString("/")
    }
}`,
      `class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack; string part; stringstream stream(path);
        while (getline(stream, part, '/')) { if (part.empty() || part == ".") continue; if (part == "..") { if (!stack.empty()) stack.pop_back(); } else stack.push_back(part); }
        string answer; for (const string& directory : stack) answer += "/" + directory; return answer.empty() ? "/" : answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'simplifyPath', parameterTypes: ['string'], returnType: 'string', cases: [
      { name: '移除尾随斜杠', args: ['/home/'], expected: '/home' }, { name: '根目录忽略父级', args: ['/../'], expected: '/' }, { name: '混合冗余片段', args: ['/home//foo/../bar/.'], expected: '/home/bar' },
    ] },
  },
  {
    id: 77, slug: 'combinations', title: '组合', studyTags: ['回溯', '剪枝', '组合枚举'],
    summary: '从 1 到 n 中选择 k 个不同数字，返回所有不考虑顺序的组合。',
    insight: '递增选择下一个数字天然消除排列重复；根据还需选择的数量限制枚举上界可以提前剪枝。',
    pitfalls: ['组合内必须保持递增选择', '加入答案时需要复制当前路径', '候选上界要为剩余位置留足数字'],
    solutions: [s('backtracking-pruning', '递增回溯剪枝', '路径只向更大数字扩展，并用剩余数量计算本层最大起点。', ['路径长度达到 k 时复制到答案', '枚举 value 到 n-(k-size)+1', '选择、递归、撤销选择'], 'O(C(n,k)·k)', 'O(k) excluding output',
      `class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>(); backtrack(1, n, k, new ArrayList<>(), answer); return answer;
    }
    private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == k) { answer.add(new ArrayList<>(path)); return; }
        int limit = n - (k - path.size()) + 1;
        for (int value = start; value <= limit; value++) { path.add(value); backtrack(value + 1, n, k, path, answer); path.remove(path.size() - 1); }
    }
}`,
      `class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>()
        fun backtrack(start: Int) { if (path.size == k) { answer.add(path.toList()); return }; val limit = n - (k - path.size) + 1; for (value in start..limit) { path.add(value); backtrack(value + 1); path.removeAt(path.lastIndex) } }
        backtrack(1); return answer
    }
}`,
      `class Solution {
    void backtrack(int start, int n, int k, vector<int>& path, vector<vector<int>>& answer) {
        if ((int)path.size() == k) { answer.push_back(path); return; }
        int limit = n - (k - path.size()) + 1;
        for (int value = start; value <= limit; ++value) { path.push_back(value); backtrack(value + 1, n, k, path, answer); path.pop_back(); }
    }
public:
    vector<vector<int>> combine(int n, int k) { vector<vector<int>> answer; vector<int> path; backtrack(1, n, k, path, answer); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'combine', parameterTypes: ['int','int'], returnType: 'intListMatrix', cases: [
      { name: '四选二', args: [4,2], expected: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] }, { name: '一选一', args: [1,1], expected: [[1]] }, { name: '五选一', args: [5,1], expected: [[1],[2],[3],[4],[5]] },
    ] },
  },
  {
    id: 80, slug: 'remove-duplicates-from-sorted-array-ii', title: '删除有序数组中的重复项 II', studyTags: ['快慢指针', '原地去重', '有序数组'],
    summary: '原地修改非递减数组，使每个不同元素最多保留两次，并返回有效前缀长度。',
    insight: '当已写入至少两个数时，新值只有不同于有效前缀倒数第二项才可写入。',
    pitfalls: ['前两个元素总能保留', '只要求有效前缀满足条件', '短于三个元素的数组无需特殊修改'],
    solutions: [s('two-behind-check', '检查倒数第二个已写元素', '写指针表示有效长度，通过与 write-2 位置比较控制出现次数。', ['遍历原数组', 'write<2 或 value!=nums[write-2] 时写入', '返回 write'], 'O(n)', 'O(1)',
      `class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0; for (int value : nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write;
    }
}`,
      `class Solution {
    fun removeDuplicates(nums: IntArray): Int { var write = 0; for (value in nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write }
}`,
      `class Solution {
public:
    int removeDuplicates(vector<int>& nums) { int write = 0; for (int value : nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'removeDuplicates', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '一个值出现三次', args: [[1,1,1,2,2,3]], expected: 5, expectedArgs: [{ index: 0, type: 'intArray', expected: [1,1,2,2,3,3] }] },
      { name: '多个长重复段', args: [[0,0,1,1,1,1,2,3,3]], expected: 7, expectedArgs: [{ index: 0, type: 'intArray', expected: [0,0,1,1,2,3,3,3,3] }] },
      { name: '单元素', args: [[1]], expected: 1, expectedArgs: [{ index: 0, type: 'intArray', expected: [1] }] },
    ] },
  },
  {
    id: 81, slug: 'search-in-rotated-sorted-array-ii', title: '搜索旋转排序数组 II', studyTags: ['二分查找', '旋转数组', '重复元素'],
    summary: '判断目标值是否存在于可能包含重复元素的旋转非递减数组中。',
    insight: '若左右端点与中点相同，无法判断有序侧，只能同时收缩；否则至少一侧有序，可据目标范围排除另一侧。',
    pitfalls: ['重复元素会破坏普通旋转数组二分的判定', '最坏情况下会退化为线性复杂度', '范围比较要包含有序侧端点'],
    solutions: [s('duplicate-aware-binary-search', '跳过重复端点的二分', '先消除无法判断的三点相等情形，再利用有序半区定位目标。', ['比较 middle 是否命中', '三点相等时左右同时收缩', '判断有序侧及目标是否落在其中并缩小区间'], 'O(n) worst, O(log n) average', 'O(1)',
      `class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { int middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { left++; right--; } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1; else left = middle + 1; } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1; else right = middle - 1; } }
        return false;
    }
}`,
      `class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0; var right = nums.lastIndex
        while (left <= right) { val middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { left++; right-- } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1 else left = middle + 1 } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1 else right = middle - 1 } }
        return false
    }
}`,
      `class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) { int middle = left + (right - left) / 2; if (nums[middle] == target) return true; if (nums[left] == nums[middle] && nums[middle] == nums[right]) { ++left; --right; } else if (nums[left] <= nums[middle]) { if (nums[left] <= target && target < nums[middle]) right = middle - 1; else left = middle + 1; } else { if (nums[middle] < target && target <= nums[right]) left = middle + 1; else right = middle - 1; } } return false;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'search', parameterTypes: ['intArray','int'], returnType: 'boolean', cases: [
      { name: '旋转后命中', args: [[2,5,6,0,0,1,2],0], expected: true }, { name: '目标不存在', args: [[2,5,6,0,0,1,2],3], expected: false }, { name: '重复值遮蔽有序侧', args: [[1,0,1,1,1],0], expected: true },
    ] },
  },
] }
