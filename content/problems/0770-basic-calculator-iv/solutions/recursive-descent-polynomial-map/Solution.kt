class Solution {
    private lateinit var text:String;
    private var index=0;
    private lateinit var values:Map<String,Int>;
    fun basicCalculatorIV(expression:String,evalvars:Array<String>,evalints:IntArray):List<String>{
        text=expression;
        index=0;
        values=evalvars.indices.associate{
            evalvars[it] to evalints[it]
        };
        val polynomial=parseExpression();
        return polynomial.filterValues{
            it!=0
        }.keys.sortedWith(compareByDescending<String>{
            degree(it)
        }.thenBy{
            it
        }).map{
            key->polynomial[key].toString()+if(key.isEmpty())"" else "*"+key
        }
    };
    private fun parseExpression():MutableMap<String,Int>{
        var result=parseTerm();
        while(true){
            skip();
            if(index>=text.length||(text[index]!='+'&&text[index]!='-'))return result;
            val operation=text[index++];
            result=add(result,parseTerm(),if(operation=='+')1 else -1)
        }
    };
    private fun parseTerm():MutableMap<String,Int>{
        var result=parseFactor();
        while(true){
            skip();
            if(index>=text.length||text[index]!='*')return result;
            index++;
            result=multiply(result,parseFactor())
        }
    };
    private fun parseFactor():MutableMap<String,Int>{
        skip();
        if(text[index]=='('){
            index++;
            val result=parseExpression();
            skip();
            index++;
            return result
        };
        val start=index;
        if(text[index].isDigit()){
            while(index<text.length&&text[index].isDigit())index++;
            return single("",text.substring(start,index).toInt())
        };
        while(index<text.length&&text[index].isLetter())index++;
        val variable=text.substring(start,index);
        return if(values.containsKey(variable))single("",values[variable]!!) else single(variable,1)
    };
    private fun skip(){
        while(index<text.length&&text[index]==' ')index++
    };
    private fun single(key:String,coefficient:Int)=mutableMapOf(key to coefficient);
    private fun add(a:Map<String,Int>,b:Map<String,Int>,sign:Int):MutableMap<String,Int>{
        val result=a.toMutableMap();
        for((key,value)in b)result[key]=(result[key]?:0)+sign*value;
        return result
    };
    private fun multiply(a:Map<String,Int>,b:Map<String,Int>):MutableMap<String,Int>{
        val result=mutableMapOf<String,Int>();
        for((x,cx)in a)for((y,cy)in b){
            val key=mergeKey(x,y);
            result[key]=(result[key]?:0)+cx*cy
        };
        return result
    };
    private fun mergeKey(a:String,b:String)=(a.split('*').filter{
        it.isNotEmpty()
    }+b.split('*').filter{
        it.isNotEmpty()
    }).sorted().joinToString("*");
    private fun degree(key:String)=if(key.isEmpty())0 else key.count{
        it=='*'
    }+1
}
