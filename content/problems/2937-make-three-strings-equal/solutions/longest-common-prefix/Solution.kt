class Solution {
    fun findMinimumOperations(s1:String,s2:String,s3:String):Int{
        val limit=minOf(s1.length,s2.length,s3.length);
        var prefix=0;
        while(prefix<limit&&s1[prefix]==s2[prefix]&&s1[prefix]==s3[prefix])prefix++;
        return if(prefix==0)-1 else s1.length+s2.length+s3.length-3*prefix
    }
}
