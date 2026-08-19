class Solution {
    fun evaluate(expression:String):Int=eval(expression,emptyMap());
    private fun eval(expression:String,environment:Map<String,Int>):Int{
        if(expression[0]!='(')return expression.toIntOrNull()?:environment[expression]!!;
        val tokens=split(expression.substring(1,expression.lastIndex));
        return when(tokens[0]){
            "add"->eval(tokens[1],environment)+eval(tokens[2],environment);
            "mult"->eval(tokens[1],environment)*eval(tokens[2],environment);
            else->{
                val local=environment.toMutableMap();
                var index=1;
                while(index<tokens.lastIndex){
                    local[tokens[index]]=eval(tokens[index+1],local);
                    index+=2
                };
                eval(tokens.last(),local)
            }
        }
    };
    private fun split(value:String):List<String>{
        val tokens=mutableListOf<String>();
        var depth=0;
        var start=0;
        for(i in 0..value.length){
            if(i==value.length||value[i]==' '&&depth==0){
                tokens.add(value.substring(start,i));
                start=i+1
            }else if(value[i]=='(')depth++ else if(value[i]==')')depth--
        };
        return tokens
    }
}
