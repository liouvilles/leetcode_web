class Solution {
    fun repeatedStringMatch(a:String,b:String):Int{
        val builder=StringBuilder();
        var repeats=0;
        while(builder.length<b.length){
            builder.append(a);
            repeats++
        };
        if(builder.indexOf(b)>=0)return repeats;
        builder.append(a);
        return if(builder.indexOf(b)>=0)repeats+1 else -1
    }
}
