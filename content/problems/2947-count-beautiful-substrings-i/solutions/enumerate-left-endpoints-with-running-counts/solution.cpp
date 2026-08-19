class Solution {
    bool isVowel(char letter){
        return letter=='a'||letter=='e'||letter=='i'||letter=='o'||letter=='u';
    }
    public:int beautifulSubstrings(string s,int k){
        int answer=0;
        for(int left=0;left<(int)s.size();++left){
            int vowels=0,consonants=0;
            for(int right=left;right<(int)s.size();++right){
                if(isVowel(s[right]))++vowels;
                else ++consonants;
                if(vowels==consonants&&vowels*consonants%k==0)++answer;
            }
        }
        return answer;
    }
};
