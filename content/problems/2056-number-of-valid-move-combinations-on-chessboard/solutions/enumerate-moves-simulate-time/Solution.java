class Solution {
    static class Move{
        int dr,dc,steps;
        Move(int dr,int dc,int steps){
            this.dr=dr;
            this.dc=dc;
            this.steps=steps;
        }
    }
    List<Move>[] options;
    Move[] selected;
    int[][] positions;
    private boolean valid(){
        for(int time=1;time<=7;time++){
            Set<Integer> occupied=new HashSet<>();
            for(int i=0;i<selected.length;i++){
                Move move=selected[i];
                int steps=Math.min(time,move.steps);
                int row=positions[i][0]+move.dr*steps,col=positions[i][1]+move.dc*steps;
                if(!occupied.add(row*10+col))return false;
            }
        }
        return true;
    }
    private int dfs(int index){
        if(index==selected.length)return valid()?1:0;
        int answer=0;
        for(Move move:options[index]){
            selected[index]=move;
            answer+=dfs(index+1);
        }
        return answer;
    }
    public int countCombinations(String[] pieces,int[][] positions){
        this.positions=positions;
        int n=pieces.length;
        options=new List[n];
        selected=new Move[n];
        int[][] rook={
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
        },queen={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            },{
                1,1
            },{
                1,-1
            },{
                -1,1
            },{
                -1,-1
            }
        };
        for(int i=0;i<n;i++){
            options[i]=new ArrayList<>();
            options[i].add(new Move(0,0,0));
            int[][] directions=pieces[i].equals("rook")?rook:pieces[i].equals("bishop")?bishop:queen;
            for(int[] direction:directions)for(int step=1;;step++){
                int row=positions[i][0]+direction[0]*step,col=positions[i][1]+direction[1]*step;
                if(row<1||row>8||col<1||col>8)break;
                options[i].add(new Move(direction[0],direction[1],step));
            }
        }
        return dfs(0);
    }
}
