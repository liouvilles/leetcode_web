class Solution {
    public: string reversePrefix(string word,char ch){
        auto iterator=find(word.begin(),word.end(),ch);
        if(iterator!=word.end())reverse(word.begin(),iterator+1);
        return word;
    }
};
