class Solution {
    fun matchReplacement(s:String,sub:String,mappings:Array<CharArray>):Boolean{
        val allowed=Array(128){
            BooleanArray(128)
        };
        for(mapping in mappings)allowed[mapping[0].code][mapping[1].code]=true;
        for(start in 0..s.length-sub.length){
            var matches=true;
            for(j in sub.indices){
                val from=sub[j];
                val to=s[start+j];
                if(from!=to&&!allowed[from.code][to.code]){
                    matches=false;
                    break
                }
            };
            if(matches)return true
        };
        return false
    }
}
