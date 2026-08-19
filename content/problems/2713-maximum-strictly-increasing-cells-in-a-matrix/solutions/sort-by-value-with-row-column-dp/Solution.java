class Solution {
    public int maxIncreasingCells(int[][] mat){
        int rows=mat.length,cols=mat[0].length,total=rows*cols;
        int[][] cells=new int[total][3];
        int index=0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++)cells[index++]=new int[]{
            mat[row][col],row,col
        };
        Arrays.sort(cells,(a,b)->Integer.compare(a[0],b[0]));
        int[] rowBest=new int[rows],colBest=new int[cols];
        int answer=0,start=0;
        while(start<total){
            int end=start;
            while(end<total&&cells[end][0]==cells[start][0])end++;
            int[] candidate=new int[end-start];
            for(int i=start;i<end;i++){
                int row=cells[i][1],col=cells[i][2];
                candidate[i-start]=1+Math.max(rowBest[row],colBest[col]);
                answer=Math.max(answer,candidate[i-start]);
            }
            for(int i=start;i<end;i++){
                int row=cells[i][1],col=cells[i][2],value=candidate[i-start];
                rowBest[row]=Math.max(rowBest[row],value);
                colBest[col]=Math.max(colBest[col],value);
            }
            start=end;
        }
        return answer;
    }
}
