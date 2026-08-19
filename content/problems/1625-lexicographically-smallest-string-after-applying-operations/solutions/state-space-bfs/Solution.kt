class Solution {
    fun findLexSmallestString(text:String,a:Int,b:Int):String{
        val queue=java.util.ArrayDeque<String>();
        val seen=mutableSetOf(text);
        queue.add(text);
        var answer=text;
        while(queue.isNotEmpty()){
            val current=queue.removeFirst();
            if(current<answer)answer=current;
            val digits=current.toCharArray();
            for(i in 1 until digits.size step 2)digits[i]=('0'.code+(digits[i]-'0'+a)%10).toChar();
            val added=String(digits);
            val shift=b%current.length;
            val rotated=current.takeLast(shift)+current.dropLast(shift);
            if(seen.add(added))queue.addLast(added);
            if(seen.add(rotated))queue.addLast(rotated)
        };
        return answer
    }
}
