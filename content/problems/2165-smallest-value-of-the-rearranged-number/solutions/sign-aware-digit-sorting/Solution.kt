class Solution {
    fun smallestNumber(num:Long):Long{
        if(num==0L)return 0;
        val digits=kotlin.math.abs(num).toString().toCharArray();
        digits.sort();
        if(num>0){
            var first=0;
            while(digits[first]=='0')first++;
            val temporary=digits[0];
            digits[0]=digits[first];
            digits[first]=temporary;
            return String(digits).toLong()
        };
        digits.reverse();
        return -String(digits).toLong()
    }
}
