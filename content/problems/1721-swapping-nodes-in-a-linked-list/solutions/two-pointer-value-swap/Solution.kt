class Solution {
    fun swapNodes(head:ListNode?,k:Int):ListNode?{
        var front=head!!;
        for(i in 1 until k)front=front.next!!;
        var back=head!!;
        var runner=front;
        while(runner.next!=null){
            runner=runner.next!!;
            back=back.next!!
        };
        val value=front.`val`;
        front.`val`=back.`val`;
        back.`val`=value;
        return head
    }
}
