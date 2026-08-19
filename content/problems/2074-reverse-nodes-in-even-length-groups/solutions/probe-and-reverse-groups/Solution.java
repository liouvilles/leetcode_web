class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head){
        ListNode dummy=new ListNode(0,head),previous=dummy,start=head;
        for(int group=1;start!=null;group++){
            ListNode cursor=start;
            int actual=0;
            while(cursor!=null&&actual<group){
                cursor=cursor.next;
                actual++;
            }
            if(actual%2==0){
                ListNode node=start,reversed=cursor;
                while(node!=cursor){
                    ListNode next=node.next;
                    node.next=reversed;
                    reversed=node;
                    node=next;
                }
                previous.next=reversed;
                previous=start;
            }else{
                for(int i=0;i<actual;i++)previous=previous.next;
            }
            start=cursor;
        }
        return dummy.next;
    }
}
