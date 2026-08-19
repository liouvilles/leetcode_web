class Solution {
    public: vector<int> findNumOfValidWords(vector<string>& words,vector<string>& puzzles){
        unordered_map<int,int> frequency;
        for(string& word:words){
            int mask=0;
            for(char ch:word)mask|=1<<(ch-'a');
            if(__builtin_popcount(mask)<=7)++frequency[mask];
        }
        vector<int> answer;
        for(string& puzzle:puzzles){
            int first=1<<(puzzle[0]-'a'),rest=0;
            for(int i=1;i<(int)puzzle.size();++i)rest|=1<<(puzzle[i]-'a');
            int count=0,subset=rest;
            while(true){
                count+=frequency[subset|first];
                if(!subset)break;
                subset=(subset-1)&rest;
            }
            answer.push_back(count);
        }
        return answer;
    }
};
