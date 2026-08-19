class Solution {
    public:int maxPalindromesAfterOperations(vector<string>& words){
        int frequency[26]={
        },pairs=0,answer=0;
        vector<int> lengths;
        for(auto& word:words){
            lengths.push_back(word.size());
            for(char letter:word)++frequency[letter-'a'];
        }
        for(int count:frequency)pairs+=count/2;
        sort(lengths.begin(),lengths.end());
        for(int length:lengths){
            int need=length/2;
            if(pairs<need)break;
            pairs-=need;
            ++answer;
        }
        return answer;
    }
};
