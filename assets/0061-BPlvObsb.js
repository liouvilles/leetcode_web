const r=61,t="rotate-list",n="Rotate List",c="中等",u="链表",e=["链表","双指针"],w=!1,l="https://leetcode.cn/problems/rotate-list/",i="旋转链表",a=["链表成环","长度取模","断环"],s="把单链表向右旋转 k 次，使末尾 k 个节点移动到链表开头。",o="先首尾相连形成环；旋转后新尾位于原头之后 n-k%n-1 步，断开其后继即可。",d=["空链表直接返回","k 可能远大于链表长度","断环前要保存新头节点"],h=[{id:"circular-list",title:"成环后定位断点",kind:"最优",idea:"计算长度并连成环，通过取模后的步数找到新尾。",steps:["遍历得到长度和原尾","原尾连接原头","走 n-k%n-1 步到新尾并断环"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1; ListNode tail = head; while (tail.next != null) { tail = tail.next; length++; }
        tail.next = head; int steps = length - k % length - 1; ListNode newTail = head; while (steps-- > 0) newTail = newTail.next;
        ListNode answer = newTail.next; newTail.next = null; return answer;
    }
}
`,kotlin:`class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) return head
        var length = 1; var tail = head; while (tail!!.next != null) { tail = tail.next; length++ }
        tail!!.next = head; var steps = length - k % length - 1; var newTail = head; while (steps-- > 0) newTail = newTail!!.next
        val answer = newTail!!.next; newTail.next = null; return answer
    }
}
`,cpp:`class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || !head->next || k == 0) return head;
        int length = 1; ListNode* tail = head; while (tail->next) { tail = tail->next; ++length; }
        tail->next = head; int steps = length - k % length - 1; ListNode* newTail = head; while (steps-- > 0) newTail = newTail->next;
        ListNode* answer = newTail->next; newTail->next = nullptr; return answer;
    }
};
`}}],x={id:61,slug:t,titleEn:n,difficulty:"中等",category:"链表",officialTags:e,paidOnly:!1,sourceUrl:l,title:i,studyTags:a,summary:s,insight:o,pitfalls:d,solutions:h};export{u as category,x as default,c as difficulty,r as id,o as insight,e as officialTags,w as paidOnly,d as pitfalls,t as slug,h as solutions,l as sourceUrl,a as studyTags,s as summary,i as title,n as titleEn};
