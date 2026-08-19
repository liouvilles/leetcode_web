class Solution {
    bool vowel(char ch){
        return string("AEIOUaeiou").find(ch)!=string::npos;
    }
    public:string sortVowels(string s){
        vector<char> vowels;
        for(char ch:s)if(vowel(ch))vowels.push_back(ch);
        sort(vowels.begin(),vowels.end());
        int index=0;
        for(char& ch:s)if(vowel(ch))ch=vowels[index++];
        return s;
    }
};
