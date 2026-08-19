class Solution {
    fun isCovered(ranges:Array<IntArray>,left:Int,right:Int):Boolean{
        val difference=IntArray(52);
        for(range in ranges){
            difference[range[0]]++;
            difference[range[1]+1]--
        };
        var coverage=0;
        for(value in 1..right){
            coverage+=difference[value];
            if(value>=left&&coverage==0)return false
        };
        return true
    }
}
