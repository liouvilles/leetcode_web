const h=876,n="middle-of-the-linked-list",e="Middle of the Linked List",f="简单",u="链表",t=["链表","双指针"],r=!1,o="https://leetcode.cn/problems/middle-of-the-linked-list/",d="链表的中间结点",s=["快慢指针","二次遍历","偶数中点"],l="返回链表的中间结点；若结点数为偶数，返回两个中间结点中的后一个。",i="快指针走过两个结点的时间里慢指针走一个，快指针到终点时慢指针恰好在中间。",a=["偶数长度要求返回后一个中点","链表非空但仍应保持空值安全","快指针循环条件决定中点口径"],c=[{id:"count-then-walk",title:"计数后二次遍历",kind:"基础",idea:"先统计结点总数 n，再从头结点移动 floor(n/2) 步。",steps:["第一次遍历计算长度","重置指针到头部","移动 length / 2 次"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) length++;
        for (int i = 0; i < length / 2; i++) head = head.next;
        return head;
    }
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        int length = 0;
        for (ListNode* node = head; node; node = node->next) ++length;
        for (int i = 0; i < length / 2; ++i) head = head->next;
        return head;
    }
};
`}},{id:"fast-slow",title:"快慢指针",kind:"最优",idea:"单次遍历中让快指针速度为慢指针的两倍。",steps:["两个指针从头部出发","fast 可走两步时同时推进","循环结束返回 slow"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
`,kotlin:`class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}
`,cpp:`class Solution {
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
};
`}}],N={id:876,slug:n,titleEn:e,difficulty:"简单",category:"链表",officialTags:t,paidOnly:!1,sourceUrl:o,title:d,studyTags:s,summary:l,insight:i,pitfalls:a,solutions:c};export{u as category,N as default,f as difficulty,h as id,i as insight,t as officialTags,r as paidOnly,a as pitfalls,n as slug,c as solutions,o as sourceUrl,s as studyTags,l as summary,d as title,e as titleEn};
