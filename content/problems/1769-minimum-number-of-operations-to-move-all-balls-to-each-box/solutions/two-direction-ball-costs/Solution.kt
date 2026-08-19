class Solution {
    fun minOperations(boxes:String):IntArray{
        val answer=IntArray(boxes.length);
        var balls=0;
        var cost=0;
        for(i in boxes.indices){
            answer[i]+=cost;
            if(boxes[i]=='1')balls++;
            cost+=balls
        };
        balls=0;
        cost=0;
        for(i in boxes.lastIndex downTo 0){
            answer[i]+=cost;
            if(boxes[i]=='1')balls++;
            cost+=balls
        };
        return answer
    }
}
