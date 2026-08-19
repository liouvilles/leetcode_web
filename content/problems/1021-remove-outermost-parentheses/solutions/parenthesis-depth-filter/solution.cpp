class Solution {
    public: string removeOuterParentheses(string s){
        string answer;
        int depth=0;
        for(char ch:s)if(ch=='('){
            if(depth++>0)answer+=ch;
        }else if(--depth>0)answer+=ch;
        return answer;
    }
};
