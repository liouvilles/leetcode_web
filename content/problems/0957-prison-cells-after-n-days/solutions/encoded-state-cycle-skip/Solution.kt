class Solution {
    fun prisonAfterNDays(cellsInput:IntArray,nInput:Int):IntArray{
        var cells=cellsInput;
        var remaining=nInput;
        val seen=mutableMapOf<Int,Int>();
        fun encode():Int{
            var state=0;
            for(bit in cells)state=state*2+bit;
            return state
        };
        while(remaining>0){
            val state=encode();
            if(state in seen)remaining%=seen[state]!!-remaining else seen[state]=remaining;
            if(remaining>0){
                remaining--;
                val next=IntArray(8);
                for(i in 1..6)next[i]=if(cells[i-1]==cells[i+1])1 else 0;
                cells=next
            }
        };
        return cells
    }
}
