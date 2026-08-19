class Solution {
    public int countDistinct(int[] nums,int k,int p){
        Set<String> distinct=new HashSet<>();
        for(int start=0;start<nums.length;start++){
            int divisible=0;
            StringBuilder key=new StringBuilder();
            for(int end=start;end<nums.length;end++){
                if(nums[end]%p==0)divisible++;
                if(divisible>k)break;
                key.append('#').append(nums[end]);
                distinct.add(key.toString());
            }
        }
        return distinct.size();
    }
}
