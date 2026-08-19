class Solution {
    public: string smallestSubsequence(string s){
        int remaining[26]={
        };
        bool used[26]={
        };
        for(char ch:s)++remaining[ch-'a'];
        string stack;
        for(char ch:s){
            int index=ch-'a';
            --remaining[index];
            if(used[index])continue;
            while(!stack.empty()&&stack.back()>ch&&remaining[stack.back()-'a']>0){
                used[stack.back()-'a']=false;
                stack.pop_back();
            }
            stack+=ch;
            used[index]=true;
        }
        return stack;
    }
};
