class Solution {
    fun getDecimalValue(head:ListNode?):Int{
        var value=0;
        var node=head;
        while(node!=null){
            value=(value shl 1) or node.`val`;
            node=node.next
        };
        return value
    }
}
