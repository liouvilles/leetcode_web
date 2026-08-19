class Solution {
    public int maximumLengthSubstring(String s){
        int[] frequency=new int[26];
        int left=0,answer=0;
        for(int right=0;right<s.length();right++){
            int letter=s.charAt(right)-'a';
            frequency[letter]++;
            while(frequency[letter]>2)frequency[s.charAt(left++)-'a']--;
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
}
