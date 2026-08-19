class Solution {
    fun findTheLongestBalancedSubstring(s:String):Int{
        var index=0;
        var answer=0;
        while(index<s.length){
            var zeros=0;
            var ones=0;
            while(index<s.length&&s[index]=='0'){
                zeros++;
                index++
            };
            while(index<s.length&&s[index]=='1'){
                ones++;
                index++
            };
            answer=maxOf(answer,2*minOf(zeros,ones))
        };
        return answer
    }
}
