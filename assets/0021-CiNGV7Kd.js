const u=21,t="merge-two-sorted-lists",i="Merge Two Sorted Lists",c="简单",m="链表",s=["链表","递归"],x=!1,n="https://leetcode.cn/problems/merge-two-sorted-lists/",l="合并两个有序链表",e=["虚拟头结点","双指针","有序合并"],o="把两个非递减链表合并为一个非递减链表，并复用原有结点。",r="两个链表的头部较小者一定是剩余结果的下一个结点。",a=["结果头结点可能来自任意一条链表","循环结束后要接上未处理的尾部","递归深度与结点总数同阶"],d=[{id:"iterative-dummy",title:"虚拟头结点迭代",kind:"最优",idea:"虚拟头结点统一处理结果链表为空与非空的情况，尾指针持续接入较小结点。",steps:["创建 dummy 与 tail","比较两条链表头部并移动被选中的指针","接上剩余链表并返回 dummy.next"],complexity:{time:"O(m+n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
`,kotlin:`class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var first = list1
        var second = list2
        val dummy = ListNode(0)
        var tail = dummy
        while (first != null && second != null) {
            if (first.\`val\` <= second.\`val\`) {
                tail.next = first
                first = first.next
            } else {
                tail.next = second
                second = second.next
            }
            tail = tail.next!!
        }
        tail.next = first ?: second
        return dummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode dummy;
        ListNode* tail = &dummy;
        while (list1 && list2) {
            if (list1->val <= list2->val) {
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
            tail = tail->next;
        }
        tail->next = list1 ? list1 : list2;
        return dummy.next;
    }
};
`}},{id:"recursive",title:"递归合并",kind:"进阶",idea:"选出较小头结点后，问题缩小为该结点的后继与另一条链表的合并。",steps:["任一链表为空时返回另一条","选较小的头结点","递归设置它的 next 并返回"],complexity:{time:"O(m+n)",space:"O(m+n)"},code:{java:`class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
`,kotlin:`class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        return if (list1.\`val\` <= list2.\`val\`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }
}
`,cpp:`class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (!list1) return list2;
        if (!list2) return list1;
        if (list1->val <= list2->val) {
            list1->next = mergeTwoLists(list1->next, list2);
            return list1;
        }
        list2->next = mergeTwoLists(list1, list2->next);
        return list2;
    }
};
`}}],L={id:21,slug:t,titleEn:i,difficulty:"简单",category:"链表",officialTags:s,paidOnly:!1,sourceUrl:n,title:l,studyTags:e,summary:o,insight:r,pitfalls:a,solutions:d};export{m as category,L as default,c as difficulty,u as id,r as insight,s as officialTags,x as paidOnly,a as pitfalls,t as slug,d as solutions,n as sourceUrl,e as studyTags,o as summary,l as title,i as titleEn};
