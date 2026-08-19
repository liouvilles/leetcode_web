class Solution {
    public: vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens,vector<int>& king){
        bool occupied[8][8]{
        };
        for(auto& queen:queens)occupied[queen[0]][queen[1]]=true;
        int directions[8][2]={
            {
                -1,-1
            },{
                -1,0
            },{
                -1,1
            },{
                0,-1
            },{
                0,1
            },{
                1,-1
            },{
                1,0
            },{
                1,1
            }
        };
        vector<vector<int>> answer;
        for(auto& direction:directions){
            int r=king[0]+direction[0],c=king[1]+direction[1];
            while(r>=0&&r<8&&c>=0&&c<8){
                if(occupied[r][c]){
                    answer.push_back({
                        r,c
                    });
                    break;
                }
                r+=direction[0];
                c+=direction[1];
            }
        }
        return answer;
    }
};
