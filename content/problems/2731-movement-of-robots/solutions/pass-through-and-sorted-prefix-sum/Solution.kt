class Solution {
    fun sumDistance(nums:IntArray,s:String,d:Int):Int{
        val mod=1000000007L;
        val positions=LongArray(nums.size){
            i->nums[i].toLong()+if(s[i]=='R')d.toLong() else -d.toLong()
        };
        positions.sort();
        var prefix=0L;
        var answer=0L;
        for(i in positions.indices){
            answer=(answer+positions[i]*i-prefix)%mod;
            prefix+=positions[i]
        };
        return answer.toInt()
    }
}
