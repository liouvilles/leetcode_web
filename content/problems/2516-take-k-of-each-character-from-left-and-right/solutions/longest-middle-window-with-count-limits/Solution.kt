class Solution {
    fun takeCharacters(s:String,k:Int):Int{
        val total=IntArray(3);
        for(character in s)total[character-'a']++;
        if(total.any{
            it<k
        })return -1;
        val window=IntArray(3);
        var left=0;
        var maximum=0;
        for(right in s.indices){
            val index=s[right]-'a';
            window[index]++;
            while(window[index]>total[index]-k)window[s[left++]-'a']--;
            maximum=maxOf(maximum,right-left+1)
        };
        return s.length-maximum
    }
}
