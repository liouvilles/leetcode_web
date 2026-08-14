class Solution { fun detectCapitalUse(word:String):Boolean{val uppercase=word.count{it.isUpperCase()};return uppercase==0||uppercase==word.length||(uppercase==1&&word[0].isUpperCase())} }
