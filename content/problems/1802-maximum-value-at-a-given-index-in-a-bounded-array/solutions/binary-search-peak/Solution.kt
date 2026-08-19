class Solution {
    private fun side(peak:Long,length:Int):Long=if(peak>=length)(peak+peak-length+1)*length/2 else peak*(peak+1)/2+(length-peak);
    fun maxValue(n:Int,index:Int,maxSum:Int):Int{
        var left=1;
        var right=maxSum;
        while(left<right){
            val middle=left+(right-left+1)/2;
            val required=middle+side(middle.toLong()-1,index)+side(middle.toLong()-1,n-index-1);
            if(required<=maxSum)left=middle else right=middle-1
        };
        return left
    }
}
