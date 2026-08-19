class Solution {
    fun isValid(word:String):Boolean{
        if(word.length<3)return false;
        var hasVowel=false;
        var hasConsonant=false;
        for(character in word){
            val lower=character in 'a'..'z';
            val upper=character in 'A'..'Z';
            val digit=character in '0'..'9';
            if(!lower&&!upper&&!digit)return false;
            if(lower||upper){
                val letter=character.lowercaseChar();
                if(letter in "aeiou")hasVowel=true else hasConsonant=true
            }
        };
        return hasVowel&&hasConsonant
    }
}
