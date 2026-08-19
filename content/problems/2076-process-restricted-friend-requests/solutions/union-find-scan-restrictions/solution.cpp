class Solution {
    vector<int> parent;
    int find(int value){
        return value==parent[value]?value:parent[value]=find(parent[value]);
    }
    public: vector<bool> friendRequests(int n,vector<vector<int>>& restrictions,vector<vector<int>>& requests){
        parent.resize(n);
        iota(parent.begin(),parent.end(),0);
        vector<bool> answer;
        for(auto& request:requests){
            int first=find(request[0]),second=find(request[1]);
            bool valid=true;
            for(auto& restriction:restrictions){
                int a=find(restriction[0]),b=find(restriction[1]);
                if((a==first&&b==second)||(a==second&&b==first)){
                    valid=false;
                    break;
                }
            }
            answer.push_back(valid);
            if(valid)parent[first]=second;
        }
        return answer;
    }
};
