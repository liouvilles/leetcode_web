class Solution {
    private fun reverse(input:ListNode?):ListNode?{
        var head=input;
        var previous:ListNode?=null;
        while(head!=null){
            val next=head.next;
            head.next=previous;
            previous=head;
            head=next
        };
        return previous
    };
    fun doubleIt(head:ListNode?):ListNode?{
        val reversed=reverse(head);
        var node=reversed;
        var last:ListNode?=null;
        var carry=0;
        while(node!=null){
            val value=node.`val`*2+carry;
            node.`val`=value%10;
            carry=value/10;
            last=node;
            node=node.next
        };
        if(carry>0)last!!.next=ListNode(carry);
        return reverse(reversed)
    }
}
