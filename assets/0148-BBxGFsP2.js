const c=148,t="sort-list",e="Sort List",f="中等",u="链表",s=["链表","双指针","分治","排序","归并排序"],x=!1,n="https://leetcode.cn/problems/sort-list/",i="排序链表",o=["归并排序","快慢指针","链表合并"],l="把单链表按节点值升序排序，目标时间复杂度为 O(n log n)。",d="归并排序适合链表：快慢指针在线性时间切半，两个有序链表又能原地线性合并。",a=["切半时必须断开前半链尾","递归基线是零或一个节点","合并阶段应复用原节点"],r=[{id:"merge-sort",title:"链表归并排序",kind:"最优",idea:"递归把链表切成两半分别排序，再用双指针合并。",steps:["快慢指针定位中点前驱","断链并递归排序两半","用虚拟头结点合并两个有序链"],complexity:{time:"O(n log n)",space:"O(log n)"},code:{java:`class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = slow.next; slow.next = null;
        return merge(sortList(head), sortList(second));
    }
    private ListNode merge(ListNode first, ListNode second) { ListNode dummy = new ListNode(), tail = dummy; while (first != null && second != null) { if (first.val <= second.val) { tail.next = first; first = first.next; } else { tail.next = second; second = second.next; } tail = tail.next; } tail.next = first != null ? first : second; return dummy.next; }
}
`,kotlin:`class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head; var fast = head.next
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        val second = slow?.next; slow?.next = null
        return merge(sortList(head), sortList(second))
    }
    private fun merge(firstValue: ListNode?, secondValue: ListNode?): ListNode? { val dummy = ListNode(0); var tail = dummy; var first = firstValue; var second = secondValue; while (first != null && second != null) { if (first.\`val\` <= second.\`val\`) { tail.next = first; first = first.next } else { tail.next = second; second = second.next }; tail = tail.next!! }; tail.next = first ?: second; return dummy.next }
}
`,cpp:`class Solution {
    ListNode* merge(ListNode* first, ListNode* second) { ListNode dummy; ListNode* tail = &dummy; while (first && second) { if (first->val <= second->val) { tail->next = first; first = first->next; } else { tail->next = second; second = second->next; } tail = tail->next; } tail->next = first ? first : second; return dummy.next; }
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode* slow = head; ListNode* fast = head->next;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* second = slow->next; slow->next = nullptr;
        return merge(sortList(head), sortList(second));
    }
};
`}}],L={id:148,slug:t,titleEn:e,difficulty:"中等",category:"链表",officialTags:s,paidOnly:!1,sourceUrl:n,title:i,studyTags:o,summary:l,insight:d,pitfalls:a,solutions:r};export{u as category,L as default,f as difficulty,c as id,d as insight,s as officialTags,x as paidOnly,a as pitfalls,t as slug,r as solutions,n as sourceUrl,o as studyTags,l as summary,i as title,e as titleEn};
