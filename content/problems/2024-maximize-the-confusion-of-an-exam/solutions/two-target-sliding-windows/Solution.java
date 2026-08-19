class Solution {
    private int longest(String value,int k,char changedValue){
        int left=0,changed=0,answer=0;
        for(int right=0;right<value.length();right++){
            if(value.charAt(right)==changedValue)changed++;
            while(changed>k)if(value.charAt(left++)==changedValue)changed--;
            answer=Math.max(answer,right-left+1);
        }
        return answer;
    }
    public int maxConsecutiveAnswers(String answerKey,int k){
        return Math.max(longest(answerKey,k,'T'),longest(answerKey,k,'F'));
    }
}
