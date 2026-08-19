class Solution {
    public: int numEquivDominoPairs(vector<vector<int>>& dominoes){
        int frequency[100]={
        },answer=0;
        for(auto& domino:dominoes){
            int key=10*min(domino[0],domino[1])+max(domino[0],domino[1]);
            answer+=frequency[key]++;
        }
        return answer;
    }
};
