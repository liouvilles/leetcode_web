class Solution {
    vector<int> parent,size;
    int find(int value){
        return value==parent[value]?value:parent[value]=find(parent[value]);
    }
    void unite(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b)return;
        if(size[a]<size[b])swap(a,b);
        parent[b]=a;
        size[a]+=size[b];
    }
    public:vector<int> groupStrings(vector<string>& words){
        int n=words.size();
        parent.resize(n);
        iota(parent.begin(),parent.end(),0);
        size.assign(n,1);
        unordered_map<int,int> masks;
        vector<int> values(n);
        for(int i=0;i<n;++i){
            int mask=0;
            for(char ch:words[i])mask|=1<<(ch-'a');
            values[i]=mask;
            if(masks.count(mask))unite(i,masks[mask]);
            else masks[mask]=i;
        }
        unordered_map<int,int> removedOwner;
        for(int i=0;i<n;++i)for(int bits=values[i];bits;bits&=bits-1){
            int removed=values[i]^(bits&-bits);
            if(masks.count(removed))unite(i,masks[removed]);
            if(removedOwner.count(removed))unite(i,removedOwner[removed]);
            else removedOwner[removed]=i;
        }
        unordered_set<int> roots;
        int maximum=0;
        for(int i=0;i<n;++i){
            int root=find(i);
            roots.insert(root);
            maximum=max(maximum,size[root]);
        }
        return{
            (int)roots.size(),maximum
        };
    }
};
