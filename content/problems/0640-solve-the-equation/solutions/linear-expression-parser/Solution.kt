class Solution {
    fun solveEquation(equation:String):String{
        val sides=equation.split('=');
        val left=parse(sides[0]);
        val right=parse(sides[1]);
        val coefficient=left[0]-right[0];
        val constant=right[1]-left[1];
        return if(coefficient==0){
            if(constant==0)"Infinite solutions" else "No solution"
        }else "x="+(constant/coefficient)
    };
    private fun parse(expression:String):IntArray{
        var coefficient=0;
        var constant=0;
        var index=0;
        var sign=1;
        while(index<expression.length){
            if(expression[index]=='+'||expression[index]=='-')sign=if(expression[index++]=='-')-1 else 1;
            val start=index;
            var value=0;
            while(index<expression.length&&expression[index].isDigit())value=value*10+(expression[index++]-'0');
            if(index<expression.length&&expression[index]=='x'){
                coefficient+=sign*(if(index==start)1 else value);
                index++
            }else constant+=sign*value
        };
        return intArrayOf(coefficient,constant)
    }
}
