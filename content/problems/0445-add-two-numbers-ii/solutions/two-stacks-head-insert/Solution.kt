class Solution {
    fun addTwoNumbers(firstNode:ListNode?,secondNode:ListNode?):ListNode?{
        val first=ArrayDeque<Int>();
        val second=ArrayDeque<Int>();
        var l1=firstNode;
        var l2=secondNode;
        while(l1!=null){
            first.addLast(l1.`val`);
            l1=l1.next
        };
        while(l2!=null){
            second.addLast(l2.`val`);
            l2=l2.next
        };
        var head:ListNode?=null;
        var carry=0;
        while(first.isNotEmpty()||second.isNotEmpty()||carry>0){
            val sum=carry+(if(first.isEmpty())0 else first.removeLast())+(if(second.isEmpty())0 else second.removeLast());
            val node=ListNode(sum%10);
            node.next=head;
            head=node;
            carry=sum/10
        };
        return head
    }
}
