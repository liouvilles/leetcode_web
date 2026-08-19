class Solution {
    public int equalPairs(int[][] grid){
        Map<String,Integer> frequency=new HashMap<>();
        for(int[] row:grid)frequency.merge(Arrays.toString(row),1,Integer::sum);
        int n=grid.length,answer=0;
        for(int column=0;column<n;column++){
            int[] values=new int[n];
            for(int row=0;row<n;row++)values[row]=grid[row][column];
            answer+=frequency.getOrDefault(Arrays.toString(values),0);
        }
        return answer;
    }
}
