class Solution {
    public: string getHint(string secret,string guess){
        int bulls=0;
        array<int,10> first{
        },second{
        };
        for(int i=0;i<(int)secret.size();++i){
            if(secret[i]==guess[i])++bulls;
            else{
                ++first[secret[i]-'0'];
                ++second[guess[i]-'0'];
            }
        }
        int cows=0;
        for(int d=0;d<10;++d)cows+=min(first[d],second[d]);
        return to_string(bulls)+"A"+to_string(cows)+"B";
    }
};
