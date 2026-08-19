class Solution {
    vector<int> parent;
    int find(int value){
        return parent[value]==value?value:parent[value]=find(parent[value]);
    }
    void unite(int a,int b){
        parent[find(a)]=find(b);
    }
    public:vector<vector<string>> accountsMerge(vector<vector<string>>& accounts){
        parent.resize(accounts.size());
        iota(parent.begin(),parent.end(),0);
        unordered_map<string,int> owner;
        unordered_map<string,string> names;
        for(int i=0;i<(int)accounts.size();++i)for(int j=1;j<(int)accounts[i].size();++j){
            string email=accounts[i][j];
            names[email]=accounts[i][0];
            if(owner.count(email))unite(i,owner[email]);
            else owner[email]=i;
        }
        unordered_map<int,vector<string>> groups;
        for(auto& [email,index]:owner)groups[find(index)].push_back(email);
        vector<vector<string>> answer;
        for(auto& [root,emails]:groups){
            sort(emails.begin(),emails.end());
            vector<string> row{
                names[emails[0]]
            };
            row.insert(row.end(),emails.begin(),emails.end());
            answer.push_back(row);
        }
        sort(answer.begin(),answer.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        return answer;
    }
};
