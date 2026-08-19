class Solution {
    fun queryString(s:String,n:Int):Boolean{
        for(value in n downTo n/2+1)if(!s.contains(value.toString(2)))return false;
        return true
    }
}
