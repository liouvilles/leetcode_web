class Solution {
    public:bool checkDistances(string s,vector<int>& distance){
        int first[26];
        fill(begin(first),end(first),-1);
        for(int i=0;i<(int)s.size();++i){
            int letter=s[i]-'a';
            if(first[letter]<0)first[letter]=i;
            else if(i-first[letter]-1!=distance[letter])return false;
        }
        return true;
    }
};
