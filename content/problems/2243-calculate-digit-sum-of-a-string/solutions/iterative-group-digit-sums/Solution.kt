class Solution {
    fun digitSum(sValue:String,k:Int):String{
        var s=sValue;
        while(s.length>k){
            val next=StringBuilder();
            for(start in s.indices step k){
                var sum=0;
                for(i in start until minOf(start+k,s.length))sum+=s[i]-'0';
                next.append(sum)
            };
            s=next.toString()
        };
        return s
    }
}
