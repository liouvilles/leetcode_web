const c=2,n="add-two-numbers",t="Add Two Numbers",u="中等",m="链表",l=["链表","数学","递归"],y=!1,s="https://leetcode.cn/problems/add-two-numbers/",i="两数相加",e=["链表模拟加法","进位处理","虚拟头结点"],a="两个非空链表按低位到高位保存两个非负整数，逐位相加并以同样的逆序链表形式返回结果。",o="链表节点正好按个位到高位排列，可以像手算加法一样同步前进，并把进位带到下一轮。",d=["两个链表长度可能不同","最后一次进位可能产生额外节点","输入中的前导零规则不等于结果可以丢弃末尾进位"],r=[{id:"iterative-carry",title:"同步遍历与进位",kind:"最优",idea:"用两个指针逐位读取数字，当前位之和加上 carry 后生成新节点。",steps:["建立虚拟头结点保存结果","读取两个当前位置，不存在的节点按 0 处理","写入个位并更新进位，直到节点与进位全部耗尽"],complexity:{time:"O(max(m, n))",space:"O(max(m, n))"},code:{java:`class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
`,kotlin:`class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var first = l1
        var second = l2
        var carry = 0
        while (first != null || second != null || carry != 0) {
            val sum = carry + (first?.\`val\` ?: 0) + (second?.\`val\` ?: 0)
            tail.next = ListNode(sum % 10)
            tail = tail.next!!
            carry = sum / 10
            first = first?.next
            second = second?.next
        }
        return dummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode dummy;
        ListNode* tail = &dummy;
        int carry = 0;
        while (l1 || l2 || carry) {
            int sum = carry;
            if (l1) { sum += l1->val; l1 = l1->next; }
            if (l2) { sum += l2->val; l2 = l2->next; }
            tail->next = new ListNode(sum % 10);
            tail = tail->next;
            carry = sum / 10;
        }
        return dummy.next;
    }
};
`}}],N={id:2,slug:n,titleEn:t,difficulty:"中等",category:"链表",officialTags:l,paidOnly:!1,sourceUrl:s,title:i,studyTags:e,summary:a,insight:o,pitfalls:d,solutions:r};export{m as category,N as default,u as difficulty,c as id,o as insight,l as officialTags,y as paidOnly,d as pitfalls,n as slug,r as solutions,s as sourceUrl,e as studyTags,a as summary,i as title,t as titleEn};
