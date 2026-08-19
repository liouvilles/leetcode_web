class MyQueue {
    stack<int> input,output;
    void move(){
        if(output.empty())while(!input.empty()){
            output.push(input.top());
            input.pop();
        }
    }
    public:void push(int x){
        input.push(x);
    }
    int pop(){
        move();
        int value=output.top();
        output.pop();
        return value;
    }
    int peek(){
        move();
        return output.top();
    }
    bool empty(){
        return input.empty()&&output.empty();
    }
};
