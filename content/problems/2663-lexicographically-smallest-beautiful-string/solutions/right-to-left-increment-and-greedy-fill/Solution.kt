class Solution {
    fun smallestBeautifulString(s:String,k:Int):String{
        val value=s.toCharArray();
        val limit='a'+k;
        fun valid(index:Int,candidate:Char):Boolean{
            return index<1||value[index-1]!=candidate&&(index<2||value[index-2]!=candidate)
        };
        for(index in value.lastIndex downTo 0){
            var candidate=value[index]+1;
            while(candidate<limit){
                if(valid(index,candidate)){
                    value[index]=candidate;
                    for(next in index+1 until value.size){
                        var fill='a';
                        while(fill<limit){
                            if(valid(next,fill)){
                                value[next]=fill;
                                break
                            };
                            fill++
                        }
                    };
                    return String(value)
                };
                candidate++
            }
        };
        return ""
    }
}
