const f=19,n="remove-nth-node-from-end-of-list",t="Remove Nth Node From End of List",u="中等",c="链表",s=["链表","双指针"],r=!1,e="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/",o="删除链表的倒数第 N 个结点",d=["快慢指针","固定间距","虚拟头结点"],i="删除单链表中从末尾数第 n 个节点，并返回删除后的链表头节点。",l="让快指针先领先 n 步，再与慢指针同步移动，就能让慢指针停在待删除节点的前一个位置。",a=["删除头节点时需要统一处理","快慢指针的初始间距要从虚拟头结点计算","n 在有效范围内但链表可能只有一个节点"],m=[{id:"fast-slow-pointers",title:"固定间距双指针",kind:"最优",idea:"虚拟头结点消除删除头节点的特判，两个指针保持 n 个节点的间距。",steps:["创建 dummy 并连接原链表","fast 先向前走 n 步","同步移动到 fast 位于尾节点，再删除 slow 的下一个节点"],complexity:{time:"O(L)",space:"O(1)"},code:{java:`class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        for (int step = 0; step < n; step++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
`,kotlin:`class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy
        repeat(n) { fast = fast?.next }
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        slow?.next = slow?.next?.next
        return dummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy(0, head);
        ListNode* fast = &dummy;
        ListNode* slow = &dummy;
        for (int step = 0; step < n; ++step) fast = fast->next;
        while (fast->next) {
            fast = fast->next;
            slow = slow->next;
        }
        slow->next = slow->next->next;
        return dummy.next;
    }
};
`}}],x={id:19,slug:n,titleEn:t,difficulty:"中等",category:"链表",officialTags:s,paidOnly:!1,sourceUrl:e,title:o,studyTags:d,summary:i,insight:l,pitfalls:a,solutions:m};export{c as category,x as default,u as difficulty,f as id,l as insight,s as officialTags,r as paidOnly,a as pitfalls,n as slug,m as solutions,e as sourceUrl,d as studyTags,i as summary,o as title,t as titleEn};
