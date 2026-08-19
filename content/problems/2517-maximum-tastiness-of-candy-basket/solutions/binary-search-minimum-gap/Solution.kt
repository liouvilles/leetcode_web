class Solution {
    fun maximumTastiness(price:IntArray,k:Int):Int{
        price.sort();
        fun possible(distance:Int):Boolean{
            var count=1;
            var last=price[0];
            for(value in price)if(value-last>=distance){
                count++;
                last=value;
                if(count>=k)return true
            };
            return count>=k
        };
        var left=0;
        var right=(price.last()-price.first())/(k-1);
        while(left<right){
            val middle=(left+right+1) ushr 1;
            if(possible(middle))left=middle else right=middle-1
        };
        return left
    }
}
