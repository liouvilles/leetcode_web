class Solution { fun maximumValue(strs:Array<String>):Int{var answer=0;for(word in strs){val value=if(word.all{it.isDigit()})word.toInt()else word.length;answer=maxOf(answer,value)};return answer} }
