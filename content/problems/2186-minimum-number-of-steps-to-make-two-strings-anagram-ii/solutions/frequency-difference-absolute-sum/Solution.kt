class Solution { fun minSteps(s:String,t:String):Int{val difference=IntArray(26);for(ch in s)difference[ch-'a']++;for(ch in t)difference[ch-'a']--;return difference.sumOf{kotlin.math.abs(it)}} }
