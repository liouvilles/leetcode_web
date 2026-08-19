class Solution {
    fun isTransformable(s:String,t:String):Boolean{
        val positions=Array(10){
            java.util.ArrayDeque<Int>()
        };
        for(i in s.indices)positions[s[i]-'0'].addLast(i);
        for(value in t){
            val digit=value-'0';
            if(positions[digit].isEmpty())return false;
            val position=positions[digit].peekFirst();
            for(smaller in 0 until digit)if(positions[smaller].isNotEmpty()&&positions[smaller].peekFirst()<position)return false;
            positions[digit].removeFirst()
        };
        return true
    }
}
