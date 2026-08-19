class Solution {
    int bit(char value){
        string vowels="aeiou";
        auto position=vowels.find(value);
        return position==string::npos?0:1<<position;
    }
    public: int countVowelSubstrings(string word){
        int answer=0;
        for(int left=0;left<(int)word.size();++left){
            int mask=0;
            for(int right=left;right<(int)word.size();++right){
                int value=bit(word[right]);
                if(!value)break;
                mask|=value;
                if(mask==31)++answer;
            }
        }
        return answer;
    }
};
