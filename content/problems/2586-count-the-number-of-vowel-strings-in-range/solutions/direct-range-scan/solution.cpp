class Solution {
    public:int vowelStrings(vector<string>& words,int left,int right){
        int answer=0;
        string vowels="aeiou";
        for(int i=left;i<=right;++i)if(vowels.find(words[i].front())!=string::npos&&vowels.find(words[i].back())!=string::npos)++answer;
        return answer;
    }
};
