class Solution {
    public: string predictPartyVictory(string senate){
        queue<int> radiant,dire;
        for(int i=0;i<(int)senate.size();++i)(senate[i]=='R'?radiant:dire).push(i);
        while(!radiant.empty()&&!dire.empty()){
            int r=radiant.front(),d=dire.front();
            radiant.pop();
            dire.pop();
            if(r<d)radiant.push(r+senate.size());
            else dire.push(d+senate.size());
        }
        return radiant.empty()?"Dire":"Radiant";
    }
};
