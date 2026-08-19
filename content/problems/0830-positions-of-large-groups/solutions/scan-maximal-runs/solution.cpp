class Solution {
    public: vector<vector<int>> largeGroupPositions(string s){
        vector<vector<int>> answer;
        for(int start=0;start<(int)s.size();){
            int end=start+1;
            while(end<(int)s.size()&&s[end]==s[start])++end;
            if(end-start>=3)answer.push_back({
                start,end-1
            });
            start=end;
        }
        return answer;
    }
};
