class Solution {
    public: string makeGood(string text){
        string stack;
        for(char value:text)if(!stack.empty()&&abs(stack.back()-value)==32)stack.pop_back();
        else stack+=value;
        return stack;
    }
};
