class Solution {
    public:bool isValid(string word){
        if(word.size()<3)return false;
        bool hasVowel=false,hasConsonant=false;
        for(char character:word){
            bool lower=character>='a'&&character<='z',upper=character>='A'&&character<='Z',digit=character>='0'&&character<='9';
            if(!lower&&!upper&&!digit)return false;
            if(lower||upper){
                char letter=tolower(character);
                if(string("aeiou").find(letter)!=string::npos)hasVowel=true;
                else hasConsonant=true;
            }
        }
        return hasVowel&&hasConsonant;
    }
};
