class Solution {
public:
    vector<string> shortestSubstrings(vector<string>& arr){
        vector<array<int,26>> next(1);
        next[0].fill(-1);
        vector<int> owners(1),lastOwner(1,-1);
        for(int owner=0;owner<(int)arr.size();++owner)for(int start=0;start<(int)arr[owner].size();++start){
            int node=0;
            for(int end=start;end<(int)arr[owner].size();++end){
                int letter=arr[owner][end]-'a';
                if(next[node][letter]==-1){
                    next[node][letter]=next.size();
                    next.push_back({});next.back().fill(-1);
                    owners.push_back(0);lastOwner.push_back(-1);
                }
                node=next[node][letter];
                if(lastOwner[node]!=owner){lastOwner[node]=owner;++owners[node];}
            }
        }
        vector<string> answer(arr.size());
        for(int owner=0;owner<(int)arr.size();++owner)for(int start=0;start<(int)arr[owner].size();++start){
            int node=0;
            for(int end=start;end<(int)arr[owner].size();++end){
                node=next[node][arr[owner][end]-'a'];
                if(owners[node]==1){
                    string candidate=arr[owner].substr(start,end-start+1);
                    if(answer[owner].empty()||candidate.size()<answer[owner].size()||(candidate.size()==answer[owner].size()&&candidate<answer[owner]))answer[owner]=candidate;
                }
            }
        }
        return answer;
    }
};
