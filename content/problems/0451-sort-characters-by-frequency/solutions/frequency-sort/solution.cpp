class Solution {
    public: string frequencySort(string s){
        array<int,128> counts{
        };
        for(unsigned char c:s)++counts[c];
        vector<int> chars;
        for(int c=0;c<128;++c)if(counts[c])chars.push_back(c);
        sort(chars.begin(),chars.end(),[&](int a,int b){
            return counts[a]!=counts[b]?counts[a]>counts[b]:a<b;
        });
        string answer;
        for(int c:chars)answer.append(counts[c],char(c));
        return answer;
    }
};
