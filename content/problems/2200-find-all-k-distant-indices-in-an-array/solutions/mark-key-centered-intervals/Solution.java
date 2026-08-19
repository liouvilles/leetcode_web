class Solution {
    public List<Integer> findKDistantIndices(int[] nums,int key,int k){
        boolean[] nearby=new boolean[nums.length];
        for(int j=0;j<nums.length;j++)if(nums[j]==key)for(int i=Math.max(0,j-k);i<=Math.min(nums.length-1,j+k);i++)nearby[i]=true;
        List<Integer> answer=new ArrayList<>();
        for(int i=0;i<nums.length;i++)if(nearby[i])answer.add(i);
        return answer;
    }
}
