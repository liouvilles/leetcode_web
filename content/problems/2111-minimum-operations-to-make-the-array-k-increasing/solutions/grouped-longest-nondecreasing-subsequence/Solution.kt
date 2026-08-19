class Solution {
    fun kIncreasing(arr:IntArray,k:Int):Int{
        var answer=0;
        for(start in 0 until k){
            val tails=mutableListOf<Int>();
            var length=0;
            var i=start;
            while(i<arr.size){
                length++;
                var left=0;
                var right=tails.size;
                while(left<right){
                    val middle=(left+right)/2;
                    if(tails[middle]<=arr[i])left=middle+1 else right=middle
                };
                if(left==tails.size)tails.add(arr[i])else tails[left]=arr[i];
                i+=k
            };
            answer+=length-tails.size
        };
        return answer
    }
}
