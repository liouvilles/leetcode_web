class Solution {
    public: string reverseWords(string s){
        for(int start=0,end=0;end<=(int)s.size();++end)if(end==(int)s.size()||s[end]==' '){
            reverse(s.begin()+start,s.begin()+end);
            start=end+1;
        }
        return s;
    }
};
