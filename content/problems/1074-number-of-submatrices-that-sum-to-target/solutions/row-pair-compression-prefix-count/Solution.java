class Solution {
    public int numSubmatrixSumTarget(int[][] matrix,int target){
        int rows=matrix.length,columns=matrix[0].length,answer=0;
        for(int top=0;top<rows;top++){
            int[] sums=new int[columns];
            for(int bottom=top;bottom<rows;bottom++){
                for(int c=0;c<columns;c++)sums[c]+=matrix[bottom][c];
                Map<Integer,Integer> frequency=new HashMap<>();
                frequency.put(0,1);
                int prefix=0;
                for(int value:sums){
                    prefix+=value;
                    answer+=frequency.getOrDefault(prefix-target,0);
                    frequency.merge(prefix,1,Integer::sum);
                }
            }
        }
        return answer;
    }
}
