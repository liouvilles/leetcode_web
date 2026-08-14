const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 124, slug: 'binary-tree-maximum-path-sum', title: '二叉树中的最大路径和',
      studyTags: ['树形 DP', '后序遍历', '负贡献剪枝'],
      summary: '在二叉树中选择一条不重复节点的连续路径，求路径节点值之和的最大值；路径起止点任意。',
      insight: '向父节点只能贡献左右分支中的一条，但以当前节点为最高点的完整路径可以同时连接左右两条正贡献分支。',
      pitfalls: ['全负数树的答案是最大单节点值', '负的子树贡献应按零处理', '返回父节点的贡献不能同时包含左右两侧'],
      solutions: [s('postorder-gain', '后序最大贡献', '最优', '递归返回向上延伸的最大单支贡献，并用双支路径更新全局答案。', ['左右贡献分别与零取最大', '候选完整路径为 node+left+right', '向上返回 node+max(left,right)'], 'O(n)', 'O(h)',
        `class Solution {
    private int answer;
    public int maxPathSum(TreeNode root) { answer = Integer.MIN_VALUE; gain(root); return answer; }
    private int gain(TreeNode node) { if (node == null) return 0; int left = Math.max(0, gain(node.left)), right = Math.max(0, gain(node.right)); answer = Math.max(answer, node.val + left + right); return node.val + Math.max(left, right); }
}`,
        `class Solution {
    private var answer = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int { answer = Int.MIN_VALUE; gain(root); return answer }
    private fun gain(node: TreeNode?): Int { node ?: return 0; val left = maxOf(0, gain(node.left)); val right = maxOf(0, gain(node.right)); answer = maxOf(answer, node.\`val\` + left + right); return node.\`val\` + maxOf(left, right) }
}`,
        `class Solution {
    int answer = INT_MIN;
    int gain(TreeNode* node) { if (!node) return 0; int left = max(0, gain(node->left)), right = max(0, gain(node->right)); answer = max(answer, node->val + left + right); return node->val + max(left, right); }
public:
    int maxPathSum(TreeNode* root) { answer = INT_MIN; gain(root); return answer; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'maxPathSum', parameterTypes: ['treeNode'], returnType: 'int', cases: [
        { name: '路径穿过根连接两个孩子', args: [[1, 2, 3]], expected: 6 },
        { name: '忽略负根侧的部分贡献', args: [[-10, 9, 20, null, null, 15, 7]], expected: 42 },
        { name: '单个负节点', args: [[-3]], expected: -3 },
      ] },
    },
    {
      id: 134, slug: 'gas-station', title: '加油站',
      studyTags: ['贪心', '区间失败跳过', '总量守恒'],
      summary: '环形路线上每站提供汽油并消耗一定油量到下一站，找出能完成一圈的唯一起点；不存在则返回 -1。',
      insight: '若从当前候选起点到某站累计油量为负，则这段区间内任何位置都不可能作为起点，可把候选直接移到下一站。',
      pitfalls: ['总汽油小于总消耗时必无解', '局部油量失败后清零重新累计', '返回的是下标而不是站点数量'],
      solutions: [s('greedy-reset', '累计失败后重置起点', '最优', '同时维护全局净油量与当前候选区间净油量。', ['累加每站 gas-cost 到 total 与 tank', 'tank<0 时起点改为下一站并清零', 'total>=0 时返回候选，否则 -1'], 'O(n)', 'O(1)',
        `class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int station = 0; station < gas.length; station++) { int balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0; } }
        return total >= 0 ? start : -1;
    }
}`,
        `class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var total = 0; var tank = 0; var start = 0
        for (station in gas.indices) { val balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0 } }
        return if (total >= 0) start else -1
    }
}`,
        `class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int total = 0, tank = 0, start = 0;
        for (int station = 0; station < (int)gas.size(); ++station) { int balance = gas[station] - cost[station]; total += balance; tank += balance; if (tank < 0) { start = station + 1; tank = 0; } }
        return total >= 0 ? start : -1;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'canCompleteCircuit', parameterTypes: ['intArray', 'intArray'], returnType: 'int', cases: [
        { name: '从第四站开始完成一圈', args: [[1, 2, 3, 4, 5], [3, 4, 5, 1, 2]], expected: 3 },
        { name: '总油量不足', args: [[2, 3, 4], [3, 4, 3]], expected: -1 },
        { name: '单站刚好够用', args: [[5], [5]], expected: 0 },
      ] },
    },
    {
      id: 148, slug: 'sort-list', title: '排序链表',
      studyTags: ['归并排序', '快慢指针', '链表合并'],
      summary: '把单链表按节点值升序排序，目标时间复杂度为 O(n log n)。',
      insight: '归并排序适合链表：快慢指针在线性时间切半，两个有序链表又能原地线性合并。',
      pitfalls: ['切半时必须断开前半链尾', '递归基线是零或一个节点', '合并阶段应复用原节点'],
      solutions: [s('merge-sort', '链表归并排序', '最优', '递归把链表切成两半分别排序，再用双指针合并。', ['快慢指针定位中点前驱', '断链并递归排序两半', '用虚拟头结点合并两个有序链'], 'O(n log n)', 'O(log n)',
        `class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = slow.next; slow.next = null;
        return merge(sortList(head), sortList(second));
    }
    private ListNode merge(ListNode first, ListNode second) { ListNode dummy = new ListNode(), tail = dummy; while (first != null && second != null) { if (first.val <= second.val) { tail.next = first; first = first.next; } else { tail.next = second; second = second.next; } tail = tail.next; } tail.next = first != null ? first : second; return dummy.next; }
}`,
        `class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head; var fast = head.next
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        val second = slow?.next; slow?.next = null
        return merge(sortList(head), sortList(second))
    }
    private fun merge(firstValue: ListNode?, secondValue: ListNode?): ListNode? { val dummy = ListNode(0); var tail = dummy; var first = firstValue; var second = secondValue; while (first != null && second != null) { if (first.\`val\` <= second.\`val\`) { tail.next = first; first = first.next } else { tail.next = second; second = second.next }; tail = tail.next!! }; tail.next = first ?: second; return dummy.next }
}`,
        `class Solution {
    ListNode* merge(ListNode* first, ListNode* second) { ListNode dummy; ListNode* tail = &dummy; while (first && second) { if (first->val <= second->val) { tail->next = first; first = first->next; } else { tail->next = second; second = second->next; } tail = tail->next; } tail->next = first ? first : second; return dummy.next; }
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* slow = head; ListNode* fast = head->next;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* second = slow->next; slow->next = nullptr;
        return merge(sortList(head), sortList(second));
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'sortList', parameterTypes: ['listNode'], returnType: 'listNode', cases: [
        { name: '四节点乱序链表', args: [[4, 2, 1, 3]], expected: [1, 2, 3, 4] },
        { name: '包含负数和重复值', args: [[-1, 5, 3, 4, 0, 3]], expected: [-1, 0, 3, 3, 4, 5] },
        { name: '空链表', args: [[]], expected: [] },
      ] },
    },
    {
      id: 150, slug: 'evaluate-reverse-polish-notation', title: '逆波兰表达式求值',
      studyTags: ['栈', '后缀表达式', '操作数顺序'],
      summary: '计算由整数和加减乘除运算符组成的有效逆波兰表达式，整数除法向零截断。',
      insight: '数字入栈；遇到运算符时弹出右操作数和左操作数，计算结果再入栈。',
      pitfalls: ['减法和除法必须保留左右操作数顺序', '负整数 token 不是减号运算符', 'Java、Kotlin、C++ 整数除法均向零截断'],
      solutions: [s('operand-stack', '操作数栈', '最优', '扫描后缀 token 并即时归约最近两个操作数。', ['数字解析后入栈', '运算符先弹 right 再弹 left', '计算 left op right 并压回'], 'O(n)', 'O(n)',
        `class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) { if (token.length() == 1 && "+-*/".contains(token)) { int right = stack.pop(), left = stack.pop(); if (token.equals("+")) stack.push(left + right); else if (token.equals("-")) stack.push(left - right); else if (token.equals("*")) stack.push(left * right); else stack.push(left / right); } else stack.push(Integer.parseInt(token)); }
        return stack.pop();
    }
}`,
        `class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for (token in tokens) { if (token.length == 1 && token[0] in "+-*/") { val right = stack.removeLast(); val left = stack.removeLast(); stack.addLast(when (token) { "+" -> left + right; "-" -> left - right; "*" -> left * right; else -> left / right }) } else stack.addLast(token.toInt()) }
        return stack.last()
    }
}`,
        `class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        vector<int> stack;
        for (const string& token : tokens) { if (token.size() == 1 && string("+-*/").find(token[0]) != string::npos) { int right = stack.back(); stack.pop_back(); int left = stack.back(); stack.pop_back(); if (token == "+") stack.push_back(left + right); else if (token == "-") stack.push_back(left - right); else if (token == "*") stack.push_back(left * right); else stack.push_back(left / right); } else stack.push_back(stoi(token)); }
        return stack.back();
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'evalRPN', parameterTypes: ['stringArray'], returnType: 'int', cases: [
        { name: '先加后乘', args: [['2', '1', '+', '3', '*']], expected: 9 },
        { name: '除法向零截断', args: [['4', '13', '5', '/', '+']], expected: 6 },
        { name: '包含负数和多层运算', args: [['10', '6', '9', '3', '+', '-11', '*', '/', '*', '17', '+', '5', '+']], expected: 22 },
      ] },
    },
    {
      id: 151, slug: 'reverse-words-in-a-string', title: '反转字符串中的单词',
      studyTags: ['字符串解析', '空白压缩', '逆序拼接'],
      summary: '反转字符串中单词的顺序，结果仅保留单词间一个空格，并去除首尾与多余空格。',
      insight: '按一个或多个空白分割出有效单词，再从后向前用单空格连接即可。',
      pitfalls: ['需要先去除首尾空格', '多个连续空格应视为一个分隔符', '单词内部字符顺序不反转'],
      solutions: [s('split-reverse', '分词后逆序', '最优', '规范化空白并逆序拼接单词数组。', ['trim 去除首尾空白', '按连续空白拆分', '从末尾向前用单空格连接'], 'O(n)', 'O(n)',
        `class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\\\s+"); StringBuilder answer = new StringBuilder();
        for (int index = words.length - 1; index >= 0; index--) { if (answer.length() > 0) answer.append(' '); answer.append(words[index]); }
        return answer.toString();
    }
}`,
        `class Solution {
    fun reverseWords(s: String): String = s.trim().split(Regex("\\\\s+")).asReversed().joinToString(" ")
}`,
        `class Solution {
public:
    string reverseWords(string s) {
        stringstream stream(s); vector<string> words; string word; while (stream >> word) words.push_back(word);
        reverse(words.begin(), words.end()); string answer;
        for (int index = 0; index < (int)words.size(); ++index) { if (index) answer.push_back(' '); answer += words[index]; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'reverseWords', parameterTypes: ['string'], returnType: 'string', cases: [
        { name: '普通三个单词', args: ['the sky is blue'], expected: 'blue is sky the' },
        { name: '去除首尾空格', args: ['  hello world  '], expected: 'world hello' },
        { name: '压缩单词间多个空格', args: ['a good   example'], expected: 'example good a' },
      ] },
    },
  ],
}
