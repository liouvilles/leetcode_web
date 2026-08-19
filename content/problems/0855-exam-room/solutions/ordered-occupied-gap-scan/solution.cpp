class ExamRoom {
    int n;
    set<int> occupied;
    public:ExamRoom(int n):n(n){
    }
    int seat(){
        if(occupied.empty()){
            occupied.insert(0);
            return 0;
        }
        int candidate=0,best=*occupied.begin(),previous=*occupied.begin();
        for(auto it=next(occupied.begin());it!=occupied.end();++it){
            int distance=(*it-previous)/2;
            if(distance>best){
                best=distance;
                candidate=previous+distance;
            }
            previous=*it;
        }
        if(n-1-previous>best)candidate=n-1;
        occupied.insert(candidate);
        return candidate;
    }
    void leave(int p){
        occupied.erase(p);
    }
};
