const l=92,e="reverse-linked-list-ii",t="Reverse Linked List II",v="中等",p="链表",n=["链表"],m=!1,o="https://leetcode.cn/problems/reverse-linked-list-ii/",i="反转链表 II",s=["链表","头插法","局部反转"],r="只反转单链表从 left 到 right 的连续节点区间，并返回修改后的头节点。",u="找到区间前驱后，把区间内后续节点逐个摘下并插到区间最前方，可一次扫描原地完成。",d=["left 可能等于一，需要哑节点","区间长度为一时无需移动","每次头插都要保留被摘节点的后继"],c=[{id:"front-insertion",title:"区间头插反转",kind:"最优",idea:"固定区间前驱和区间原首节点，将其后的节点依次插到前驱之后。",steps:["走到 left 前一个节点","重复摘下 current.next","把摘下节点插到 previous.next"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), previous = dummy; for (int position = 1; position < left; position++) previous = previous.next;
        ListNode current = previous.next;
        for (int count = 0; count < right - left; count++) { ListNode moved = current.next; current.next = moved.next; moved.next = previous.next; previous.next = moved; }
        return dummy.next;
    }
}
`,kotlin:`class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous = dummy; for (position in 1 until left) previous = previous.next!!
        val current = previous.next!!
        repeat(right - left) { val moved = current.next!!; current.next = moved.next; moved.next = previous.next; previous.next = moved }
        return dummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode dummy(0, head); ListNode* previous = &dummy; for (int position = 1; position < left; ++position) previous = previous->next;
        ListNode* current = previous->next;
        for (int count = 0; count < right - left; ++count) { ListNode* moved = current->next; current->next = moved->next; moved->next = previous->next; previous->next = moved; } return dummy.next;
    }
};
`}}],x={id:92,slug:e,titleEn:t,difficulty:"中等",category:"链表",officialTags:n,paidOnly:!1,sourceUrl:o,title:i,studyTags:s,summary:r,insight:u,pitfalls:d,solutions:c};export{p as category,x as default,v as difficulty,l as id,u as insight,n as officialTags,m as paidOnly,d as pitfalls,e as slug,c as solutions,o as sourceUrl,s as studyTags,r as summary,i as title,t as titleEn};
