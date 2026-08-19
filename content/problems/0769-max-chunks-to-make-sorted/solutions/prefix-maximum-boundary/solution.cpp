class Solution {
    public: int maxChunksToSorted(vector<int>& arr){
        int answer=0,maximum=0;
        for(int i=0;i<(int)arr.size();++i){
            maximum=max(maximum,arr[i]);
            if(maximum==i)++answer;
        }
        return answer;
    }
};
