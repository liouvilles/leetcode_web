class Solution {
    public:int longestPath(vector<int>& parent,string s){
        int n=parent.size();
        vector<vector<int>> children(n);
        for(int i=1;i<n;++i)children[parent[i]].push_back(i);
        vector<int> order,stack={
            0
        },down(n);
        while(!stack.empty()){
            int node=stack.back();
            stack.pop_back();
            order.push_back(node);
            for(int child:children[node])stack.push_back(child);
        }
        int answer=1;
        for(int index=n-1;index>=0;--index){
            int node=order[index],first=0,second=0;
            for(int child:children[node])if(s[child]!=s[node]){
                int value=down[child];
                if(value>first){
                    second=first;
                    first=value;
                }else if(value>second)second=value;
            }
            down[node]=first+1;
            answer=max(answer,first+second+1);
        }
        return answer;
    }
};
