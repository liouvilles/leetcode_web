class Solution {
    public:int closetTarget(vector<string>& words,string target,int startIndex){
        int answer=words.size()+1;
        for(int i=0;i<(int)words.size();++i)if(words[i]==target){
            int difference=abs(i-startIndex);
            answer=min({
                answer,difference,(int)words.size()-difference
            });
        }
        return answer>(int)words.size()?-1:answer;
    }
};
