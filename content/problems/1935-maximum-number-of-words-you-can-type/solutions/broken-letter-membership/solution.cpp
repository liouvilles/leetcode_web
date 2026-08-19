class Solution {
    public: int canBeTypedWords(string text,string brokenLetters){
        bool broken[26]={
        };
        for(char letter:brokenLetters)broken[letter-'a']=true;
        stringstream stream(text);
        string word;
        int answer=0;
        while(stream>>word){
            bool valid=true;
            for(char letter:word)if(broken[letter-'a'])valid=false;
            answer+=valid;
        }
        return answer;
    }
};
