class Solution {
    fun percentageLetter(s:String,letter:Char)=s.count{
        it==letter
    }*100/s.length
}
