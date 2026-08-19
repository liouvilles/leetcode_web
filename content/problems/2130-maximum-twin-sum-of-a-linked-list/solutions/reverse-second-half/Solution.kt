class Solution {
    fun pairSum(head:ListNode?):Int{
        var slow=head;
        var fast=head;
        while(fast!=null){
            slow=slow!!.next;
            fast=fast.next!!.next
        };
        var reversed:ListNode?=null;
        while(slow!=null){
            val next=slow.next;
            slow.next=reversed;
            reversed=slow;
            slow=next
        };
        var first=head;
        var second=reversed;
        var answer=0;
        while(second!=null){
            answer=maxOf(answer,first!!.`val`+second.`val`);
            first=first.next;
            second=second.next
        };
        return answer
    }
}
