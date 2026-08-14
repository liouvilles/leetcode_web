class Solution { fun haveConflict(event1:Array<String>,event2:Array<String>):Boolean{return maxOf(event1[0],event2[0])<=minOf(event1[1],event2[1])} }
