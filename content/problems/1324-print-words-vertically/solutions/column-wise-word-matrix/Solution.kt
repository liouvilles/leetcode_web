class Solution {
    fun printVertically(s:String):List<String>{
        val words=s.split(' ');
        val maximum=words.maxOf{
            it.length
        };
        return (0 until maximum).map{
            column->val line=StringBuilder();
            for(word in words)line.append(if(column<word.length)word[column] else ' ');
            while(line.isNotEmpty()&&line.last()==' ')line.deleteCharAt(line.lastIndex);
            line.toString()
        }
    }
}
