class Solution {
    fun makeLargestSpecial(s:String):String{
        val blocks=mutableListOf<String>();
        var balance=0;
        var start=0;
        for(i in s.indices){
            balance+=if(s[i]=='1')1 else -1;
            if(balance==0){
                blocks.add("1"+makeLargestSpecial(s.substring(start+1,i))+"0");
                start=i+1
            }
        };
        return blocks.sortedDescending().joinToString("")
    }
}
