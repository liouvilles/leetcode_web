class Solution {
    fun busyStudent(startTime:IntArray,endTime:IntArray,queryTime:Int):Int=startTime.indices.count{
        startTime[it]<=queryTime&&queryTime<=endTime[it]
    }
}
