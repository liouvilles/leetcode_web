class Solution {
    fun letterCasePermutation(s:String):List<String>{
        val answer=mutableListOf<String>();
        dfs(s.toCharArray(),0,answer);
        return answer
    };
    private fun dfs(chars:CharArray,index:Int,answer:MutableList<String>){
        if(index==chars.size){
            answer.add(String(chars));
            return
        };
        if(chars[index].isLetter()){
            chars[index]=chars[index].lowercaseChar();
            dfs(chars,index+1,answer);
            chars[index]=chars[index].uppercaseChar();
            dfs(chars,index+1,answer)
        }else dfs(chars,index+1,answer)
    }
}
