const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 82, slug: 'remove-duplicates-from-sorted-list-ii', title: '删除排序链表中的重复元素 II', studyTags: ['链表', '哑节点', '连续分组'],
    summary: '删除有序链表中所有出现过重复的数值，只保留原链表中只出现一次的节点。',
    insight: '有序链表的重复值连续出现；用前驱节点跨过整段重复节点，哑节点可统一处理头部重复。',
    pitfalls: ['重复值的所有节点都要删除', '头部可能就是重复段', '判断重复段后要跨过全部相同值'],
    solutions: [s('dummy-and-groups', '哑节点跳过重复段', '前驱指向尚未确认的当前节点，发现重复时跳到下一种值。', ['建立 dummy 指向 head', '若 current 与 next 同值则记录值并跳过整段', '否则前驱和当前各前进一步'], 'O(n)', 'O(1)',
      `class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), previous = dummy, current = head;
        while (current != null) { if (current.next != null && current.val == current.next.val) { int value = current.val; while (current != null && current.val == value) current = current.next; previous.next = current; } else { previous = current; current = current.next; } }
        return dummy.next;
    }
}`,
      `class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous: ListNode = dummy; var current = head
        while (current != null) { if (current.next != null && current.\`val\` == current.next!!.\`val\`) { val value = current.\`val\`; while (current != null && current.\`val\` == value) current = current.next; previous.next = current } else { previous = current; current = current.next } }
        return dummy.next
    }
}`,
      `class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode dummy(0, head); ListNode* previous = &dummy; ListNode* current = head;
        while (current) { if (current->next && current->val == current->next->val) { int value = current->val; while (current && current->val == value) current = current->next; previous->next = current; } else { previous = current; current = current->next; } } return dummy.next;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'deleteDuplicates', parameterTypes: ['listNode'], returnType: 'listNode', cases: [
      { name: '删除中间两段重复值', args: [[1,2,3,3,4,4,5]], expected: [1,2,5] }, { name: '删除头部重复值', args: [[1,1,1,2,3]], expected: [2,3] }, { name: '空链表', args: [[]], expected: [] },
    ] },
  },
  {
    id: 83, slug: 'remove-duplicates-from-sorted-list', title: '删除排序链表中的重复元素', studyTags: ['链表', '有序去重', '原地修改'],
    summary: '删除有序链表中的重复节点，使每个数值只保留一个节点。',
    insight: '相同值必定相邻；若当前节点与后继相同，直接绕过后继，否则推进当前节点。',
    pitfalls: ['每种重复值仍要保留一个节点', '连续多个相同值需要反复比较', '空链表无需处理'],
    solutions: [s('adjacent-skip', '跳过相邻重复节点', '单指针沿链表扫描，并原地修改 next 指针。', ['current 从头节点开始', '相邻值相同则 current.next=current.next.next', '否则 current 前进'], 'O(n)', 'O(1)',
      `class Solution {
    public ListNode deleteDuplicates(ListNode head) { ListNode current = head; while (current != null && current.next != null) { if (current.val == current.next.val) current.next = current.next.next; else current = current.next; } return head; }
}`,
      `class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? { var current = head; while (current?.next != null) { if (current.\`val\` == current.next!!.\`val\`) current.next = current.next!!.next else current = current.next }; return head }
}`,
      `class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) { ListNode* current = head; while (current && current->next) { if (current->val == current->next->val) current->next = current->next->next; else current = current->next; } return head; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'deleteDuplicates', parameterTypes: ['listNode'], returnType: 'listNode', cases: [
      { name: '一组重复值', args: [[1,1,2]], expected: [1,2] }, { name: '多组重复值', args: [[1,1,2,3,3]], expected: [1,2,3] }, { name: '空链表', args: [[]], expected: [] },
    ] },
  },
  {
    id: 86, slug: 'partition-list', title: '分隔链表', studyTags: ['链表', '双链表', '稳定分区'],
    summary: '把链表按给定值 x 分区，使小于 x 的节点位于其余节点之前，同时保持两组节点的原相对顺序。',
    insight: '分别把节点追加到“小于”和“不小于”两条链表，扫描结束后连接两条链表即可保持稳定性。',
    pitfalls: ['必须保留每组内部的原始顺序', '较大链表尾部要置空以避免环', '哑节点可简化空分区处理'],
    solutions: [s('two-stable-lists', '双链表稳定拼接', '一次扫描按条件把原节点追加到两条临时链表尾部。', ['创建 before/after 两个哑节点', '逐节点追加到对应尾部', 'after 尾置空并连接两组'], 'O(n)', 'O(1)',
      `class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0), afterDummy = new ListNode(0), before = beforeDummy, after = afterDummy;
        while (head != null) { if (head.val < x) { before.next = head; before = head; } else { after.next = head; after = head; } head = head.next; }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next;
    }
}`,
      `class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val beforeDummy = ListNode(0); val afterDummy = ListNode(0); var before = beforeDummy; var after = afterDummy; var current = head
        while (current != null) { if (current.\`val\` < x) { before.next = current; before = current } else { after.next = current; after = current }; current = current.next }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next
    }
}`,
      `class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode beforeDummy(0), afterDummy(0); ListNode* before = &beforeDummy; ListNode* after = &afterDummy;
        while (head) { if (head->val < x) { before->next = head; before = head; } else { after->next = head; after = head; } head = head->next; }
        after->next = nullptr; before->next = afterDummy.next; return beforeDummy.next;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'partition', parameterTypes: ['listNode','int'], returnType: 'listNode', cases: [
      { name: '两组均有多个节点', args: [[1,4,3,2,5,2],3], expected: [1,2,2,4,3,5] }, { name: '小节点移到前方', args: [[2,1],2], expected: [1,2] }, { name: '空链表', args: [[],3], expected: [] },
    ] },
  },
  {
    id: 89, slug: 'gray-code', title: '格雷编码', studyTags: ['位运算', '数学构造', '异或'],
    summary: '生成长度为 2^n 的 n 位格雷码序列，从零开始且相邻值恰好只有一个二进制位不同。',
    insight: '自然数 i 的二进制反射格雷码为 i XOR (i>>1)，按 i 递增即可得到满足环状相邻条件的序列。',
    pitfalls: ['序列必须从零开始', '结果共有 2^n 个数', '使用异或而不是普通加法组合高低位'],
    solutions: [s('binary-reflected-formula', '反射格雷码公式', '直接对区间内每个整数应用 i^(i>>1) 映射。', ['计算 total=1<<n', '枚举 i 从 0 到 total-1', '追加 i XOR (i>>1)'], 'O(2^n)', 'O(1) excluding output',
      `class Solution {
    public List<Integer> grayCode(int n) { List<Integer> answer = new ArrayList<>(); for (int value = 0; value < (1 << n); value++) answer.add(value ^ (value >> 1)); return answer; }
}`,
      `class Solution {
    fun grayCode(n: Int): List<Int> { val answer = mutableListOf<Int>(); for (value in 0 until (1 shl n)) answer.add(value xor (value shr 1)); return answer }
}`,
      `class Solution {
public:
    vector<int> grayCode(int n) { vector<int> answer; for (int value = 0; value < (1 << n); ++value) answer.push_back(value ^ (value >> 1)); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'grayCode', parameterTypes: ['int'], returnType: 'intList', cases: [
      { name: '两位格雷码', args: [2], expected: [0,1,3,2] }, { name: '一位格雷码', args: [1], expected: [0,1] }, { name: '三位格雷码', args: [3], expected: [0,1,3,2,6,7,5,4] },
    ] },
  },
  {
    id: 90, slug: 'subsets-ii', title: '子集 II', studyTags: ['回溯', '排序去重', '子集枚举'],
    summary: '返回可能含重复元素的整数数组的所有不同子集，结果中不能出现重复子集。',
    insight: '先排序让相同值相邻；同一递归层中只选择相同值的第一次出现，仍允许在更深层再次选择它。',
    pitfalls: ['去重只发生在同一递归层', '空集也必须加入答案', '加入答案时需要复制路径'],
    solutions: [s('sorted-backtracking', '排序后同层去重', '每个递归节点先记录当前路径，再枚举后续元素并跳过同层重复项。', ['数组排序', '每次递归复制路径到答案', '从 start 枚举，若 index>start 且与前项相同则跳过'], 'O(n·2^n)', 'O(n) excluding output',
      `class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) { Arrays.sort(nums); List<List<Integer>> answer = new ArrayList<>(); backtrack(0, nums, new ArrayList<>(), answer); return answer; }
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> answer) { answer.add(new ArrayList<>(path)); for (int index = start; index < nums.length; index++) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1, nums, path, answer); path.remove(path.size() - 1); } }
}`,
      `class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> { nums.sort(); val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>(); fun backtrack(start: Int) { answer.add(path.toList()); for (index in start until nums.size) { if (index > start && nums[index] == nums[index - 1]) continue; path.add(nums[index]); backtrack(index + 1); path.removeAt(path.lastIndex) } }; backtrack(0); return answer }
}`,
      `class Solution {
    void backtrack(int start, const vector<int>& nums, vector<int>& path, vector<vector<int>>& answer) { answer.push_back(path); for (int index = start; index < (int)nums.size(); ++index) { if (index > start && nums[index] == nums[index - 1]) continue; path.push_back(nums[index]); backtrack(index + 1, nums, path, answer); path.pop_back(); } }
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) { sort(nums.begin(), nums.end()); vector<vector<int>> answer; vector<int> path; backtrack(0, nums, path, answer); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'subsetsWithDup', parameterTypes: ['intArray'], returnType: 'intListMatrix', cases: [
      { name: '含一个重复值', args: [[1,2,2]], expected: [[],[1],[1,2],[1,2,2],[2],[2,2]] }, { name: '空数组', args: [[]], expected: [[]] }, { name: '单元素', args: [[0]], expected: [[],[0]] },
    ] },
  },
] }
