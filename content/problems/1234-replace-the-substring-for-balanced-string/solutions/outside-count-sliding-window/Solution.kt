class Solution {
    fun balancedString(s:String):Int{
        val count=IntArray(128);
        for(ch in s)count[ch.code]++;
        val target=s.length/4;
        fun valid():Boolean{
            return count['Q'.code]<=target&&count['W'.code]<=target&&count['E'.code]<=target&&count['R'.code]<=target
        };
        if(valid())return 0;
        var left=0;
        var best=s.length;
        for(right in s.indices){
            count[s[right].code]--;
            while(left<=right&&valid()){
                best=minOf(best,right-left+1);
                count[s[left++].code]++
            }
        };
        return best
    }
}
