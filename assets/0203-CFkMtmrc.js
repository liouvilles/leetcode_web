const v=203,e="remove-linked-list-elements",n="Remove Linked List Elements",m="简单",a="链表",t=["链表","递归"],p=!1,s="https://leetcode.cn/problems/remove-linked-list-elements/",i="移除链表元素",o=["虚拟头结点","链表删除","单次遍历"],u="删除单链表中所有值等于指定值的节点，并返回新的头节点。",l="虚拟头结点让删除原头节点与删除中间节点使用完全相同的前驱改线逻辑。",d=["可能连续删除多个节点","删除时 previous 不应前进","所有节点都被删除时返回空链表"],r=[{id:"dummy-head",title:"虚拟头结点迭代删除",kind:"最优",idea:"让 current 始终检查 previous 的下一个节点，按条件跳过或前进。",steps:["dummy.next=head","若 previous.next 值命中则跨过它","否则 previous 向前移动"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), previous = dummy;
        while (previous.next != null) { if (previous.next.val == val) previous.next = previous.next.next; else previous = previous.next; }
        return dummy.next;
    }
}
`,kotlin:`class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous: ListNode? = dummy
        while (previous?.next != null) { if (previous.next?.\`val\` == value) previous.next = previous.next?.next else previous = previous.next }
        return dummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode dummy(0, head); ListNode* previous = &dummy;
        while (previous->next) { if (previous->next->val == val) previous->next = previous->next->next; else previous = previous->next; }
        return dummy.next;
    }
};
`}}],c={id:203,slug:e,titleEn:n,difficulty:"简单",category:"链表",officialTags:t,paidOnly:!1,sourceUrl:s,title:i,studyTags:o,summary:u,insight:l,pitfalls:d,solutions:r};export{a as category,c as default,m as difficulty,v as id,l as insight,t as officialTags,p as paidOnly,d as pitfalls,e as slug,r as solutions,s as sourceUrl,o as studyTags,u as summary,i as title,n as titleEn};
