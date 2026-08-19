class Solution {
    public:int minLength(string s){
        string stack;
        for(char current:s){
            if(!stack.empty()&&((stack.back()=='A'&&current=='B')||(stack.back()=='C'&&current=='D')))stack.pop_back();
            else stack.push_back(current);
        }
        return stack.size();
    }
};
