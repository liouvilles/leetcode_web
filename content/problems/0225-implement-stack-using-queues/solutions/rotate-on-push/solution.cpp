class MyStack {
    queue<int> values;
    public:void push(int x){
        values.push(x);
        for(int i=values.size()-1;i>0;--i){
            values.push(values.front());
            values.pop();
        }
    }
    int pop(){
        int value=values.front();
        values.pop();
        return value;
    }
    int top(){
        return values.front();
    }
    bool empty(){
        return values.empty();
    }
};
