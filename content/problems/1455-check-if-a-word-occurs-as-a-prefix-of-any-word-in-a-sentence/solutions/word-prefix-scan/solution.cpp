class Solution {
    public: int isPrefixOfWord(string sentence,string searchWord){
        stringstream stream(sentence);
        string word;
        int index=1;
        while(stream>>word){
            if(word.rfind(searchWord,0)==0)return index;
            ++index;
        }
        return -1;
    }
};
