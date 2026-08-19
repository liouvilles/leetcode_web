class Solution {
    fun shiftingLetters(s:String,shifts:IntArray):String{
        val chars=s.toCharArray();
        var shift=0L;
        for(i in chars.indices.reversed()){
            shift=(shift+shifts[i])%26;
            chars[i]=('a'.code+(chars[i]-'a'+shift).toInt()%26).toChar()
        };
        return String(chars)
    }
}
