class Solution {
    private List<Integer> factors(int input){
        List<Integer> result=new ArrayList<>();
        int value=input;
        for(int factor=2;factor*factor<=value;factor++)if(value%factor==0){
            result.add(factor);
            while(value%factor==0)value/=factor;
        }
        if(value>1)result.add(value);
        return result;
    }
    public int findValidSplit(int[] nums){
        Map<Integer,Integer> last=new HashMap<>();
        for(int i=0;i<nums.length;i++)for(int factor:factors(nums[i]))last.put(factor,i);
        int boundary=0;
        for(int i=0;i<nums.length-1;i++){
            for(int factor:factors(nums[i]))boundary=Math.max(boundary,last.get(factor));
            if(i==boundary)return i;
        }
        return -1;
    }
}
