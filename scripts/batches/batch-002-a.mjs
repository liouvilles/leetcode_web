const makeSolution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-002',
  problems: [
    {
      id: 9,
      slug: 'palindrome-number',
      title: '回文数',
      studyTags: ['数字反转', '只反转一半', '边界判断'],
      summary: '判断一个整数从左向右和从右向左读取时是否相同，且不把数字转换成字符串。',
      insight: '只需反转数字的后一半，当原数字缩短到不大于反转部分时即可比较，避免完整反转溢出。',
      pitfalls: ['负数一定不是回文数', '除零本身外，末位为零的数不可能回文', '奇数位数字比较时要丢弃中间位'],
      solutions: [makeSolution(
        'reverse-half', '反转后一半数字', '最优',
        '逐位把原数字末尾移到 reversed 中，直到 reversed 的位数达到原数字的一半。',
        ['排除负数和非零末位零', '循环反转末位直到 x <= reversed', '比较两半，奇数位时忽略 reversed 的末位'],
        'O(log x)', 'O(1)',
        `class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}`,
        `class Solution {
    fun isPalindrome(value: Int): Boolean {
        if (value < 0 || (value % 10 == 0 && value != 0)) return false
        var x = value
        var reversed = 0
        while (x > reversed) {
            reversed = reversed * 10 + x % 10
            x /= 10
        }
        return x == reversed || x == reversed / 10
    }
}`,
        `class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
};`,
      )],
      tests: { schemaVersion: 1, mode: 'function', method: 'isPalindrome', parameterTypes: ['int'], returnType: 'boolean', cases: [
        { name: '奇数位回文数', args: [121], expected: true },
        { name: '负数不是回文数', args: [-121], expected: false },
        { name: '非零末位零', args: [10], expected: false },
      ] },
    },
    {
      id: 13,
      slug: 'roman-to-integer',
      title: '罗马数字转整数',
      studyTags: ['相邻比较', '减法组合', '线性扫描'],
      summary: '把由合法罗马数字字符组成的字符串转换成对应整数。',
      insight: '若当前字符代表的数值小于右侧相邻字符，它就是减法组合的一部分，应从总和中减去；否则加上。',
      pitfalls: ['比较的是相邻数值而不是字符编码', '最后一个字符总是加到结果中', '输入保证为合法罗马数字'],
      solutions: [makeSolution(
        'adjacent-values', '相邻数值扫描', '最优',
        '从左到右比较当前值与后一值，用符号决定当前值的贡献。',
        ['建立罗马字符数值映射', '当前值小于后一值时减去当前值', '其他情况加上当前值'],
        'O(n)', 'O(1)',
        `class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int index = 0; index < s.length(); index++) {
            int current = value(s.charAt(index));
            int next = index + 1 < s.length() ? value(s.charAt(index + 1)) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }

    private int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
}`,
        `class Solution {
    fun romanToInt(s: String): Int {
        var total = 0
        for (index in s.indices) {
            val current = value(s[index])
            val next = if (index < s.lastIndex) value(s[index + 1]) else 0
            total += if (current < next) -current else current
        }
        return total
    }

    private fun value(symbol: Char): Int = when (symbol) {
        'I' -> 1; 'V' -> 5; 'X' -> 10; 'L' -> 50
        'C' -> 100; 'D' -> 500; else -> 1000
    }
}`,
        `class Solution {
    int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
public:
    int romanToInt(string s) {
        int total = 0;
        for (int index = 0; index < (int)s.size(); ++index) {
            int current = value(s[index]);
            int next = index + 1 < (int)s.size() ? value(s[index + 1]) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }
};`,
      )],
      tests: { schemaVersion: 1, mode: 'function', method: 'romanToInt', parameterTypes: ['string'], returnType: 'int', cases: [
        { name: '连续相同字符相加', args: ['III'], expected: 3 },
        { name: '包含一个减法组合', args: ['LVIII'], expected: 58 },
        { name: '包含多种减法组合', args: ['MCMXCIV'], expected: 1994 },
      ] },
    },
    {
      id: 17,
      slug: 'letter-combinations-of-a-phone-number',
      title: '电话号码的字母组合',
      studyTags: ['回溯', '字符映射', '笛卡尔积'],
      summary: '根据数字键 2 到 9 对应的字母，返回给定数字串可以表示的所有字母组合。',
      insight: '每个数字提供一组选项，按位置深度优先选择一个字母即可枚举这些集合的笛卡尔积。',
      pitfalls: ['空输入应返回空列表而不是包含空字符串', '每深入一层只处理一个数字', '回溯后要删除路径末尾字符'],
      solutions: [makeSolution(
        'backtracking', '逐位回溯', '最优',
        '用固定数组保存按键映射，递归构造与数字串等长的字母路径。',
        ['空输入直接返回空集合', '读取当前位置数字对应的字母串', '依次选择字母并递归到下一位'],
        'O(4ⁿ · n)', 'O(n)',
        `class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        build(digits, 0, new StringBuilder(), answer);
        return answer;
    }

    private void build(String digits, int index, StringBuilder path, List<String> answer) {
        if (index == digits.length()) { answer.add(path.toString()); return; }
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (int offset = 0; offset < letters.length(); offset++) {
            path.append(letters.charAt(offset));
            build(digits, index + 1, path, answer);
            path.setLength(path.length() - 1);
        }
    }
}`,
        `class Solution {
    private val letters = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val answer = ArrayList<String>()
        build(digits, 0, StringBuilder(), answer)
        return answer
    }

    private fun build(digits: String, index: Int, path: StringBuilder, answer: MutableList<String>) {
        if (index == digits.length) { answer.add(path.toString()); return }
        for (letter in letters[digits[index].digitToInt()]) {
            path.append(letter)
            build(digits, index + 1, path, answer)
            path.deleteCharAt(path.lastIndex)
        }
    }
}`,
        `class Solution {
    const vector<string> letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    void build(const string& digits, int index, string& path, vector<string>& answer) {
        if (index == (int)digits.size()) { answer.push_back(path); return; }
        for (char letter : letters[digits[index] - '0']) {
            path.push_back(letter);
            build(digits, index + 1, path, answer);
            path.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};
        vector<string> answer;
        string path;
        build(digits, 0, path, answer);
        return answer;
    }
};`,
      )],
      tests: { schemaVersion: 1, mode: 'function', method: 'letterCombinations', parameterTypes: ['string'], returnType: 'stringList', cases: [
        { name: '两个三字母按键', args: ['23'], expected: ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf'] },
        { name: '空数字串', args: [''], expected: [] },
        { name: '单个四字母按键', args: ['7'], expected: ['p', 'q', 'r', 's'] },
      ] },
    },
    {
      id: 24,
      slug: 'swap-nodes-in-pairs',
      title: '两两交换链表中的节点',
      studyTags: ['链表改线', '虚拟头结点', '局部交换'],
      summary: '在不修改节点值的前提下，每两个相邻节点交换一次并返回新的链表头。',
      insight: '虚拟头结点让每一对节点前面始终有一个可操作的 prev，三次改线即可完成局部交换。',
      pitfalls: ['交换的是节点而不是节点值', '奇数长度时最后一个节点保持不动', '改线顺序错误会丢失后续链表'],
      solutions: [makeSolution(
        'iterative-relink', '迭代改线', '最优',
        '每轮保存一对节点，通过 prev、first、second 三个指针调整连接关系。',
        ['创建 dummy 指向 head', '把 prev.next 改为 second，再让 first 指向 second 后继', '让 second 指向 first，并把 prev 移到 first'],
        'O(n)', 'O(1)',
        `class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        while (previous.next != null && previous.next.next != null) {
            ListNode first = previous.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            previous.next = second;
            previous = first;
        }
        return dummy.next;
    }
}`,
        `class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var previous: ListNode? = dummy
        while (previous?.next != null && previous.next?.next != null) {
            val first = previous.next!!
            val second = first.next!!
            first.next = second.next
            second.next = first
            previous.next = second
            previous = first
        }
        return dummy.next
    }
}`,
        `class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy(0, head);
        ListNode* previous = &dummy;
        while (previous->next && previous->next->next) {
            ListNode* first = previous->next;
            ListNode* second = first->next;
            first->next = second->next;
            second->next = first;
            previous->next = second;
            previous = first;
        }
        return dummy.next;
    }
};`,
      )],
      tests: { schemaVersion: 1, mode: 'function', method: 'swapPairs', parameterTypes: ['listNode'], returnType: 'listNode', cases: [
        { name: '偶数个节点全部交换', args: [[1, 2, 3, 4]], expected: [2, 1, 4, 3] },
        { name: '空链表', args: [[]], expected: [] },
        { name: '奇数个节点保留末尾', args: [[1, 2, 3]], expected: [2, 1, 3] },
      ] },
    },
    {
      id: 31,
      slug: 'next-permutation',
      title: '下一个排列',
      studyTags: ['字典序', '逆序后缀', '原地修改'],
      summary: '把整数数组原地变为字典序中紧邻的下一个更大排列；若已是最大排列，则变为最小排列。',
      insight: '从右向左找到第一个仍可增大的位置，用后缀中刚好更大的数替换，再把后缀变为最小升序。',
      pitfalls: ['后缀原本是非递增序列', '交换对象必须是最右侧大于 pivot 的值', '不存在 pivot 时需要反转整个数组'],
      solutions: [makeSolution(
        'pivot-swap-reverse', '转折点交换并反转', '最优',
        '定位最长非递增后缀前的 pivot，交换后反转后缀得到最小增量。',
        ['从右向左找到 nums[i] < nums[i+1]', '从末尾找到第一个大于 nums[i] 的值并交换', '反转 i+1 到末尾的后缀'],
        'O(n)', 'O(1)',
        `class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if (pivot >= 0) {
            int greater = nums.length - 1;
            while (nums[greater] <= nums[pivot]) greater--;
            swap(nums, pivot, greater);
        }
        for (int left = pivot + 1, right = nums.length - 1; left < right; left++, right--) swap(nums, left, right);
    }
    private void swap(int[] nums, int left, int right) { int value = nums[left]; nums[left] = nums[right]; nums[right] = value; }
}`,
        `class Solution {
    fun nextPermutation(nums: IntArray) {
        var pivot = nums.size - 2
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--
        if (pivot >= 0) {
            var greater = nums.lastIndex
            while (nums[greater] <= nums[pivot]) greater--
            swap(nums, pivot, greater)
        }
        var left = pivot + 1
        var right = nums.lastIndex
        while (left < right) swap(nums, left++, right--)
    }
    private fun swap(nums: IntArray, left: Int, right: Int) { val value = nums[left]; nums[left] = nums[right]; nums[right] = value }
}`,
        `class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int pivot = (int)nums.size() - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) --pivot;
        if (pivot >= 0) {
            int greater = nums.size() - 1;
            while (nums[greater] <= nums[pivot]) --greater;
            swap(nums[pivot], nums[greater]);
        }
        reverse(nums.begin() + pivot + 1, nums.end());
    }
};`,
      )],
      tests: { schemaVersion: 1, mode: 'function', method: 'nextPermutation', parameterTypes: ['intArray'], returnType: 'void', cases: [
        { name: '严格升序的下一个排列', args: [[1, 2, 3]], expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 3, 2] }] },
        { name: '最大排列回到最小排列', args: [[3, 2, 1]], expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 2, 3] }] },
        { name: '包含重复值', args: [[1, 1, 5]], expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 5, 1] }] },
      ] },
    },
  ],
}
