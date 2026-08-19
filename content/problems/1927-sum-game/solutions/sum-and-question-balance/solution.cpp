class Solution {
    public: bool sumGame(string num){
        int half=num.size()/2,leftSum=0,rightSum=0,leftQuestions=0,rightQuestions=0;
        for(int i=0;i<(int)num.size();++i)if(num[i]=='?')(i<half?leftQuestions:rightQuestions)++;
        else (i<half?leftSum:rightSum)+=num[i]-'0';
        if((leftQuestions+rightQuestions)%2)return true;
        return 2*(leftSum-rightSum)!=9*(rightQuestions-leftQuestions);
    }
};
