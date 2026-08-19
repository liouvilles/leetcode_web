class Solution {
    fun pushDominoes(dominoes:String):String{
        val n=dominoes.length;
        val forces=IntArray(n);
        var force=0;
        for(i in 0 until n){
            force=when(dominoes[i]){
                'R'->n;
                'L'->0;
                else->maxOf(force-1,0)
            };
            forces[i]+=force
        };
        force=0;
        for(i in n-1 downTo 0){
            force=when(dominoes[i]){
                'L'->n;
                'R'->0;
                else->maxOf(force-1,0)
            };
            forces[i]-=force
        };
        return buildString{
            for(value in forces)append(if(value>0)'R' else if(value<0)'L' else '.')
        }
    }
}
