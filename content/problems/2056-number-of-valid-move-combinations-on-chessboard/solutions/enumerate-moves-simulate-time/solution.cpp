class Solution {
    struct Move{
        int dr,dc,steps;
    };
    vector<vector<Move>> options;
    vector<Move> selected;
    vector<vector<int>> positions;
    bool valid(){
        for(int time=1;time<=7;++time){
            set<pair<int,int>> occupied;
            for(int i=0;i<(int)selected.size();++i){
                auto move=selected[i];
                int steps=min(time,move.steps),row=positions[i][0]+move.dr*steps,col=positions[i][1]+move.dc*steps;
                if(!occupied.insert({
                    row,col
                }).second)return false;
            }
        }
        return true;
    }
    int dfs(int index){
        if(index==(int)selected.size())return valid();
        int answer=0;
        for(auto move:options[index]){
            selected[index]=move;
            answer+=dfs(index+1);
        }
        return answer;
    }
    public: int countCombinations(vector<string>& pieces,vector<vector<int>>& input){
        positions=input;
        int n=pieces.size();
        options.resize(n);
        selected.resize(n);
        vector<pair<int,int>> rook={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        },bishop={
            {
                1,1
            },{
                1,-1
            },{
                -1,1
            },{
                -1,-1
            }
        },queen=rook;
        queen.insert(queen.end(),bishop.begin(),bishop.end());
        for(int i=0;i<n;++i){
            options[i].push_back({
                0,0,0
            });
            auto directions=pieces[i]=="rook"?rook:pieces[i]=="bishop"?bishop:queen;
            for(auto [dr,dc]:directions)for(int step=1;;++step){
                int row=positions[i][0]+dr*step,col=positions[i][1]+dc*step;
                if(row<1||row>8||col<1||col>8)break;
                options[i].push_back({
                    dr,dc,step
                });
            }
        }
        return dfs(0);
    }
};
