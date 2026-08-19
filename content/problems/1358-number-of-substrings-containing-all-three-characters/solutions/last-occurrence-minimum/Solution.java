class Solution {
    public int numberOfSubstrings(String text){
        int[] last={
            -1,-1,-1
        };
        int answer=0;
        for(int i=0;i<text.length();i++){
            last[text.charAt(i)-'a']=i;
            answer+=1+Math.min(last[0],Math.min(last[1],last[2]));
        }
        return answer;
    }
}
