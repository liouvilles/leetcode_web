class Solution {
    fun hasAllCodes(text:String,k:Int):Boolean{
        val needed=1 shl k;
        if(text.length-k+1<needed)return false;
        val seen=BooleanArray(needed);
        val mask=needed-1;
        var value=0;
        var count=0;
        for(i in text.indices){
            value=((value shl 1)or(text[i]-'0'))and mask;
            if(i>=k-1&&!seen[value]){
                seen[value]=true;
                count++;
                if(count==needed)return true
            }
        };
        return false
    }
}
