class CustomStack {
    vector<int> values;
    int capacity;
    public:CustomStack(int maxSize):capacity(maxSize){
    }
    void push(int x){
        if((int)values.size()<capacity)values.push_back(x);
    }
    int pop(){
        if(values.empty())return -1;
        int answer=values.back();
        values.pop_back();
        return answer;
    }
    void increment(int k,int val){
        for(int i=0;i<min(k,(int)values.size());++i)values[i]+=val;
    }
};
