class Solution {
    public int takeCharacters(String s,int k){
        int[] total=new int[3];
        for(char character:s.toCharArray())total[character-'a']++;
        for(int count:total)if(count<k)return -1;
        int[] window=new int[3];
        int left=0,maximum=0;
        for(int right=0;right<s.length();right++){
            int index=s.charAt(right)-'a';
            window[index]++;
            while(window[index]>total[index]-k)window[s.charAt(left++)-'a']--;
            maximum=Math.max(maximum,right-left+1);
        }
        return s.length()-maximum;
    }
}
