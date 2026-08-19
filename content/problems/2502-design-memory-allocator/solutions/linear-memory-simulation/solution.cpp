class Allocator {
    vector<int> memory;
    public:Allocator(int n):memory(n){
    }
    int allocate(int size,int mID){
        int run=0;
        for(int i=0;i<(int)memory.size();++i){
            run=memory[i]?0:run+1;
            if(run==size){
                int start=i-size+1;
                fill(memory.begin()+start,memory.begin()+i+1,mID);
                return start;
            }
        }
        return -1;
    }
    int freeMemory(int mID){
        int released=0;
        for(int& cell:memory)if(cell==mID){
            cell=0;
            ++released;
        }
        return released;
    }
};
