class Solution {
    private fun apples(side:Long)=2*side*(side+1)*(2*side+1);
    fun minimumPerimeter(neededApples:Long):Long{
        var left=1L;
        var right=1L;
        while(apples(right)<neededApples)right*=2;
        while(left<right){
            val middle=(left+right)/2;
            if(apples(middle)>=neededApples)right=middle else left=middle+1
        };
        return 8*left
    }
}
