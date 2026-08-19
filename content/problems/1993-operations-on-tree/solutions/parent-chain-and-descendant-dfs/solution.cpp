class LockingTree {
    vector<int> parent,locked;
    vector<vector<int>> children;
    bool clear(int node){
        bool found=locked[node]!=-1;
        locked[node]=-1;
        for(int child:children[node])found=clear(child)||found;
        return found;
    }
    public: LockingTree(vector<int>& parent):parent(parent),locked(parent.size(),-1),children(parent.size()){
        for(int i=1;i<(int)parent.size();++i)children[parent[i]].push_back(i);
    }
    bool lock(int num,int user){
        if(locked[num]!=-1)return false;
        locked[num]=user;
        return true;
    }
    bool unlock(int num,int user){
        if(locked[num]!=user)return false;
        locked[num]=-1;
        return true;
    }
    bool upgrade(int num,int user){
        if(locked[num]!=-1)return false;
        for(int ancestor=parent[num];ancestor!=-1;ancestor=parent[ancestor])if(locked[ancestor]!=-1)return false;
        bool found=false;
        for(int child:children[num])found=clear(child)||found;
        if(!found)return false;
        locked[num]=user;
        return true;
    }
};
