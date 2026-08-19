class Solution {
    fun halvesAreAlike(text:String):Boolean{
        val vowels="aeiouAEIOU";
        var difference=0;
        for(i in text.indices)if(text[i] in vowels)difference+=if(i<text.length/2)1 else -1;
        return difference==0
    }
}
