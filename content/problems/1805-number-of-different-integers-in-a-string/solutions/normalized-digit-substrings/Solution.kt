class Solution {
    fun numDifferentIntegers(word:String):Int{
        val values=mutableSetOf<String>();
        var position=0;
        while(position<word.length){
            if(!word[position].isDigit()){
                position++;
                continue
            };
            var end=position;
            while(end<word.length&&word[end].isDigit())end++;
            while(position<end&&word[position]=='0')position++;
            values.add(if(position==end)"0" else word.substring(position,end));
            position=end
        };
        return values.size
    }
}
