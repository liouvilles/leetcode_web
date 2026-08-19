class Solution {
    fun largestOddNumber(num:String):String{
        for(i in num.lastIndex downTo 0)if((num[i]-'0')%2==1)return num.substring(0,i+1);
        return ""
    }
}
