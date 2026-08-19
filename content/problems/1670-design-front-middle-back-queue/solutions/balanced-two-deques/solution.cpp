class FrontMiddleBackQueue {
    deque<int> left,right;
    void balance(){
        if(left.size()<right.size()){
            left.push_back(right.front());
            right.pop_front();
        }else if(left.size()>right.size()+1){
            right.push_front(left.back());
            left.pop_back();
        }
    }
    public:FrontMiddleBackQueue(){
    }
    void pushFront(int val){
        left.push_front(val);
        balance();
    }
    void pushMiddle(int val){
        if(left.size()>right.size()){
            right.push_front(left.back());
            left.pop_back();
        }
        left.push_back(val);
    }
    void pushBack(int val){
        right.push_back(val);
        balance();
    }
    int popFront(){
        if(left.empty())return -1;
        int value=left.front();
        left.pop_front();
        balance();
        return value;
    }
    int popMiddle(){
        if(left.empty())return -1;
        int value=left.back();
        left.pop_back();
        balance();
        return value;
    }
    int popBack(){
        if(left.empty())return -1;
        int value;
        if(right.empty()){
            value=left.back();
            left.pop_back();
        }else{
            value=right.back();
            right.pop_back();
        }
        balance();
        return value;
    }
};
