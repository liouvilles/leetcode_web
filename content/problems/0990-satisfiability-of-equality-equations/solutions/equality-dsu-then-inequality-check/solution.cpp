class Solution {
    int parent[26];
    int find(int x){
        return parent[x]==x?x:parent[x]=find(parent[x]);
    }
    public:bool equationsPossible(vector<string>& equations){
        iota(parent,parent+26,0);
        for(string& equation:equations)if(equation[1]=='=')parent[find(equation[0]-'a')]=find(equation[3]-'a');
        for(string& equation:equations)if(equation[1]=='!'&&find(equation[0]-'a')==find(equation[3]-'a'))return false;
        return true;
    }
};
