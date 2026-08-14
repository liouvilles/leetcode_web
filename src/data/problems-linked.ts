import type { Problem } from '../types'

export const linkedProblems: Problem[] = [
  {
    id: 20,
    slug: 'valid-parentheses',
    title: '有效的括号',
    titleEn: 'Valid Parentheses',
    difficulty: '简单',
    category: '栈',
    officialTags: ['字符串', '栈'],
    studyTags: ['配对消除', '后进先出', '边界检查'],
    summary: '判断只含三类括号的字符串是否满足类型匹配且闭合顺序正确。',
    insight: '右括号只能和最近一个尚未匹配的左括号配对，这正是栈的后进先出语义。',
    pitfalls: ['右括号出现时栈可能为空', '遍历结束后栈也必须为空', '字符数量为奇数时一定无效'],
    sourceUrl: 'https://leetcode.cn/problems/valid-parentheses/',
    solutions: [
      {
        id: 'repeated-removal',
        title: '反复消除相邻括号',
        kind: '基础',
        idea: '任何合法括号串都能通过不断删除相邻的 ()、[]、{} 最终变为空串。',
        steps: ['循环替换三种相邻括号对', '某一轮长度不变时停止', '检查剩余字符串是否为空'],
        complexity: { time: 'O(n²)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public boolean isValid(String s) {
        int previousLength;
        do {
            previousLength = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (s.length() != previousLength);
        return s.isEmpty();
    }
}`,
          kotlin: `class Solution {
    fun isValid(input: String): Boolean {
        var s = input
        do {
            val previousLength = s.length
            s = s.replace("()", "").replace("[]", "").replace("{}", "")
        } while (s.length != previousLength)
        return s.isEmpty()
    }
}`,
          cpp: `class Solution {
public:
    bool isValid(string s) {
        size_t previous;
        do {
            previous = s.size();
            eraseAll(s, "()"); eraseAll(s, "[]"); eraseAll(s, "{}");
        } while (s.size() != previous);
        return s.empty();
    }

private:
    void eraseAll(string& s, const string& pair) {
        size_t pos;
        while ((pos = s.find(pair)) != string::npos) s.erase(pos, 2);
    }
};`,
        },
      },
      {
        id: 'stack',
        title: '栈匹配',
        kind: '最优',
        idea: '遇到左括号时压入期待的右括号；遇到右括号时必须与栈顶一致。',
        steps: ['奇数长度提前失败', '左括号压入对应的右括号', '右括号弹栈匹配，最终要求栈为空'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}`,
          kotlin: `class Solution {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        val stack = java.util.ArrayDeque<Char>()
        for (c in s) {
            when (c) {
                '(' -> stack.push(')')
                '[' -> stack.push(']')
                '{' -> stack.push('}')
                else -> if (stack.isEmpty() || stack.pop() != c) return false
            }
        }
        return stack.isEmpty()
    }
}`,
          cpp: `class Solution {
public:
    bool isValid(string s) {
        if (s.size() % 2 == 1) return false;
        stack<char> expected;
        for (char c : s) {
            if (c == '(') expected.push(')');
            else if (c == '[') expected.push(']');
            else if (c == '{') expected.push('}');
            else {
                if (expected.empty() || expected.top() != c) return false;
                expected.pop();
            }
        }
        return expected.empty();
    }
};`,
        },
      },
    ],
  },
  {
    id: 21,
    slug: 'merge-two-sorted-lists',
    title: '合并两个有序链表',
    titleEn: 'Merge Two Sorted Lists',
    difficulty: '简单',
    category: '链表',
    officialTags: ['链表', '递归'],
    studyTags: ['虚拟头结点', '双指针', '有序合并'],
    summary: '把两个非递减链表合并为一个非递减链表，并复用原有结点。',
    insight: '两个链表的头部较小者一定是剩余结果的下一个结点。',
    pitfalls: ['结果头结点可能来自任意一条链表', '循环结束后要接上未处理的尾部', '递归深度与结点总数同阶'],
    sourceUrl: 'https://leetcode.cn/problems/merge-two-sorted-lists/',
    solutions: [
      {
        id: 'iterative-dummy',
        title: '虚拟头结点迭代',
        kind: '最优',
        idea: '虚拟头结点统一处理结果链表为空与非空的情况，尾指针持续接入较小结点。',
        steps: ['创建 dummy 与 tail', '比较两条链表头部并移动被选中的指针', '接上剩余链表并返回 dummy.next'],
        complexity: { time: 'O(m+n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}`,
          kotlin: `class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var first = list1
        var second = list2
        val dummy = ListNode(0)
        var tail = dummy
        while (first != null && second != null) {
            if (first.\`val\` <= second.\`val\`) {
                tail.next = first
                first = first.next
            } else {
                tail.next = second
                second = second.next
            }
            tail = tail.next!!
        }
        tail.next = first ?: second
        return dummy.next
    }
}`,
          cpp: `class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode dummy;
        ListNode* tail = &dummy;
        while (list1 && list2) {
            if (list1->val <= list2->val) {
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
            tail = tail->next;
        }
        tail->next = list1 ? list1 : list2;
        return dummy.next;
    }
};`,
        },
      },
      {
        id: 'recursive',
        title: '递归合并',
        kind: '进阶',
        idea: '选出较小头结点后，问题缩小为该结点的后继与另一条链表的合并。',
        steps: ['任一链表为空时返回另一条', '选较小的头结点', '递归设置它的 next 并返回'],
        complexity: { time: 'O(m+n)', space: 'O(m+n)' },
        code: {
          java: `class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}`,
          kotlin: `class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        return if (list1.\`val\` <= list2.\`val\`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }
}`,
          cpp: `class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (!list1) return list2;
        if (!list2) return list1;
        if (list1->val <= list2->val) {
            list1->next = mergeTwoLists(list1->next, list2);
            return list1;
        }
        list2->next = mergeTwoLists(list1, list2->next);
        return list2;
    }
};`,
        },
      },
    ],
  },
  {
    id: 141,
    slug: 'linked-list-cycle',
    title: '环形链表',
    titleEn: 'Linked List Cycle',
    difficulty: '简单',
    category: '链表',
    officialTags: ['链表', '哈希表', '双指针'],
    studyTags: ['快慢指针', 'Floyd 判圈', '访问状态'],
    summary: '判断单链表沿 next 指针前进时是否会进入一个环。',
    insight: '如果存在环，快指针进入环后会不断缩小与慢指针的环上距离，最终相遇。',
    pitfalls: ['检查 fast 与 fast.next 后才能走两步', '比较的是结点身份而非结点值', '空链表与单结点无环都要返回 false'],
    sourceUrl: 'https://leetcode.cn/problems/linked-list-cycle/',
    solutions: [
      {
        id: 'visited-set',
        title: '记录访问结点',
        kind: '基础',
        idea: '把每个访问过的结点引用存入集合，再次遇到同一引用即可确认有环。',
        steps: ['从头结点开始遍历', '当前结点已在集合中则返回 true', '记录结点并继续，走到 null 则无环'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}`,
          kotlin: `class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val visited = HashSet<ListNode>()
        var node = head
        while (node != null) {
            if (!visited.add(node)) return true
            node = node.next
        }
        return false
    }
}`,
          cpp: `class Solution {
public:
    bool hasCycle(ListNode* head) {
        unordered_set<ListNode*> visited;
        while (head) {
            if (!visited.insert(head).second) return true;
            head = head->next;
        }
        return false;
    }
};`,
        },
      },
      {
        id: 'floyd',
        title: 'Floyd 快慢指针',
        kind: '最优',
        idea: '慢指针每次一步、快指针每次两步；有环时二者必然相遇。',
        steps: ['slow 与 fast 都从头部出发', '确认快指针可走两步后推进', '相遇则有环，快指针到 null 则无环'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}`,
          kotlin: `class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow === fast) return true
        }
        return false
    }
}`,
          cpp: `class Solution {
public:
    bool hasCycle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) return true;
        }
        return false;
    }
};`,
        },
      },
    ],
  },
  {
    id: 206,
    slug: 'reverse-linked-list',
    title: '反转链表',
    titleEn: 'Reverse Linked List',
    difficulty: '简单',
    category: '链表',
    officialTags: ['链表', '递归'],
    studyTags: ['指针重连', '前驱指针', '递归回溯'],
    summary: '原地反转单链表的 next 指向，并返回新的头结点。',
    insight: '修改当前 next 之前必须先保存原后继，否则会失去尚未处理的链表。',
    pitfalls: ['重连前保存 next', '旧头结点最终要指向 null', '递归版本不要忘记切断原方向'],
    sourceUrl: 'https://leetcode.cn/problems/reverse-linked-list/',
    solutions: [
      {
        id: 'iterative',
        title: '三指针迭代',
        kind: '最优',
        idea: 'prev 指向已经反转的前缀，current 指向下一个待处理结点。',
        steps: ['保存 current.next', '让 current.next 指向 prev', 'prev 与 current 同步前进'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}`,
          kotlin: `class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }
        return previous
    }
}`,
          cpp: `class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* previous = nullptr;
        ListNode* current = head;
        while (current) {
            ListNode* next = current->next;
            current->next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
};`,
        },
      },
      {
        id: 'recursive',
        title: '递归回溯',
        kind: '进阶',
        idea: '先递归反转后缀，再在回溯时把当前结点接到原后继的后面。',
        steps: ['空结点或尾结点直接返回', '递归反转 head.next', '令 head.next.next 指回 head 并断开旧指向'],
        complexity: { time: 'O(n)', space: 'O(n)' },
        code: {
          java: `class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}`,
          kotlin: `class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val newHead = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return newHead
    }
}`,
          cpp: `class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* newHead = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return newHead;
    }
};`,
        },
      },
    ],
  },
  {
    id: 876,
    slug: 'middle-of-the-linked-list',
    title: '链表的中间结点',
    titleEn: 'Middle of the Linked List',
    difficulty: '简单',
    category: '链表',
    officialTags: ['链表', '双指针'],
    studyTags: ['快慢指针', '二次遍历', '偶数中点'],
    summary: '返回链表的中间结点；若结点数为偶数，返回两个中间结点中的后一个。',
    insight: '快指针走过两个结点的时间里慢指针走一个，快指针到终点时慢指针恰好在中间。',
    pitfalls: ['偶数长度要求返回后一个中点', '链表非空但仍应保持空值安全', '快指针循环条件决定中点口径'],
    sourceUrl: 'https://leetcode.cn/problems/middle-of-the-linked-list/',
    solutions: [
      {
        id: 'count-then-walk',
        title: '计数后二次遍历',
        kind: '基础',
        idea: '先统计结点总数 n，再从头结点移动 floor(n/2) 步。',
        steps: ['第一次遍历计算长度', '重置指针到头部', '移动 length / 2 次'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) length++;
        for (int i = 0; i < length / 2; i++) head = head.next;
        return head;
    }
}`,
          kotlin: `class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var length = 0
        var node = head
        while (node != null) {
            length++
            node = node.next
        }
        node = head
        repeat(length / 2) { node = node?.next }
        return node
    }
}`,
          cpp: `class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        int length = 0;
        for (ListNode* node = head; node; node = node->next) ++length;
        for (int i = 0; i < length / 2; ++i) head = head->next;
        return head;
    }
};`,
        },
      },
      {
        id: 'fast-slow',
        title: '快慢指针',
        kind: '最优',
        idea: '单次遍历中让快指针速度为慢指针的两倍。',
        steps: ['两个指针从头部出发', 'fast 可走两步时同时推进', '循环结束返回 slow'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}`,
          kotlin: `class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}`,
          cpp: `class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
};`,
        },
      },
    ],
  },
]
