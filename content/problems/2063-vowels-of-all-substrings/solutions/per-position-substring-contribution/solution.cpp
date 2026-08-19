class Solution {
    public: long long countVowels(string word){
        long long answer=0;
        for(int i=0;i<(int)word.size();++i)if(string("aeiou").find(word[i])!=string::npos)answer+=1LL*(i+1)*(word.size()-i);
        return answer;
    }
};
