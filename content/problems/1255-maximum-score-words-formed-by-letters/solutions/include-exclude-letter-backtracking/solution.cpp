class Solution {
    vector<string> words;
    vector<int> score,available;
    int dfs(int index){
        if(index==(int)words.size())return 0;
        int best=dfs(index+1),wordScore=0;
        vector<int> need(26);
        bool valid=true;
        for(char ch:words[index]){
            int letter=ch-'a';
            wordScore+=score[letter];
            if(++need[letter]>available[letter])valid=false;
        }
        if(valid){
            for(int i=0;i<26;++i)available[i]-=need[i];
            best=max(best,wordScore+dfs(index+1));
            for(int i=0;i<26;++i)available[i]+=need[i];
        }
        return best;
    }
    public:int maxScoreWords(vector<string>& input,vector<char>& letters,vector<int>& values){
        words=input;
        score=values;
        available.assign(26,0);
        for(char ch:letters)++available[ch-'a'];
        return dfs(0);
    }
};
