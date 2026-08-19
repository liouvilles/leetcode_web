class Solution { fun minimumPushes(word:String):Int{val full=word.length/8;val remaining=word.length%8;return 8*full*(full+1)/2+(full+1)*remaining} }
