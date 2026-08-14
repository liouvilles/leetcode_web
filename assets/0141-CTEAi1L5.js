const u=141,n="linked-list-cycle",e="Linked List Cycle",f="简单",r="链表",t=["哈希表","链表","双指针","Floyd's Cycle Finding Algorithm"],h=!1,s="https://leetcode.cn/problems/linked-list-cycle/",l="环形链表",a=["快慢指针","Floyd 判圈","访问状态"],o="判断单链表沿 next 指针前进时是否会进入一个环。",i="如果存在环，快指针进入环后会不断缩小与慢指针的环上距离，最终相遇。",d=["检查 fast 与 fast.next 后才能走两步","比较的是结点身份而非结点值","空链表与单结点无环都要返回 false"],c=[{id:"visited-set",title:"记录访问结点",kind:"基础",idea:"把每个访问过的结点引用存入集合，再次遇到同一引用即可确认有环。",steps:["从头结点开始遍历","当前结点已在集合中则返回 true","记录结点并继续，走到 null 则无环"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (!visited.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
`,kotlin:`class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val visited = HashSet<ListNode>()
        var node = head
        while (node != null) {
            if (!visited.add(node)) return true
            node = node.next
        }
        return false
    }
}
`,cpp:`class Solution {
public:
    bool hasCycle(ListNode* head) {
        unordered_set<ListNode*> visited;
        while (head) {
            if (!visited.insert(head).second) return true;
            head = head->next;
        }
        return false;
    }
};
`}},{id:"floyd",title:"Floyd 快慢指针",kind:"最优",idea:"慢指针每次一步、快指针每次两步；有环时二者必然相遇。",steps:["slow 与 fast 都从头部出发","确认快指针可走两步后推进","相遇则有环，快指针到 null 则无环"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],y={id:141,slug:n,titleEn:e,difficulty:"简单",category:"链表",officialTags:t,paidOnly:!1,sourceUrl:s,title:l,studyTags:a,summary:o,insight:i,pitfalls:d,solutions:c};export{r as category,y as default,f as difficulty,u as id,i as insight,t as officialTags,h as paidOnly,d as pitfalls,n as slug,c as solutions,s as sourceUrl,a as studyTags,o as summary,l as title,e as titleEn};
