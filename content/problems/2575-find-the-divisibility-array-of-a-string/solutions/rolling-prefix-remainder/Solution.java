class Solution {
    public int[] divisibilityArray(String word,int m){
        int[] answer=new int[word.length()];
        long remainder=0;
        for(int i=0;i<word.length();i++){
            remainder=(remainder*10+word.charAt(i)-'0')%m;
            if(remainder==0)answer[i]=1;
        }
        return answer;
    }
}
