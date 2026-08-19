class Solution {
    fun gcdOfStrings(str1:String,str2:String):String{
        if(str1+str2!=str2+str1)return "";
        fun gcd(aInput:Int,bInput:Int):Int{
            var a=aInput;
            var b=bInput;
            while(b!=0){
                val temporary=a%b;
                a=b;
                b=temporary
            };
            return a
        };
        return str1.substring(0,gcd(str1.length,str2.length))
    }
}
