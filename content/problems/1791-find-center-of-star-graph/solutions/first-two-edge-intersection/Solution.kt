class Solution {
    fun findCenter(edges:Array<IntArray>):Int=if(edges[0][0]==edges[1][0]||edges[0][0]==edges[1][1])edges[0][0] else edges[0][1]
}
