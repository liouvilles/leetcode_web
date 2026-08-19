class Solution {
    fun complexNumberMultiply(num1:String,num2:String):String{
        fun parse(value:String):IntArray{
            val plus=value.indexOf('+');
            return intArrayOf(value.substring(0,plus).toInt(),value.substring(plus+1,value.lastIndex).toInt())
        };
        val first=parse(num1);
        val second=parse(num2);
        val real=first[0]*second[0]-first[1]*second[1];
        val imaginary=first[0]*second[1]+first[1]*second[0];
        return real.toString()+"+"+imaginary+"i"
    }
}
