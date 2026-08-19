class Solution {
    public: int maxLengthBetweenEqualCharacters(string text){
        vector<int> first(26,-1);
        int answer=-1;
        for(int i=0;i<(int)text.size();++i){
            int letter=text[i]-'a';
            if(first[letter]<0)first[letter]=i;
            else answer=max(answer,i-first[letter]-1);
        }
        return answer;
    }
};
