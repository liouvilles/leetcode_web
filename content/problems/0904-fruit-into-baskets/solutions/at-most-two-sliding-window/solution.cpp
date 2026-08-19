class Solution {
    public: int totalFruit(vector<int>& fruits){
        unordered_map<int,int> frequency;
        int left=0,answer=0;
        for(int right=0;right<(int)fruits.size();++right){
            ++frequency[fruits[right]];
            while(frequency.size()>2){
                int value=fruits[left++];
                if(--frequency[value]==0)frequency.erase(value);
            }
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
