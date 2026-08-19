class Solution {
    public: int maxCandies(vector<int>& status,vector<int>& candies,vector<vector<int>>& keys,vector<vector<int>>& containedBoxes,vector<int>& initialBoxes){
        int n=status.size(),total=0;
        vector<bool> owned(n),hasKey(n),opened(n);
        queue<int> pending;
        for(int box:initialBoxes){
            owned[box]=true;
            pending.push(box);
        }while(!pending.empty()){
            int box=pending.front();
            pending.pop();
            if(opened[box]||!owned[box]||(!status[box]&&!hasKey[box]))continue;
            opened[box]=true;
            total+=candies[box];
            for(int key:keys[box]){
                hasKey[key]=true;
                if(owned[key])pending.push(key);
            }
            for(int child:containedBoxes[box]){
                owned[child]=true;
                pending.push(child);
            }
        }
        return total;
    }
};
