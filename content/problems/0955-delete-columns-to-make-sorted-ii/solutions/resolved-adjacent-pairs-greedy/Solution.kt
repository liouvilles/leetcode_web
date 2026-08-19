class Solution {
    fun minDeletionSize(strs:Array<String>):Int{
        val resolved=BooleanArray(strs.size);
        var deleted=0;
        for(col in strs[0].indices){
            var invalid=false;
            for(row in 1 until strs.size)if(!resolved[row]&&strs[row-1][col]>strs[row][col]){
                invalid=true;
                break
            };
            if(invalid){
                deleted++;
                continue
            };
            for(row in 1 until strs.size)if(strs[row-1][col]<strs[row][col])resolved[row]=true
        };
        return deleted
    }
}
