class Solution {
    public: vector<string> getFolderNames(vector<string>& names){
        unordered_map<string,int> next;
        vector<string> answer;
        for(auto& name:names)if(!next.count(name)){
            answer.push_back(name);
            next[name]=1;
        }else{
            int k=next[name];
            string candidate=name+"("+to_string(k)+")";
            while(next.count(candidate))candidate=name+"("+to_string(++k)+")";
            answer.push_back(candidate);
            next[name]=k+1;
            next[candidate]=1;
        }
        return answer;
    }
};
