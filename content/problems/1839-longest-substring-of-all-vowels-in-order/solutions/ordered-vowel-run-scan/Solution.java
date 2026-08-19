class Solution {
    public int longestBeautifulSubstring(String word){
        int start=0,distinct=1,answer=0;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)<word.charAt(i-1)){
                start=i;
                distinct=1;
            }else if(word.charAt(i)>word.charAt(i-1))distinct++;
            if(distinct==5)answer=Math.max(answer,i-start+1);
        }
        return answer;
    }
}
