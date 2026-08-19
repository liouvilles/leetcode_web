class SnapshotArray {
    vector<map<int,int>> history;
    int currentSnap=0;
    public:SnapshotArray(int length):history(length){
        for(auto& versions:history)versions[0]=0;
    }
    void set(int index,int val){
        history[index][currentSnap]=val;
    }
    int snap(){
        return currentSnap++;
    }
    int get(int index,int snapId){
        auto it=history[index].upper_bound(snapId);
        return prev(it)->second;
    }
};
