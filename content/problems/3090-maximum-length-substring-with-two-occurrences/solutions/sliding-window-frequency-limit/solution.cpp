class Solution {
    public:int maximumLengthSubstring(string s){
        int frequency[26]{
        },left=0,answer=0;
        for(int right=0;right<(int)s.size();++right){
            int letter=s[right]-'a';
            ++frequency[letter];
            while(frequency[letter]>2)--frequency[s[left++]-'a'];
            answer=max(answer,right-left+1);
        }
        return answer;
    }
};
