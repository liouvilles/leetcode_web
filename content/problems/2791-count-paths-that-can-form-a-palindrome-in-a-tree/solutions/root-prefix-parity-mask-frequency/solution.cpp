class Solution {
    public:long long countPalindromePaths(vector<int>& parent,string s){
        vector<int> mask(parent.size());
        unordered_map<int,int> frequency;
        long long answer=0;
        for(int node=0;node<(int)parent.size();++node){
            if(node)mask[node]=mask[parent[node]]^(1<<(s[node]-'a'));
            answer+=frequency[mask[node]];
            for(int bit=0;bit<26;++bit)answer+=frequency[mask[node]^(1<<bit)];
            ++frequency[mask[node]];
        }
        return answer;
    }
};
