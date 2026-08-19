class Solution {
    public: int maxSatisfaction(vector<int>& satisfaction){
        sort(satisfaction.begin(),satisfaction.end());
        int suffix=0,answer=0;
        for(int i=satisfaction.size()-1;i>=0;--i){
            suffix+=satisfaction[i];
            if(suffix<=0)break;
            answer+=suffix;
        }
        return answer;
    }
};
