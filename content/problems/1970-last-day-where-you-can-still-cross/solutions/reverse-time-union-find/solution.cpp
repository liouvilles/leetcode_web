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
    public: int latestDayToCross(int row,int col,vector<vector<int>>& cells){
        int total=row*col,top=total,bottom=total+1;
        parent.resize(total+2);
        iota(parent.begin(),parent.end(),0);
        size.assign(total+2,1);
        vector<bool> land(total);
        int directions[4][2]={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        for(int day=cells.size()-1;day>=0;--day){
            int r=cells[day][0]-1,c=cells[day][1]-1,index=r*col+c;
            land[index]=true;
            if(!r)unite(index,top);
            if(r==row-1)unite(index,bottom);
            for(auto& direction:directions){
                int nr=r+direction[0],nc=c+direction[1];
                if(nr>=0&&nr<row&&nc>=0&&nc<col&&land[nr*col+nc])unite(index,nr*col+nc);
            }
            if(find(top)==find(bottom))return day;
        }
        return 0;
    }
};
