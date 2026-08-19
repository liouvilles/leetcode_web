class Solution {
    public: int openLock(vector<string>& deadends,string target){
        unordered_set<string> dead(deadends.begin(),deadends.end()),seen{
            "0000"
        };
        if(dead.count("0000"))return -1;
        queue<string> pending;
        pending.push("0000");
        int steps=0;
        while(!pending.empty()){
            for(int size=pending.size();size>0;--size){
                string state=pending.front();
                pending.pop();
                if(state==target)return steps;
                for(int i=0;i<4;++i){
                    char original=state[i];
                    for(int delta:{
                        1,-1
                    }){
                        state[i]='0'+(original-'0'+delta+10)%10;
                        if(!dead.count(state)&&seen.insert(state).second)pending.push(state);
                    }
                    state[i]=original;
                }
            }
            ++steps;
        }
        return -1;
    }
};
