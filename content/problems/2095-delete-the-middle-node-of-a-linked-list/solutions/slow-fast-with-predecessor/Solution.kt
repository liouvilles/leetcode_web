class Solution {
    fun deleteMiddle(head:ListNode?):ListNode?{
        if(head!!.next==null)return null;
        var slow:ListNode?=head;
        var fast:ListNode?=head;
        var previous:ListNode?=null;
        while(fast!=null&&fast.next!=null){
            previous=slow;
            slow=slow!!.next;
            fast=fast.next!!.next
        };
        previous!!.next=slow!!.next;
        return head
    }
}
