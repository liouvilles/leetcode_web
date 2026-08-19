class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int next=a%b;
            a=b;
            b=next;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head){
        ListNode node=head;
        while(node.next!=null){
            ListNode next=node.next;
            node.next=new ListNode(gcd(node.val,next.val),next);
            node=next;
        }
        return head;
    }
}
