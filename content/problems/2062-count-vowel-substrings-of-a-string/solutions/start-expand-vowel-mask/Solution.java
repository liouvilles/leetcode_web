class Solution {
    private int bit(char value){
        return value=='a'?1:value=='e'?2:value=='i'?4:value=='o'?8:value=='u'?16:0;
    }
    public int countVowelSubstrings(String word){
        int answer=0;
        for(int left=0;left<word.length();left++){
            int mask=0;
            for(int right=left;right<word.length();right++){
                int value=bit(word.charAt(right));
                if(value==0)break;
                mask|=value;
                if(mask==31)answer++;
            }
        }
        return answer;
    }
}
