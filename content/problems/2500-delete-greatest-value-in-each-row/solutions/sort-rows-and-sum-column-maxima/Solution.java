class Solution {
    public int deleteGreatestValue(int[][] grid){
        for(int[] row:grid)Arrays.sort(row);
        int answer=0;
        for(int col=0;col<grid[0].length;col++){
            int maximum=0;
            for(int[] row:grid)maximum=Math.max(maximum,row[col]);
            answer+=maximum;
        }
        return answer;
    }
}
