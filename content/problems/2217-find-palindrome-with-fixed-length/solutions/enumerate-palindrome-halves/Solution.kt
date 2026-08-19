class Solution {
    fun kthPalindrome(queries:IntArray,intLength:Int):LongArray{
        val halfLength=(intLength+1)/2;
        var start=1L;
        repeat(halfLength-1){
            start*=10
        };
        val limit=9*start;
        return LongArray(queries.size){
            i->val offset=queries[i]-1L;
            if(offset>=limit)-1L else{
                val half=start+offset;
                var result=half;
                var mirror=if(intLength%2==1)half/10 else half;
                while(mirror>0){
                    result=result*10+mirror%10;
                    mirror/=10
                };
                result
            }
        }
    }
}
