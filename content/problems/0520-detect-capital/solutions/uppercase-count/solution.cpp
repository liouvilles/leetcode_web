class Solution {
    public: bool detectCapitalUse(string word){
        int uppercase=0;
        for(char c:word)uppercase+=isupper(c)!=0;
        return uppercase==0||uppercase==(int)word.size()||(uppercase==1&&isupper(word[0]));
    }
};
