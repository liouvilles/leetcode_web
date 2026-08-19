class Solution {
    public int[] sumEvenAfterQueries(int[] nums,int[][] queries){
        int evenSum=0;
        for(int value:nums)if(value%2==0)evenSum+=value;
        int[] answer=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int index=queries[i][1];
            if(nums[index]%2==0)evenSum-=nums[index];
            nums[index]+=queries[i][0];
            if(nums[index]%2==0)evenSum+=nums[index];
            answer[i]=evenSum;
        }
        return answer;
    }
}
