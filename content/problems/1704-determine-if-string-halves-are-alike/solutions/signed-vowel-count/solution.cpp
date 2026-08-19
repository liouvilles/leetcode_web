class Solution {
    public: bool halvesAreAlike(string text){
        string vowels="aeiouAEIOU";
        int difference=0;
        for(int i=0;i<(int)text.size();++i)if(vowels.find(text[i])!=string::npos)difference+=i<(int)text.size()/2?1:-1;
        return difference==0;
    }
};
