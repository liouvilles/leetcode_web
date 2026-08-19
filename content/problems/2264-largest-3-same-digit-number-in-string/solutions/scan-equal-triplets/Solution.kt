class Solution {
    fun largestGoodInteger(num:String):String{
        var best:Char?=null;
        for(i in 0 until num.length-2)if(num[i]==num[i+1]&&num[i]==num[i+2]&&(best==null||num[i]>best!!))best=num[i];
        return best?.toString()?.repeat(3)?:""
    }
}
