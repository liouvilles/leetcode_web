class Solution { fun countVowelStrings(n:Int):Int{val dp=IntArray(5){1};for(length in 2..n)for(vowel in 1 until 5)dp[vowel]+=dp[vowel-1];return dp.sum()} }
