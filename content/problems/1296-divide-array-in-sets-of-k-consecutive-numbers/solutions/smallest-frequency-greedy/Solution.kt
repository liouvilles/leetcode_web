class Solution {
    fun isPossibleDivide(nums:IntArray,k:Int):Boolean{
        if(nums.size%k!=0)return false;
        val frequency=java.util.TreeMap<Int,Int>();
        for(value in nums)frequency[value]=(frequency[value]?:0)+1;
        while(frequency.isNotEmpty()){
            val start=frequency.firstKey();
            for(value in start until start+k){
                val count=frequency[value]?:return false;
                if(count==1)frequency.remove(value)else frequency[value]=count-1
            }
        };
        return true
    }
}
