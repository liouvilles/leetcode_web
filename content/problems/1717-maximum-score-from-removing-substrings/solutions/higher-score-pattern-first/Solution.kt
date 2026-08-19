class Solution {
    private fun remove(text:String,first:Char,second:Char):Pair<String,Int>{
        val stack=StringBuilder();
        var count=0;
        for(letter in text)if(letter==second&&stack.isNotEmpty()&&stack.last()==first){
            stack.deleteCharAt(stack.lastIndex);
            count++
        }else stack.append(letter);
        return stack.toString() to count
    };
    fun maximumGain(text:String,x:Int,y:Int):Int{
        if(x>=y){
            val high=remove(text,'a','b');
            val low=remove(high.first,'b','a');
            return high.second*x+low.second*y
        };
        val high=remove(text,'b','a');
        val low=remove(high.first,'a','b');
        return high.second*y+low.second*x
    }
}
