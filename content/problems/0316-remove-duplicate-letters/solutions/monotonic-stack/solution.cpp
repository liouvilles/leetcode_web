class Solution {
    public: string removeDuplicateLetters(string s){
        array<int,26> remaining{
        };
        array<bool,26> used{
        };
        for(char c:s)++remaining[c-'a'];
        string stack;
        for(char c:s){
            int index=c-'a';
            --remaining[index];
            if(used[index])continue;
            while(!stack.empty()&&stack.back()>c&&remaining[stack.back()-'a']>0){
                used[stack.back()-'a']=false;
                stack.pop_back();
            }
            stack.push_back(c);
            used[index]=true;
        }
        return stack;
    }
};
