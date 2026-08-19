class Solution {
    fun isPerfectSquare(num:Int):Boolean{
        var left=1L;
        var right=num.toLong();
        while(left<=right){
            val middle=left+(right-left)/2;
            val square=middle*middle;
            if(square==num.toLong())return true;
            if(square<num)left=middle+1 else right=middle-1
        };
        return false
    }
}
