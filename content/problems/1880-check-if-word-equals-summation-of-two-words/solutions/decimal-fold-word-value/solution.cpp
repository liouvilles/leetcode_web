class Solution {
    int value(const string& word){
        int result=0;
        for(char letter:word)result=result*10+letter-'a';
        return result;
    }
    public: bool isSumEqual(string firstWord,string secondWord,string targetWord){
        return value(firstWord)+value(secondWord)==value(targetWord);
    }
};
