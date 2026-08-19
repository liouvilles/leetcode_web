class Solution {
    fun getSmallestString(n:Int,k:Int):String{
        val letters=CharArray(n){
            'a'
        };
        var remaining=k-n;
        for(index in n-1 downTo 0){
            val add=minOf(25,remaining);
            letters[index]=(letters[index].code+add).toChar();
            remaining-=add
        };
        return String(letters)
    }
}
