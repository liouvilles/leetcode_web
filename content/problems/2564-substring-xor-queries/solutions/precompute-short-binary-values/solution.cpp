class Solution {
    public:vector<vector<int>> substringXorQueries(string s,vector<vector<int>>& queries){
        unordered_map<int,vector<int>> positions;
        for(int start=0;start<(int)s.size();++start){
            if(s[start]=='0'){
                if(!positions.count(0))positions[0]={
                    start,start
                };
                continue;
            }
            int value=0;
            for(int end=start;end<(int)s.size()&&end<start+30;++end){
                value=(value<<1)+(s[end]-'0');
                if(!positions.count(value))positions[value]={
                    start,end
                };
            }
        }
        vector<vector<int>> answer;
        for(auto& query:queries){
            int target=query[0]^query[1];
            answer.push_back(positions.count(target)?positions[target]:vector<int>{
                -1,-1
            });
        }
        return answer;
    }
};
