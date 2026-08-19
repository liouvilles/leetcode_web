class Solution {
    fun countLargestGroup(n:Int):Int{
        val count=IntArray(100);
        for(value in 1..n){
            var x=value;
            var sum=0;
            while(x>0){
                sum+=x%10;
                x/=10
            };
            count[sum]++
        };
        val maximum=count.maxOrNull()!!;
        return count.count{
            it==maximum
        }
    }
}
