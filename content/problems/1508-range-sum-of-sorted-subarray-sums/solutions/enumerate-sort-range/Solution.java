class Solution {
    public int rangeSum(int[] nums,int n,int left,int right){
        List<Integer> sums=new ArrayList<>();
        for(int start=0;start<n;start++){
            int sum=0;
            for(int end=start;end<n;end++){
                sum+=nums[end];
                sums.add(sum);
            }
        }
        Collections.sort(sums);
        long answer=0;
        for(int i=left-1;i<right;i++)answer+=sums.get(i);
        return (int)(answer%1_000_000_007L);
    }
}
