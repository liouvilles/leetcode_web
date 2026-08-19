class FreqStack {
    unordered_map<int,int> frequency;
    unordered_map<int,vector<int>> groups;
    int maximum=0;
    public:FreqStack(){
    }
    void push(int value){
        int count=++frequency[value];
        maximum=max(maximum,count);
        groups[count].push_back(value);
    }
    int pop(){
        int value=groups[maximum].back();
        groups[maximum].pop_back();
        --frequency[value];
        if(groups[maximum].empty())--maximum;
        return value;
    }
};
