class Solution { fun countGoodSubstrings(s:String):Int{var answer=0;for(i in 0..s.length-3)if(s[i]!=s[i+1]&&s[i]!=s[i+2]&&s[i+1]!=s[i+2])answer++;return answer} }
