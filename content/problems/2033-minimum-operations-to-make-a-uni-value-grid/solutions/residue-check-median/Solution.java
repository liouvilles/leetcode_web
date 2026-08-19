class Solution {
    public int minOperations(int[][] grid,int x){
        int[] values=new int[grid.length*grid[0].length];
        int index=0,remainder=grid[0][0]%x;
        for(int[] row:grid)for(int value:row){
            if(value%x!=remainder)return -1;
            values[index++]=value;
        }
        Arrays.sort(values);
        int target=values[values.length/2],answer=0;
        for(int value:values)answer+=Math.abs(value-target)/x;
        return answer;
    }
}
