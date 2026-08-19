class Solution {
    fun mergeInBetween(list1:ListNode?,a:Int,b:Int,list2:ListNode?):ListNode?{
        var before=list1!!;
        for(i in 1 until a)before=before.next!!;
        var after:ListNode?=before;
        repeat(b-a+2){
            after=after?.next
        };
        var tail=list2!!;
        while(tail.next!=null)tail=tail.next!!;
        before.next=list2;
        tail.next=after;
        return list1
    }
}
