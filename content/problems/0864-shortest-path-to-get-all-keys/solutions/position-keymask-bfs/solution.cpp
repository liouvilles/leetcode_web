class Solution {
    public: int shortestPathAllKeys(vector<string>& grid){
        int rows=grid.size(),columns=grid[0].size(),startRow=0,startColumn=0,target=0;
        for(int r=0;r<rows;++r)for(int c=0;c<columns;++c){
            char value=grid[r][c];
            if(value=='@'){
                startRow=r;
                startColumn=c;
            }else if(value>='a'&&value<='f')target|=1<<(value-'a');
        }
        bool seen[30][30][64]{
        };
        queue<array<int,4>> pending;
        pending.push({
            startRow,startColumn,0,0
        });
        seen[startRow][startColumn][0]=true;
        int directions[5]={
            -1,0,1,0,-1
        };
        while(!pending.empty()){
            auto state=pending.front();
            pending.pop();
            if(state[2]==target)return state[3];
            for(int d=0;d<4;++d){
                int r=state[0]+directions[d],c=state[1]+directions[d+1];
                if(r<0||r>=rows||c<0||c>=columns||grid[r][c]=='#')continue;
                char value=grid[r][c];
                int mask=state[2];
                if(value>='A'&&value<='F'&&!(mask&(1<<(value-'A'))))continue;
                if(value>='a'&&value<='f')mask|=1<<(value-'a');
                if(!seen[r][c][mask]){
                    seen[r][c][mask]=true;
                    pending.push({
                        r,c,mask,state[3]+1
                    });
                }
            }
        }
        return -1;
    }
};
