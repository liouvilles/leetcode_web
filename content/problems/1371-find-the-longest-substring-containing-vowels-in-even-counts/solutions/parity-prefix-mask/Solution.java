class Solution {
    public int findTheLongestSubstring(String text){
        int[] earliest=new int[32];
        Arrays.fill(earliest,-2);
        earliest[0]=-1;
        int mask=0,answer=0;
        for(int i=0;i<text.length();i++){
            int vowel="aeiou".indexOf(text.charAt(i));
            if(vowel>=0)mask^=1<<vowel;
            if(earliest[mask]!=-2)answer=Math.max(answer,i-earliest[mask]);
            else earliest[mask]=i;
        }
        return answer;
    }
}
