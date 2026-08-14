class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        vector<int> stack;
        for (const string& token : tokens) { if (token.size() == 1 && string("+-*/").find(token[0]) != string::npos) { int right = stack.back(); stack.pop_back(); int left = stack.back(); stack.pop_back(); if (token == "+") stack.push_back(left + right); else if (token == "-") stack.push_back(left - right); else if (token == "*") stack.push_back(left * right); else stack.push_back(left / right); } else stack.push_back(stoi(token)); }
        return stack.back();
    }
};
