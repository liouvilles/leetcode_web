class Solution {
    public String finalString(String s){
        Deque<Character> deque=new ArrayDeque<>();
        boolean reversed=false;
        for(char ch:s.toCharArray())if(ch=='i')reversed=!reversed;
        else if(reversed)deque.addFirst(ch);
        else deque.addLast(ch);
        StringBuilder answer=new StringBuilder();
        Iterator<Character> iterator=reversed?deque.descendingIterator():deque.iterator();
        while(iterator.hasNext())answer.append(iterator.next());
        return answer.toString();
    }
}
