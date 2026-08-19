class Solution {
    fun splitMessage(message:String,limit:Int):Array<String>{
        var prefixDigits=0;
        var totalParts=-1;
        for(parts in 1..message.length){
            prefixDigits+=parts.toString().length;
            val digits=parts.toString().length;
            val capacity=parts.toLong()*limit-prefixDigits-parts.toLong()*(3+digits);
            if(limit>3+2*digits&&capacity>=message.length){
                totalParts=parts;
                break
            }
        };
        if(totalParts==-1)return emptyArray();
        var index=0;
        return Array(totalParts){
            position->val part=position+1;
            val suffix="<${part}/${totalParts}>";
            val take=minOf(limit-suffix.length,message.length-index);
            val result=message.substring(index,index+take)+suffix;
            index+=take;
            result
        }
    }
}
