class Solution {
    fun finalString(s:String):String{
        val deque=java.util.ArrayDeque<Char>();
        var reversed=false;
        for(ch in s)if(ch=='i')reversed=!reversed else if(reversed)deque.addFirst(ch) else deque.addLast(ch);
        val answer=StringBuilder();
        while(!deque.isEmpty())answer.append(if(reversed)deque.pollLast() else deque.pollFirst());
        return answer.toString()
    }
}
