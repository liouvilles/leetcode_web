class DinnerPlates {
    int capacity;
    vector<vector<int>> stacks;
    set<int> available;
    public:DinnerPlates(int capacity):capacity(capacity){
    }
    void push(int val){
        int index;
        if(available.empty()){
            index=stacks.size();
            stacks.push_back({
            });
        }else index=*available.begin();
        stacks[index].push_back(val);
        if((int)stacks[index].size()==capacity)available.erase(index);
        else available.insert(index);
    }
    int pop(){
        return stacks.empty()?-1:popAtStack(stacks.size()-1);
    }
    int popAtStack(int index){
        if(index<0||index>=(int)stacks.size()||stacks[index].empty())return -1;
        int value=stacks[index].back();
        stacks[index].pop_back();
        available.insert(index);
        while(!stacks.empty()&&stacks.back().empty()){
            int last=stacks.size()-1;
            stacks.pop_back();
            available.erase(last);
        }
        return value;
    }
};
