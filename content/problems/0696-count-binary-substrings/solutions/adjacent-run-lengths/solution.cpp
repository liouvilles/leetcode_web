class Solution {
    public: int countBinarySubstrings(string s){
        int previous=0,current=1,answer=0;
        for(int i=1;i<(int)s.size();++i)if(s[i]==s[i-1])++current;
        else{
            answer+=min(previous,current);
            previous=current;
            current=1;
        }
        return answer+min(previous,current);
    }
};
