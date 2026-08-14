const u=86,e="partition-list",t="Partition List",d="中等",c="链表",n=["链表","双指针"],m=!1,r="https://leetcode.cn/problems/partition-list/",a="分隔链表",o=["链表","双链表","稳定分区"],i="把链表按给定值 x 分区，使小于 x 的节点位于其余节点之前，同时保持两组节点的原相对顺序。",s="分别把节点追加到“小于”和“不小于”两条链表，扫描结束后连接两条链表即可保持稳定性。",f=["必须保留每组内部的原始顺序","较大链表尾部要置空以避免环","哑节点可简化空分区处理"],l=[{id:"two-stable-lists",title:"双链表稳定拼接",kind:"最优",idea:"一次扫描按条件把原节点追加到两条临时链表尾部。",steps:["创建 before/after 两个哑节点","逐节点追加到对应尾部","after 尾置空并连接两组"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0), afterDummy = new ListNode(0), before = beforeDummy, after = afterDummy;
        while (head != null) { if (head.val < x) { before.next = head; before = head; } else { after.next = head; after = head; } head = head.next; }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next;
    }
}
`,kotlin:`class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val beforeDummy = ListNode(0); val afterDummy = ListNode(0); var before = beforeDummy; var after = afterDummy; var current = head
        while (current != null) { if (current.\`val\` < x) { before.next = current; before = current } else { after.next = current; after = current }; current = current.next }
        after.next = null; before.next = afterDummy.next; return beforeDummy.next
    }
}
`,cpp:`class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode beforeDummy(0), afterDummy(0); ListNode* before = &beforeDummy; ListNode* after = &afterDummy;
        while (head) { if (head->val < x) { before->next = head; before = head; } else { after->next = head; after = head; } head = head->next; }
        after->next = nullptr; before->next = afterDummy.next; return beforeDummy.next;
    }
};
`}}],x={id:86,slug:e,titleEn:t,difficulty:"中等",category:"链表",officialTags:n,paidOnly:!1,sourceUrl:r,title:a,studyTags:o,summary:i,insight:s,pitfalls:f,solutions:l};export{c as category,x as default,d as difficulty,u as id,s as insight,n as officialTags,m as paidOnly,f as pitfalls,e as slug,l as solutions,r as sourceUrl,o as studyTags,i as summary,a as title,t as titleEn};
