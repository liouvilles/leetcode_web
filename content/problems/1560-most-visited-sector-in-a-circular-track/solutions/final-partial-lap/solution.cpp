class Solution {
    public: vector<int> mostVisited(int n,vector<int>& rounds){
        int start=rounds.front(),end=rounds.back();
        vector<int> answer;
        if(start<=end)for(int sector=start;sector<=end;++sector)answer.push_back(sector);
        else{
            for(int sector=1;sector<=end;++sector)answer.push_back(sector);
            for(int sector=start;sector<=n;++sector)answer.push_back(sector);
        }
        return answer;
    }
};
