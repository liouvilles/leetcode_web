class Solution {
    public boolean sumGame(String num){
        int half=num.length()/2,leftSum=0,rightSum=0,leftQuestions=0,rightQuestions=0;
        for(int i=0;i<num.length();i++)if(num.charAt(i)=='?'){
            if(i<half)leftQuestions++;
            else rightQuestions++;
        }else if(i<half)leftSum+=num.charAt(i)-'0';
        else rightSum+=num.charAt(i)-'0';
        if((leftQuestions+rightQuestions)%2==1)return true;
        return 2*(leftSum-rightSum)!=9*(rightQuestions-leftQuestions);
    }
}
