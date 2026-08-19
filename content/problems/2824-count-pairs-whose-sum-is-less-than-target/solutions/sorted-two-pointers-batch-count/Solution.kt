class Solution {
    fun countPairs(nums:List<Int>,target:Int):Int{
        val values=nums.sorted();
        var left=0;
        var right=values.lastIndex;
        var answer=0;
        while(left<right)if(values[left]+values[right]<target){
            answer+=right-left;
            left++
        }else right--;
        return answer
    }
}
