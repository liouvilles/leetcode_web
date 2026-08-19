class Solution {
    fun videoStitching(clips:Array<IntArray>,time:Int):Int{
        clips.sortBy{
            it[0]
        };
        var index=0;
        var currentEnd=0;
        var used=0;
        while(currentEnd<time){
            var farthest=currentEnd;
            while(index<clips.size&&clips[index][0]<=currentEnd)farthest=maxOf(farthest,clips[index++][1]);
            if(farthest==currentEnd)return -1;
            currentEnd=farthest;
            used++
        };
        return used
    }
}
