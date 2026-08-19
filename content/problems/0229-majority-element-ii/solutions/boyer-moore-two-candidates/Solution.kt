class Solution {
    fun majorityElement(nums:IntArray):List<Int>{
        var first=0;
        var second=1;
        var count1=0;
        var count2=0;
        for(value in nums){
            when{
                value==first->count1++;
                value==second->count2++;
                count1==0->{
                    first=value;
                    count1=1
                };
                count2==0->{
                    second=value;
                    count2=1
                };
                else->{
                    count1--;
                    count2--
                }
            }
        };
        count1=nums.count{
            it==first
        };
        count2=nums.count{
            it==second
        };
        val answer=mutableListOf<Int>();
        if(count1>nums.size/3)answer.add(first);
        if(count2>nums.size/3)answer.add(second);
        answer.sort();
        return answer
    }
}
