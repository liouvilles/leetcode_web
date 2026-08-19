class Solution {
    public: int longestPalindrome(string s){
        array<int,128> counts{
        };
        for(unsigned char c:s)++counts[c];
        int answer=0;
        for(int count:counts)answer+=count/2*2;
        return answer<(int)s.size()?answer+1:answer;
    }
};
