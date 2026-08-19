class Solution {
    fun shortestBeautifulSubstring(s:String,k:Int):String{
        var left=0;
        var ones=0;
        var answer="";
        for(right in s.indices){
            if(s[right]=='1')ones++;
            while(left<=right&&(s[left]=='0'||ones>k)){
                if(s[left++]=='1')ones--
            };
            if(ones==k){
                val candidate=s.substring(left,right+1);
                if(answer.isEmpty()||candidate.length<answer.length||candidate.length==answer.length&&candidate<answer)answer=candidate
            }
        };
        return answer
    }
}
