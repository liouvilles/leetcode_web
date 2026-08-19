class Solution {
    fun escapeGhosts(ghosts:Array<IntArray>,target:IntArray):Boolean{
        val player=kotlin.math.abs(target[0])+kotlin.math.abs(target[1]);
        for(ghost in ghosts)if(kotlin.math.abs(ghost[0]-target[0])+kotlin.math.abs(ghost[1]-target[1])<=player)return false;
        return true
    }
}
