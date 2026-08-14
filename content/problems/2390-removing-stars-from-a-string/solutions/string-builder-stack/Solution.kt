class Solution { fun removeStars(s:String):String{val answer=StringBuilder();for(ch in s)if(ch=='*')answer.setLength(answer.length-1)else answer.append(ch);return answer.toString()} }
