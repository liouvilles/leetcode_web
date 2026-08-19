class Solution {
    fun minCost(startPos:IntArray,homePos:IntArray,rowCosts:IntArray,colCosts:IntArray):Int{
        var answer=0;
        var row=startPos[0];
        var col=startPos[1];
        while(row!=homePos[0]){
            row+=if(row<homePos[0])1 else -1;
            answer+=rowCosts[row]
        };
        while(col!=homePos[1]){
            col+=if(col<homePos[1])1 else -1;
            answer+=colCosts[col]
        };
        return answer
    }
}
