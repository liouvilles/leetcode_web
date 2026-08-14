class MinStack {
    vector<pair<int, int>> stack;
public:
    MinStack() {}
    void push(int value) { int minimum = stack.empty() ? value : min(value, stack.back().second); stack.push_back({value, minimum}); }
    void pop() { stack.pop_back(); }
    int top() { return stack.back().first; }
    int getMin() { return stack.back().second; }
};
