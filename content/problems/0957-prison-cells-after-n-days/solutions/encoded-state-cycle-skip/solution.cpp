class Solution {
    int encode(vector<int>& cells){
        int state=0;
        for(int bit:cells)state=state*2+bit;
        return state;
    }
    public:vector<int> prisonAfterNDays(vector<int>& cells,int n){
        unordered_map<int,int> seen;
        while(n>0){
            int state=encode(cells);
            if(seen.count(state))n%=seen[state]-n;
            else seen[state]=n;
            if(n>0){
                --n;
                vector<int> next(8);
                for(int i=1;i<7;++i)next[i]=cells[i-1]==cells[i+1];
                cells.swap(next);
            }
        }
        return cells;
    }
};
