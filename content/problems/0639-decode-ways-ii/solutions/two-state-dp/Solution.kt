class Solution {
    fun numDecodings(s:String):Int{
        val mod=1000000007L;
        var previousTwo=1L;
        var previousOne=single(s[0]).toLong();
        for(i in 1 until s.length){
            val current=(single(s[i])*previousOne+pair(s[i-1],s[i])*previousTwo)%mod;
            previousTwo=previousOne;
            previousOne=current
        };
        return previousOne.toInt()
    };
    private fun single(c:Char)=if(c=='*')9 else if(c=='0')0 else 1;
    private fun pair(a:Char,b:Char):Int=if(a=='*'){
        if(b=='*')15 else if(b<='6')2 else 1
    }else if(a=='1'){
        if(b=='*')9 else 1
    }else if(a=='2'){
        if(b=='*')6 else if(b<='6')1 else 0
    }else 0
}
