class Solution { fun minSteps(s:String,t:String):Int{val count=IntArray(26);for(i in s.indices){count[s[i]-'a']++;count[t[i]-'a']--};return count.sumOf{maxOf(0,it)}} }
