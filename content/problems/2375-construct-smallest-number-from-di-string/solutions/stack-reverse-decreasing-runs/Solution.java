class Solution {
    public String smallestNumber(String pattern){
        StringBuilder answer=new StringBuilder();
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<=pattern.length();i++){
            stack.push(i+1);
            if(i==pattern.length()||pattern.charAt(i)=='I')while(!stack.isEmpty())answer.append(stack.pop());
        }
        return answer.toString();
    }
}
