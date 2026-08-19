class Solution {
    fun minMovesToMakePalindrome(s:String):Int{
        val chars=s.toMutableList();
        var left=0;
        var right=chars.lastIndex;
        var moves=0;
        while(left<right){
            var match=right;
            while(match>left&&chars[match]!=chars[left])match--;
            if(match==left){
                val temporary=chars[left];
                chars[left]=chars[left+1];
                chars[left+1]=temporary;
                moves++
            }else{
                while(match<right){
                    val temporary=chars[match];
                    chars[match]=chars[match+1];
                    chars[match+1]=temporary;
                    match++;
                    moves++
                };
                left++;
                right--
            }
        };
        return moves
    }
}
