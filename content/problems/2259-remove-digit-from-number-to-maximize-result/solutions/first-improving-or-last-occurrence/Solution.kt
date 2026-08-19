class Solution {
    fun removeDigit(number:String,digit:Char):String{
        var remove=number.lastIndexOf(digit);
        for(i in 0 until number.lastIndex)if(number[i]==digit&&number[i+1]>digit){
            remove=i;
            break
        };
        return number.removeRange(remove,remove+1)
    }
}
