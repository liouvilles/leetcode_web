const a=206,e="reverse-linked-list",n="Reverse Linked List",c="简单",x="链表",t=["链表","递归"],h=!1,r="https://leetcode.cn/problems/reverse-linked-list/",s="反转链表",i=["指针重连","前驱指针","递归回溯"],d="原地反转单链表的 next 指向，并返回新的头结点。",u="修改当前 next 之前必须先保存原后继，否则会失去尚未处理的链表。",o=["重连前保存 next","旧头结点最终要指向 null","递归版本不要忘记切断原方向"],l=[{id:"iterative",title:"三指针迭代",kind:"最优",idea:"prev 指向已经反转的前缀，current 指向下一个待处理结点。",steps:["保存 current.next","让 current.next 指向 prev","prev 与 current 同步前进"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}},{id:"recursive",title:"递归回溯",kind:"进阶",idea:"先递归反转后缀，再在回溯时把当前结点接到原后继的后面。",steps:["空结点或尾结点直接返回","递归反转 head.next","令 head.next.next 指回 head 并断开旧指向"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
`,kotlin:`class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val newHead = reverseList(head.next)
        head.next?.next = head
        head.next = null
        return newHead
    }
}
`,cpp:`class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* newHead = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return newHead;
    }
};
`}}],p={id:206,slug:e,titleEn:n,difficulty:"简单",category:"链表",officialTags:t,paidOnly:!1,sourceUrl:r,title:s,studyTags:i,summary:d,insight:u,pitfalls:o,solutions:l};export{x as category,p as default,c as difficulty,a as id,u as insight,t as officialTags,h as paidOnly,o as pitfalls,e as slug,l as solutions,r as sourceUrl,i as studyTags,d as summary,s as title,n as titleEn};
