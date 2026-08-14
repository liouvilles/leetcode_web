class Solution { fun secondsToRemoveOccurrences(s:String):Int{var zeros=0;var answer=0;for(ch in s)if(ch=='0')zeros++ else if(zeros>0)answer=maxOf(zeros,answer+1);return answer} }
