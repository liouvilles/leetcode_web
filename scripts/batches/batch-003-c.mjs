const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 234, slug: 'palindrome-linked-list', title: '回文链表',
      studyTags: ['快慢指针', '链表反转', '双端比较'],
      summary: '判断单链表中的节点值从前向后和从后向前读取是否相同，并使用常数额外空间。',
      insight: '快慢指针定位后半部分起点，原地反转后即可与前半部分同步比较。',
      pitfalls: ['奇数长度时中间节点无需配对', '比较次数由反转后的后半链长度决定', '反转会暂时修改链表结构'],
      solutions: [s('reverse-second-half', '反转后半链表', '最优', '定位中点、反转后半段，再从链表两端向中间比较。', ['快指针走两步、慢指针走一步', '反转 slow 所在的后半链', '从 head 和反转头同步比较'], 'O(n)', 'O(1)',
        `class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = reverse(slow), first = head;
        while (second != null) { if (first.val != second.val) return false; first = first.next; second = second.next; }
        return true;
    }
    private ListNode reverse(ListNode node) { ListNode previous = null; while (node != null) { ListNode next = node.next; node.next = previous; previous = node; node = next; } return previous; }
}`,
        `class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head; var fast = head
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        var first = head; var second = reverse(slow)
        while (second != null) { if (first?.\`val\` != second.\`val\`) return false; first = first?.next; second = second.next }
        return true
    }
    private fun reverse(start: ListNode?): ListNode? { var node = start; var previous: ListNode? = null; while (node != null) { val next = node.next; node.next = previous; previous = node; node = next }; return previous }
}`,
        `class Solution {
    ListNode* reverse(ListNode* node) { ListNode* previous = nullptr; while (node) { ListNode* next = node->next; node->next = previous; previous = node; node = next; } return previous; }
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head; ListNode* fast = head;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* first = head; ListNode* second = reverse(slow);
        while (second) { if (first->val != second->val) return false; first = first->next; second = second->next; }
        return true;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isPalindrome', parameterTypes: ['listNode'], returnType: 'boolean', cases: [
        { name: '偶数长度回文链表', args: [[1, 2, 2, 1]], expected: true },
        { name: '两个节点不相同', args: [[1, 2]], expected: false },
        { name: '奇数长度回文链表', args: [[1, 2, 3, 2, 1]], expected: true },
      ] },
    },
    {
      id: 238, slug: 'product-of-array-except-self', title: '除自身以外数组的乘积',
      studyTags: ['前缀乘积', '后缀乘积', '无除法'],
      summary: '对数组每个位置，计算除该位置元素外其余所有元素的乘积，不能使用除法。',
      insight: '答案由左侧所有元素乘积与右侧所有元素乘积相乘得到；前缀写进答案，后缀用一个滚动变量补上。',
      pitfalls: ['前缀和后缀的空乘积为一', '零元素由乘积流程自然处理', '后缀变量应在写答案之后更新'],
      solutions: [s('prefix-suffix', '前缀数组 + 滚动后缀', '最优', '先把每个位置左侧乘积写入结果，再反向乘上右侧乘积。', ['answer[0] 初始化为一', '正向累计左侧乘积', '反向维护 suffix 并乘入答案'], 'O(n)', 'O(1) extra',
        `class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length]; answer[0] = 1;
        for (int index = 1; index < nums.length; index++) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.length - 1; index >= 0; index--) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
}`,
        `class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size); answer[0] = 1
        for (index in 1 until nums.size) answer[index] = answer[index - 1] * nums[index - 1]
        var suffix = 1
        for (index in nums.lastIndex downTo 0) { answer[index] *= suffix; suffix *= nums[index] }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> answer(nums.size(), 1);
        for (int index = 1; index < (int)nums.size(); ++index) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.size() - 1; index >= 0; --index) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'productExceptSelf', parameterTypes: ['intArray'], returnType: 'intArray', cases: [
        { name: '连续正整数', args: [[1, 2, 3, 4]], expected: [24, 12, 8, 6] },
        { name: '包含一个零', args: [[-1, 1, 0, -3, 3]], expected: [0, 0, 9, 0, 0] },
        { name: '两个元素', args: [[2, 3]], expected: [3, 2] },
      ] },
    },
    {
      id: 239, slug: 'sliding-window-maximum', title: '滑动窗口最大值',
      studyTags: ['单调队列', '滑动窗口', '下标过期'],
      summary: '固定长度 k 的窗口从数组左端滑到右端，返回每个窗口中的最大值。',
      insight: '双端队列只保留值严格递减的候选下标；队首永远是当前窗口最大值，较小且更早的元素永久失去竞争力。',
      pitfalls: ['队列保存下标才能判断过期', '新值入队前要从队尾移除不大于它的值', '右端到达 k-1 后才产生答案'],
      solutions: [s('monotonic-deque', '递减单调队列', '最优', '维护当前窗口中仍可能成为最大值的下标序列。', ['移除小于窗口左边界的队首', '移除值不大于当前值的队尾', '当前下标入队并在窗口成形后记录队首值'], 'O(n)', 'O(k)',
        `class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1]; Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) { while (!deque.isEmpty() && deque.peekFirst() <= right - k) deque.pollFirst(); while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) deque.pollLast(); deque.offerLast(right); if (right >= k - 1) answer[right - k + 1] = nums[deque.peekFirst()]; }
        return answer;
    }
}`,
        `class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answer = IntArray(nums.size - k + 1); val deque: ArrayDeque<Int> = ArrayDeque()
        for (right in nums.indices) { while (deque.isNotEmpty() && deque.first() <= right - k) deque.removeFirst(); while (deque.isNotEmpty() && nums[deque.last()] <= nums[right]) deque.removeLast(); deque.addLast(right); if (right >= k - 1) answer[right - k + 1] = nums[deque.first()] }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> answer; deque<int> candidates;
        for (int right = 0; right < (int)nums.size(); ++right) { while (!candidates.empty() && candidates.front() <= right - k) candidates.pop_front(); while (!candidates.empty() && nums[candidates.back()] <= nums[right]) candidates.pop_back(); candidates.push_back(right); if (right >= k - 1) answer.push_back(nums[candidates.front()]); }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'maxSlidingWindow', parameterTypes: ['intArray', 'int'], returnType: 'intArray', cases: [
        { name: '窗口最大值多次切换', args: [[1, 3, -1, -3, 5, 3, 6, 7], 3], expected: [3, 3, 5, 5, 6, 7] },
        { name: '单元素窗口', args: [[1], 1], expected: [1] },
        { name: '窗口覆盖整个数组', args: [[9, 11], 2], expected: [11] },
      ] },
    },
    {
      id: 240, slug: 'search-a-2d-matrix-ii', title: '搜索二维矩阵 II',
      studyTags: ['Z 字形搜索', '矩阵单调性', '线性消除'],
      summary: '矩阵每行从左到右递增、每列从上到下递增，判断目标值是否存在。',
      insight: '从右上角开始，当前值过大就左移排除一列，过小就下移排除一行。',
      pitfalls: ['该矩阵并非按行整体连续有序', '起点应选择右上或左下角', '每一步至少排除一整行或一整列'],
      solutions: [s('top-right-walk', '右上角阶梯搜索', '最优', '利用右上角同时是所在行最大候选和所在列最小候选的性质。', ['从 row=0、column=n-1 开始', '当前值大于目标则左移', '当前值小于目标则下移'], 'O(m+n)', 'O(1)',
        `class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) { int value = matrix[row][column]; if (value == target) return true; if (value > target) column--; else row++; }
        return false;
    }
}`,
        `class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0; var column = matrix[0].lastIndex
        while (row < matrix.size && column >= 0) { val value = matrix[row][column]; if (value == target) return true; if (value > target) column-- else row++ }
        return false
    }
}`,
        `class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0, column = matrix[0].size() - 1;
        while (row < (int)matrix.size() && column >= 0) { int value = matrix[row][column]; if (value == target) return true; if (value > target) --column; else ++row; }
        return false;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'searchMatrix', parameterTypes: ['intMatrix', 'int'], returnType: 'boolean', cases: [
        { name: '目标位于矩阵内部', args: [[[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], 5], expected: true },
        { name: '目标不存在', args: [[[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22]], 20], expected: false },
        { name: '单格矩阵未命中', args: [[[1]], 2], expected: false },
      ] },
    },
    {
      id: 242, slug: 'valid-anagram', title: '有效的字母异位词',
      studyTags: ['字符计数', '频次抵消', '字符串'],
      summary: '判断两个只含小写字母的字符串是否由完全相同的字符及出现次数组成。',
      insight: '长度相同是必要条件；一个字符串增加计数、另一个减少计数后，所有桶应归零。',
      pitfalls: ['字符种类相同但次数不同仍不是异位词', '先判断长度可以提前失败', '输入限定小写英文字母'],
      solutions: [s('frequency-array', '定长频次数组', '最优', '用 26 个整数同时累计两个字符串的字符差值。', ['长度不同直接返回假', '同一位置对 s 加一、对 t 减一', '检查全部计数是否为零'], 'O(n)', 'O(1)',
        `class Solution {
    public boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) return false;
        int[] counts = new int[26];
        for (int index = 0; index < first.length(); index++) { counts[first.charAt(index) - 'a']++; counts[second.charAt(index) - 'a']--; }
        for (int count : counts) if (count != 0) return false;
        return true;
    }
}`,
        `class Solution {
    fun isAnagram(first: String, second: String): Boolean {
        if (first.length != second.length) return false
        val counts = IntArray(26)
        for (index in first.indices) { counts[first[index] - 'a']++; counts[second[index] - 'a']-- }
        return counts.all { it == 0 }
    }
}`,
        `class Solution {
public:
    bool isAnagram(string first, string second) {
        if (first.size() != second.size()) return false;
        array<int, 26> counts{};
        for (int index = 0; index < (int)first.size(); ++index) { ++counts[first[index] - 'a']; --counts[second[index] - 'a']; }
        return all_of(counts.begin(), counts.end(), [](int count) { return count == 0; });
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isAnagram', parameterTypes: ['string', 'string'], returnType: 'boolean', cases: [
        { name: '字符重排后相同', args: ['anagram', 'nagaram'], expected: true },
        { name: '字符频次不同', args: ['rat', 'car'], expected: false },
        { name: '两个空字符串', args: ['', ''], expected: true },
      ] },
    },
  ],
}
