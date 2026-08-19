class Solution {
    public: int numMatchingSubseq(string s,vector<string>& words){
        vector<queue<pair<int,int>>> buckets(26);
        for(int i=0;i<(int)words.size();++i)buckets[words[i][0]-'a'].push({
            i,0
        });
        int answer=0;
        for(char c:s){
            auto& pending=buckets[c-'a'];
            int size=pending.size();
            while(size--){
                auto [word,position]=pending.front();
                pending.pop();
                ++position;
                if(position==(int)words[word].size())++answer;
                else buckets[words[word][position]-'a'].push({
                    word,position
                });
            }
        }
        return answer;
    }
};
