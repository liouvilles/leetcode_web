class Solution {
    public: vector<int> findRightInterval(vector<vector<int>>& intervals){
        int n=intervals.size();
        vector<pair<int,int>> starts;
        for(int i=0;i<n;++i)starts.push_back({
            intervals[i][0],i
        });
        sort(starts.begin(),starts.end());
        vector<int> answer(n);
        for(int i=0;i<n;++i){
            auto it=lower_bound(starts.begin(),starts.end(),make_pair(intervals[i][1],INT_MIN));
            answer[i]=it==starts.end()?-1:it->second;
        }
        return answer;
    }
};
