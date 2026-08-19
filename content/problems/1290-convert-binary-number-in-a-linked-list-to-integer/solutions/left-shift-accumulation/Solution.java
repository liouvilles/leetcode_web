class Solution {
    public int getDecimalValue(ListNode head){
        int value=0;
        for(ListNode node=head;node!=null;node=node.next)value=(value<<1)|node.val;
        return value;
    }
}
