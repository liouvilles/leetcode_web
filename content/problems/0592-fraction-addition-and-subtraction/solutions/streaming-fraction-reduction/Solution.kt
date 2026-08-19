class Solution {
    fun fractionAddition(expression:String):String{
        var numerator=0L;
        var denominator=1L;
        var index=0;
        while(index<expression.length){
            var sign=1;
            if(expression[index]=='+'||expression[index]=='-')sign=if(expression[index++]=='-')-1 else 1;
            var value=0L;
            while(index<expression.length&&expression[index].isDigit())value=value*10+(expression[index++]-'0');
            index++;
            var divisor=0L;
            while(index<expression.length&&expression[index].isDigit())divisor=divisor*10+(expression[index++]-'0');
            numerator=numerator*divisor+sign*value*denominator;
            denominator*=divisor;
            val gcd=gcd(kotlin.math.abs(numerator),denominator);
            numerator/=gcd;
            denominator/=gcd
        };
        return "$numerator/$denominator"
    };
    private fun gcd(first:Long,second:Long):Long{
        var a=first;
        var b=second;
        while(b!=0L){
            val value=a%b;
            a=b;
            b=value
        };
        return a
    }
}
