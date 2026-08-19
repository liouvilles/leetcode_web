class Solution {
    public:int longestPalindrome(vector<string>& words){
        int count[26][26]={
        };
        for(string& word:words)++count[word[0]-'a'][word[1]-'a'];
        int answer=0;
        bool center=false;
        for(int a=0;a<26;++a){
            for(int b=a+1;b<26;++b)answer+=4*min(count[a][b],count[b][a]);
            answer+=count[a][a]/2*4;
            center|=count[a][a]%2;
        }
        return answer+(center?2:0);
    }
};
