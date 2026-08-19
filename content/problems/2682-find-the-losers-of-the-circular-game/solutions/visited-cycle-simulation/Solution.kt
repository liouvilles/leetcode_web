class Solution {
    fun circularGameLosers(n:Int,k:Int):IntArray{
        val visited=BooleanArray(n);
        var current=0;
        var round=1;
        while(!visited[current]){
            visited[current]=true;
            current=(current+round*k)%n;
            round++
        };
        return (0 until n).filter{
            !visited[it]
        }.map{
            it+1
        }.toIntArray()
    }
}
