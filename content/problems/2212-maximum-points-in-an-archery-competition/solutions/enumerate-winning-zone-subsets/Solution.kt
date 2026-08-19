class Solution {
    fun maximumBobPoints(numArrows:Int,aliceArrows:IntArray):IntArray{
        var best=-1;
        var answer=IntArray(12);
        for(mask in 0 until (1 shl 12)){
            var required=0;
            var score=0;
            for(i in 0 until 12)if(mask and (1 shl i)!=0){
                required+=aliceArrows[i]+1;
                score+=i
            };
            if(required<=numArrows&&score>best){
                best=score;
                answer=IntArray(12);
                for(i in 0 until 12)if(mask and (1 shl i)!=0)answer[i]=aliceArrows[i]+1;
                answer[0]+=numArrows-required
            }
        };
        return answer
    }
}
