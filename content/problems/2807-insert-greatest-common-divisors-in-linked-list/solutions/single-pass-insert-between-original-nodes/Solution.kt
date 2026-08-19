class Solution {
    private fun gcd(aInput:Int,bInput:Int):Int{
        var a=aInput;
        var b=bInput;
        while(b!=0){
            val next=a%b;
            a=b;
            b=next
        };
        return a
    };
    fun insertGreatestCommonDivisors(head:ListNode?):ListNode?{
        var node=head;
        while(node?.next!=null){
            val next=node.next!!;
            val inserted=ListNode(gcd(node.`val`,next.`val`));
            inserted.next=next;
            node.next=inserted;
            node=next
        };
        return head
    }
}
