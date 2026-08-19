class Solution {
    fun expressiveWords(s:String,words:Array<String>):Int=words.count{
        stretchy(s,it)
    };
    private fun stretchy(target:String,word:String):Boolean{
        var i=0;
        var j=0;
        while(i<target.length&&j<word.length){
            if(target[i]!=word[j])return false;
            var nextI=i+1;
            var nextJ=j+1;
            while(nextI<target.length&&target[nextI]==target[i])nextI++;
            while(nextJ<word.length&&word[nextJ]==word[j])nextJ++;
            val a=nextI-i;
            val b=nextJ-j;
            if(b>a||a!=b&&a<3)return false;
            i=nextI;
            j=nextJ
        };
        return i==target.length&&j==word.length
    }
}
