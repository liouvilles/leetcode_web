class Solution {
    public int[] maxSubsequence(int[] nums,int k){
        int[][] pairs=new int[nums.length][2];
        for(int i=0;i<nums.length;i++)pairs[i]=new int[]{
            nums[i],i
        };
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        int[][] chosen=Arrays.copyOf(pairs,k);
        Arrays.sort(chosen,Comparator.comparingInt(a->a[1]));
        int[] answer=new int[k];
        for(int i=0;i<k;i++)answer[i]=chosen[i][0];
        return answer;
    }
}
