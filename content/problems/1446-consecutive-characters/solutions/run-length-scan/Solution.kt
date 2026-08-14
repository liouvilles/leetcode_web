class Solution { fun maxPower(text:String):Int{var current=1;var answer=1;for(i in 1 until text.length){current=if(text[i]==text[i-1])current+1 else 1;answer=maxOf(answer,current)};return answer} }
