class Solution {
    public int maxCount(int m,int n,int[][] ops){
        int rows=m,columns=n;
        for(int[] operation:ops){
            rows=Math.min(rows,operation[0]);
            columns=Math.min(columns,operation[1]);
        }
        return rows*columns;
    }
}
