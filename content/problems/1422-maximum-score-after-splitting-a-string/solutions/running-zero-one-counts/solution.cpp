class Solution {
    public: int maxScore(string text){
        int rightOnes=count(text.begin(),text.end(),'1'),leftZeros=0,answer=0;
        for(int i=0;i<(int)text.size()-1;++i){
            text[i]=='0'?++leftZeros:--rightOnes;
            answer=max(answer,leftZeros+rightOnes);
        }
        return answer;
    }
};
