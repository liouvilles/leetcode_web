class Solution {
    fun reverseEvenLengthGroups(head:ListNode?):ListNode?{
        val dummy=ListNode(0);
        dummy.next=head;
        var previous=dummy;
        var start=head;
        var group=1;
        while(start!=null){
            var cursor:ListNode?=start;
            var actual=0;
            while(cursor!=null&&actual<group){
                cursor=cursor.next;
                actual++
            };
            if(actual%2==0){
                var node:ListNode?=start;
                var reversed=cursor;
                while(node!==cursor){
                    val next=node!!.next;
                    node.next=reversed;
                    reversed=node;
                    node=next
                };
                previous.next=reversed;
                previous=start
            }else repeat(actual){
                previous=previous.next!!
            };
            start=cursor;
            group++
        };
        return dummy.next
    }
}
