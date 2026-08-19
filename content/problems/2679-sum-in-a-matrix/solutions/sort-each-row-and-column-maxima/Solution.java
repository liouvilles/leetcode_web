class Solution {
    public int matrixSum(int[][] nums){
        for(int[] row:nums)Arrays.sort(row);
        int answer=0;
        for(int col=0;col<nums[0].length;col++){
            int maximum=0;
            for(int[] row:nums)maximum=Math.max(maximum,row[col]);
            answer+=maximum;
        }
        return answer;
    }
}
