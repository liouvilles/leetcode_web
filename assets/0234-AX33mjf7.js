const u=234,e="palindrome-linked-list",n="Palindrome Linked List",c="简单",f="链表",s=["链表","双指针","栈","递归"],v=!1,t="https://leetcode.cn/problems/palindrome-linked-list/",o="回文链表",i=["快慢指针","链表反转","双端比较"],l="判断单链表中的节点值从前向后和从后向前读取是否相同，并使用常数额外空间。",d="快慢指针定位后半部分起点，原地反转后即可与前半部分同步比较。",r=["奇数长度时中间节点无需配对","比较次数由反转后的后半链长度决定","反转会暂时修改链表结构"],a=[{id:"reverse-second-half",title:"反转后半链表",kind:"最优",idea:"定位中点、反转后半段，再从链表两端向中间比较。",steps:["快指针走两步、慢指针走一步","反转 slow 所在的后半链","从 head 和反转头同步比较"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        ListNode second = reverse(slow), first = head;
        while (second != null) { if (first.val != second.val) return false; first = first.next; second = second.next; }
        return true;
    }
    private ListNode reverse(ListNode node) { ListNode previous = null; while (node != null) { ListNode next = node.next; node.next = previous; previous = node; node = next; } return previous; }
}
`,kotlin:`class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head; var fast = head
        while (fast != null && fast.next != null) { slow = slow?.next; fast = fast.next?.next }
        var first = head; var second = reverse(slow)
        while (second != null) { if (first?.\`val\` != second.\`val\`) return false; first = first?.next; second = second.next }
        return true
    }
    private fun reverse(start: ListNode?): ListNode? { var node = start; var previous: ListNode? = null; while (node != null) { val next = node.next; node.next = previous; previous = node; node = next }; return previous }
}
`,cpp:`class Solution {
    ListNode* reverse(ListNode* node) { ListNode* previous = nullptr; while (node) { ListNode* next = node->next; node->next = previous; previous = node; node = next; } return previous; }
public:
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head; ListNode* fast = head;
        while (fast && fast->next) { slow = slow->next; fast = fast->next->next; }
        ListNode* first = head; ListNode* second = reverse(slow);
        while (second) { if (first->val != second->val) return false; first = first->next; second = second->next; }
        return true;
    }
};
`}}],x={id:234,slug:e,titleEn:n,difficulty:"简单",category:"链表",officialTags:s,paidOnly:!1,sourceUrl:t,title:o,studyTags:i,summary:l,insight:d,pitfalls:r,solutions:a};export{f as category,x as default,c as difficulty,u as id,d as insight,s as officialTags,v as paidOnly,r as pitfalls,e as slug,a as solutions,t as sourceUrl,i as studyTags,l as summary,o as title,n as titleEn};
