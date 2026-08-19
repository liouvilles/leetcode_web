class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid,int k){
        int rows=grid.length,columns=grid[0].length,total=rows*columns;
        k%=total;
        int[][] shifted=new int[rows][columns];
        for(int index=0;index<total;index++){
            int next=(index+k)%total;
            shifted[next/columns][next%columns]=grid[index/columns][index%columns];
        }
        List<List<Integer>> answer=new ArrayList<>();
        for(int[] row:shifted){
            List<Integer> values=new ArrayList<>();
            for(int value:row)values.add(value);
            answer.add(values);
        }
        return answer;
    }
}
