class Solution {
    fun maximum69Number(num:Int):Int{
        val digits=num.toString().toCharArray();
        for(i in digits.indices)if(digits[i]=='6'){
            digits[i]='9';
            break
        };
        return digits.concatToString().toInt()
    }
}
