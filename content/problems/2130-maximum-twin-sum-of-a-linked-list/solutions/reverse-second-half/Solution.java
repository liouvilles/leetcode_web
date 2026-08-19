class Solution {
    public int pairSum(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversed=null;
        while(slow!=null){
            ListNode next=slow.next;
            slow.next=reversed;
            reversed=slow;
            slow=next;
        }
        int answer=0;
        for(ListNode first=head,second=reversed;second!=null;first=first.next,second=second.next)answer=Math.max(answer,first.val+second.val);
        return answer;
    }
}
