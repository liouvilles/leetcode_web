class Solution {
    private boolean vowel(char value){
        return "aeiou".indexOf(value)>=0;
    }
    public int maxVowels(String text,int k){
        int count=0,answer=0;
        for(int right=0;right<text.length();right++){
            if(vowel(text.charAt(right)))count++;
            if(right>=k&&vowel(text.charAt(right-k)))count--;
            if(right>=k-1)answer=Math.max(answer,count);
        }
        return answer;
    }
}
