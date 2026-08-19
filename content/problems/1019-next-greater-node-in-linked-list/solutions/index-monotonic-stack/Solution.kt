class Solution {
    fun nextLargerNodes(head:ListNode?):IntArray{
        val values=mutableListOf<Int>();
        var node=head;
        while(node!=null){
            values.add(node.`val`);
            node=node.next
        };
        val answer=IntArray(values.size);
        val stack=java.util.ArrayDeque<Int>();
        for(i in values.indices){
            while(stack.isNotEmpty()&&values[stack.peek()]<values[i])answer[stack.pop()]=values[i];
            stack.push(i)
        };
        return answer
    }
}
