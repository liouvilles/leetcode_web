class Solution {
    public:long long countPrefixSuffixPairs(vector<string>& words){
        int total=0;
        for(const string& word:words)total+=word.size();
        unordered_map<long long,int> edges;
        edges.reserve(total*2);
        vector<int> terminal(total+1);
        int nodes=1;
        long long answer=0;
        for(const string& word:words){
            int node=0,length=word.size();
            for(int index=0;index<length;++index){
                int pair=(word[index]-'a')*26+word[length-1-index]-'a';
                long long key=((long long)node<<10)|pair;
                auto found=edges.find(key);
                if(found==edges.end()){
                    node=nodes++;
                    edges.emplace(key,node);
                }else node=found->second;
                answer+=terminal[node];
            }
            ++terminal[node];
        }
        return answer;
    }
};
