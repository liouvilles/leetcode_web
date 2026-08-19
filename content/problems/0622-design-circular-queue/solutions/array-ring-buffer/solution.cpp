class MyCircularQueue {
    vector<int> values;
    int head=0,size=0;
    public:MyCircularQueue(int k):values(k){
    }
    bool enQueue(int value){
        if(isFull())return false;
        values[(head+size)%values.size()]=value;
        ++size;
        return true;
    }
    bool deQueue(){
        if(isEmpty())return false;
        head=(head+1)%values.size();
        --size;
        return true;
    }
    int Front(){
        return isEmpty()?-1:values[head];
    }
    int Rear(){
        return isEmpty()?-1:values[(head+size-1)%values.size()];
    }
    bool isEmpty(){
        return size==0;
    }
    bool isFull(){
        return size==(int)values.size();
    }
};
