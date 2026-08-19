class Solution {
    public:string smallestString(string s){
        int index=0;
        while(index<(int)s.size()&&s[index]=='a')++index;
        if(index==(int)s.size())s.back()='z';
        else while(index<(int)s.size()&&s[index]!='a')--s[index++];
        return s;
    }
};
