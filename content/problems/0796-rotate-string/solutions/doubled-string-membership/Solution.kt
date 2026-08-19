class Solution {
    fun rotateString(s:String,goal:String):Boolean=s.length==goal.length&&(s+s).contains(goal)
}
