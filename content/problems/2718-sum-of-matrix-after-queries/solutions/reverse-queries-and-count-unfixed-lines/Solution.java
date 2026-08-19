class Solution {
    public long matrixSumQueries(int n,int[][] queries){
        boolean[] seenRow=new boolean[n],seenCol=new boolean[n];
        int usedRows=0,usedCols=0;
        long answer=0;
        for(int i=queries.length-1;i>=0;i--){
            int type=queries[i][0],index=queries[i][1],value=queries[i][2];
            if(type==0&&!seenRow[index]){
                answer+=(long)value*(n-usedCols);
                seenRow[index]=true;
                usedRows++;
            }else if(type==1&&!seenCol[index]){
                answer+=(long)value*(n-usedRows);
                seenCol[index]=true;
                usedCols++;
            }
        }
        return answer;
    }
}
