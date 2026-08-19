class Solution {
    fun removeZeroSumSublists(head:ListNode?):ListNode?{
        val dummy=ListNode(0);
        dummy.next=head;
        val last=mutableMapOf<Int,ListNode>();
        var prefix=0;
        var node:ListNode?=dummy;
        while(node!=null){
            prefix+=node.`val`;
            last[prefix]=node;
            node=node.next
        };
        prefix=0;
        node=dummy;
        while(node!=null){
            prefix+=node.`val`;
            node.next=last[prefix]!!.next;
            node=node.next
        };
        return dummy.next
    }
}
