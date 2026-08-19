class SmallestInfiniteSet {
    int current=1;
    set<int> addedBack;
    public:SmallestInfiniteSet(){
    }
    int popSmallest(){
        if(addedBack.empty())return current++;
        int value=*addedBack.begin();
        addedBack.erase(addedBack.begin());
        return value;
    }
    void addBack(int num){
        if(num<current)addedBack.insert(num);
    }
};
