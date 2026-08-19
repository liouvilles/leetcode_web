class Solution {
    fun checkIfCanBreak(s1:String,s2:String):Boolean{
        val first=s1.toCharArray().sortedArray();
        val second=s2.toCharArray().sortedArray();
        var firstBreaks=true;
        var secondBreaks=true;
        for(i in first.indices){
            if(first[i]<second[i])firstBreaks=false;
            if(first[i]>second[i])secondBreaks=false
        };
        return firstBreaks||secondBreaks
    }
}
