class Solution {
    public: string shortestPalindrome(string s){
        string reversed=s;
        reverse(reversed.begin(),reversed.end());
        string combined=s+"#"+reversed;
        vector<int> prefix(combined.size());
        for(int i=1;i<(int)combined.size();++i){
            int j=prefix[i-1];
            while(j>0&&combined[i]!=combined[j])j=prefix[j-1];
            if(combined[i]==combined[j])++j;
            prefix[i]=j;
        }
        int length=prefix.empty()?0:prefix.back();
        return reversed.substr(0,s.size()-length)+s;
    }
};
