class Solution {
    public int[] diStringMatch(String s){
        int[] answer=new int[s.length()+1];
        int low=0,high=s.length();
        for(int i=0;i<s.length();i++)answer[i]=s.charAt(i)=='I'?low++:high--;
        answer[s.length()]=low;
        return answer;
    }
}
