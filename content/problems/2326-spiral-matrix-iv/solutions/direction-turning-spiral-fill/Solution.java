class Solution {
    public int[][] spiralMatrix(int m,int n,ListNode head){
        int[][] matrix=new int[m][n];
        for(int[] row:matrix)Arrays.fill(row,-1);
        int[][] directions={
            {
                0,1
            },{
                1,0
            },{
                0,-1
            },{
                -1,0
            }
        };
        int row=0,column=0,direction=0;
        for(ListNode node=head;node!=null;node=node.next){
            matrix[row][column]=node.val;
            int nr=row+directions[direction][0],nc=column+directions[direction][1];
            if(nr<0||nr>=m||nc<0||nc>=n||matrix[nr][nc]!=-1){
                direction=(direction+1)%4;
                nr=row+directions[direction][0];
                nc=column+directions[direction][1];
            }
            row=nr;
            column=nc;
        }
        return matrix;
    }
}
