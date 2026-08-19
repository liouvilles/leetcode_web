class Solution {
    public:int countPalindromes(string s){
        const long long mod=1'000'000'007;
        long long leftSingle[10]={
        },rightSingle[10]={
        },leftPair[10][10]={
        },rightPair[10][10]={
        };
        for(char character:s){
            int digit=character-'0';
            for(int first=0;first<10;++first)rightPair[first][digit]+=rightSingle[first];
            ++rightSingle[digit];
        }
        long long answer=0;
        for(char character:s){
            int digit=character-'0';
            --rightSingle[digit];
            for(int second=0;second<10;++second)rightPair[digit][second]-=rightSingle[second];
            for(int first=0;first<10;++first)for(int second=0;second<10;++second)answer=(answer+leftPair[first][second]*rightPair[second][first])%mod;
            for(int first=0;first<10;++first)leftPair[first][digit]+=leftSingle[first];
            ++leftSingle[digit];
        }
        return answer;
    }
};
