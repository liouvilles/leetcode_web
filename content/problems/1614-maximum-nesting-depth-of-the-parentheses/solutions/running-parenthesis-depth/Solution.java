class Solution {
    public int maxDepth(String text){
        int depth=0,answer=0;
        for(char value:text.toCharArray())if(value=='(')answer=Math.max(answer,++depth);
        else if(value==')')depth--;
        return answer;
    }
}
