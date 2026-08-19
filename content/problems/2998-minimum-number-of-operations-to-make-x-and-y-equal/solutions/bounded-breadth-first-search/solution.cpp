class Solution {
    public:int minimumOperationsToMakeEqual(int x,int y){
        if(x<=y)return y-x;
        int upper=2*max(x,y)+12;
        vector<int> distance(upper+1,-1);
        queue<int> pending;
        pending.push(x);
        distance[x]=0;
        while(!pending.empty()){
            int value=pending.front();
            pending.pop();
            if(value==y)return distance[value];
            int next[4]={
                value-1,value+1,value%5==0?value/5:-1,value%11==0?value/11:-1
            };
            for(int candidate:next)if(candidate>=1&&candidate<=upper&&distance[candidate]<0){
                distance[candidate]=distance[value]+1;
                pending.push(candidate);
            }
        }
        return -1;
    }
};
