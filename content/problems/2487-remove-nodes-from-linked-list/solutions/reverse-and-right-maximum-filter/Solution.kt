class Solution {
    private fun reverse(headInput:ListNode?):ListNode?{
        var head=headInput;
        var previous:ListNode?=null;
        while(head!=null){
            val next=head.next;
            head.next=previous;
            previous=head;
            head=next
        };
        return previous
    }
    fun removeNodes(head:ListNode?):ListNode?{
        var node=reverse(head);
        var answer:ListNode?=null;
        var maximum=Int.MIN_VALUE;
        while(node!=null){
            val next=node.next;
            if(node.`val`>=maximum){
                maximum=node.`val`;
                node.next=answer;
                answer=node
            };
            node=next
        };
        return answer
    }
}
