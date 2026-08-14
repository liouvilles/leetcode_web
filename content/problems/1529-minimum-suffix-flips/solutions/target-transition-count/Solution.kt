class Solution { fun minFlips(target:String):Int{var current='0';var answer=0;for(value in target)if(value!=current){answer++;current=value};return answer} }
