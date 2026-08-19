class Solution {
    public ListNode swapNodes(ListNode head,int k){
        ListNode front=head;
        for(int i=1;i<k;i++)front=front.next;
        ListNode back=head,runner=front;
        while(runner.next!=null){
            runner=runner.next;
            back=back.next;
        }
        int value=front.val;
        front.val=back.val;
        back.val=value;
        return head;
    }
}
