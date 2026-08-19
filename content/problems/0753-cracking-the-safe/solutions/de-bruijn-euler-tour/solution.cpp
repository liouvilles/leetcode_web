class Solution {
    unordered_set<string> visited;
    string trail;
    int n,k;
    void dfs(string node){
        for(int digit=0;digit<k;++digit){
            string edge=node+char('0'+digit);
            if(visited.insert(edge).second){
                dfs(edge.substr(edge.size()-(n-1)));
                trail+=char('0'+digit);
            }
        }
    }
    public:string crackSafe(int nValue,int kValue){
        n=nValue;
        k=kValue;
        string start(n-1,'0');
        dfs(start);
        reverse(trail.begin(),trail.end());
        return start+trail;
    }
};
