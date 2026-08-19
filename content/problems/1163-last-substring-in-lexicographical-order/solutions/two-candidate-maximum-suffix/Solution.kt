class Solution {
    fun lastSubstring(s:String):String{
        val n=s.length;
        var i=0;
        var j=1;
        var k=0;
        while(j+k<n){
            val first=s[i+k];
            val second=s[j+k];
            if(first==second)k++ else if(first<second){
                i=maxOf(i+k+1,j);
                j=i+1;
                k=0
            }else{
                j+=k+1;
                k=0
            }
        };
        return s.substring(i)
    }
}
