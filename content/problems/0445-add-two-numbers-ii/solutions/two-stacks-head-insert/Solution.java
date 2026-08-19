class Solution {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Deque<Integer> first=new ArrayDeque<>(),second=new ArrayDeque<>();
        for(;l1!=null;l1=l1.next)first.push(l1.val);
        for(;l2!=null;l2=l2.next)second.push(l2.val);
        ListNode head=null;
        int carry=0;
        while(!first.isEmpty()||!second.isEmpty()||carry>0){
            int sum=carry+(first.isEmpty()?0:first.pop())+(second.isEmpty()?0:second.pop());
            head=new ListNode(sum%10,head);
            carry=sum/10;
        }
        return head;
    }
}
