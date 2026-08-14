const a=24,n="swap-nodes-in-pairs",e="Swap Nodes in Pairs",p="中等",l="链表",s=["链表","递归"],x=!1,t="https://leetcode.cn/problems/swap-nodes-in-pairs/",i="两两交换链表中的节点",o=["链表改线","虚拟头结点","局部交换"],d="在不修改节点值的前提下，每两个相邻节点交换一次并返回新的链表头。",r="虚拟头结点让每一对节点前面始终有一个可操作的 prev，三次改线即可完成局部交换。",u=["交换的是节点而不是节点值","奇数长度时最后一个节点保持不动","改线顺序错误会丢失后续链表"],c=[{id:"iterative-relink",title:"迭代改线",kind:"最优",idea:"每轮保存一对节点，通过 prev、first、second 三个指针调整连接关系。",steps:["创建 dummy 指向 head","把 prev.next 改为 second，再让 first 指向 second 后继","让 second 指向 first，并把 prev 移到 first"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],f={id:24,slug:n,titleEn:e,difficulty:"中等",category:"链表",officialTags:s,paidOnly:!1,sourceUrl:t,title:i,studyTags:o,summary:d,insight:r,pitfalls:u,solutions:c};export{l as category,f as default,p as difficulty,a as id,r as insight,s as officialTags,x as paidOnly,u as pitfalls,n as slug,c as solutions,t as sourceUrl,o as studyTags,d as summary,i as title,e as titleEn};
