class Solution {
    public int characterReplacement(String s,int k){
        int[] counts=new int[26];
        int left=0,maxFrequency=0,answer=0;
        for(int right=0;right<s.length();right++){
            maxFrequency=Math.max(maxFrequency,++counts[s.charAt(right)-'A']);
            while(right-left+1-maxFrequency>k)counts[s.charAt(left++)-'A']--;
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
