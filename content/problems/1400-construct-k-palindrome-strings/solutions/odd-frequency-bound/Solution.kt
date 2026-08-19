class Solution {
    fun canConstruct(text:String,k:Int):Boolean{
        if(text.length<k)return false;
        val count=IntArray(26);
        for(value in text)count[value-'a']++;
        return count.count{
            it%2==1
        }<=k
    }
}
