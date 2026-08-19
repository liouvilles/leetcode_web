class Solution {
    public String removeStars(String s){
        StringBuilder answer=new StringBuilder();
        for(char ch:s.toCharArray())if(ch=='*')answer.setLength(answer.length()-1);
        else answer.append(ch);
        return answer.toString();
    }
}
