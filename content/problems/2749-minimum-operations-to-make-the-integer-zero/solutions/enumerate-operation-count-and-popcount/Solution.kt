class Solution {
    fun makeTheIntegerZero(num1:Int,num2:Int):Int{
        for(operations in 1..60){
            val target=num1.toLong()-operations.toLong()*num2;
            if(target>=operations.toLong()&&java.lang.Long.bitCount(target)<=operations)return operations
        };
        return -1
    }
}
