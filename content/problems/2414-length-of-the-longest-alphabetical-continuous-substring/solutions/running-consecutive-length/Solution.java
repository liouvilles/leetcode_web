class Solution {
    public int longestContinuousSubstring(String s){
        int current=1,answer=1;
        for(int i=1;i<s.length();i++){
            current=s.charAt(i)==s.charAt(i-1)+1?current+1:1;
            answer=Math.max(answer,current);
        }
        return answer;
    }
}
