class Solution {
    private ListNode reverse(ListNode head){
        ListNode previous=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=previous;
            previous=head;
            head=next;
        }
        return previous;
    }
    public ListNode doubleIt(ListNode head){
        ListNode reversed=reverse(head),node=reversed,last=null;
        int carry=0;
        while(node!=null){
            int value=node.val*2+carry;
            node.val=value%10;
            carry=value/10;
            last=node;
            node=node.next;
        }
        if(carry>0)last.next=new ListNode(carry);
        return reverse(reversed);
    }
}
