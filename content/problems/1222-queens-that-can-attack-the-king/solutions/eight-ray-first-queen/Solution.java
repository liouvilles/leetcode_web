class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens,int[] king){
        boolean[][] occupied=new boolean[8][8];
        for(int[] queen:queens)occupied[queen[0]][queen[1]]=true;
        int[][] directions={
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
        List<List<Integer>> answer=new ArrayList<>();
        for(int[] direction:directions){
            int r=king[0]+direction[0],c=king[1]+direction[1];
            while(r>=0&&r<8&&c>=0&&c<8){
                if(occupied[r][c]){
                    answer.add(Arrays.asList(r,c));
                    break;
                }
                r+=direction[0];
                c+=direction[1];
            }
        }
        return answer;
    }
}
