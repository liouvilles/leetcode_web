class Solution { fun scoreOfString(s:String):Int{var answer=0;for(index in 1 until s.length)answer+=kotlin.math.abs(s[index].code-s[index-1].code);return answer} }
