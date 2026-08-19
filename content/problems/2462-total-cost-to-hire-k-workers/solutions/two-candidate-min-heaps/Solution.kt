class Solution {
    fun totalCost(costs:IntArray,kValue:Int,candidates:Int):Long{
        val order=compareBy<IntArray>{
            it[0]
        }.thenBy{
            it[1]
        };
        val leftHeap=java.util.PriorityQueue(order);
        val rightHeap=java.util.PriorityQueue(order);
        var left=0;
        var right=costs.lastIndex;
        while(left<=right&&leftHeap.size<candidates){
            leftHeap.offer(intArrayOf(costs[left],left));
            left++
        };
        while(left<=right&&rightHeap.size<candidates){
            rightHeap.offer(intArrayOf(costs[right],right));
            right--
        };
        var k=kValue;
        var answer=0L;
        while(k-->0){
            val takeLeft=rightHeap.isEmpty()||leftHeap.isNotEmpty()&&order.compare(leftHeap.peek(),rightHeap.peek())<=0;
            val chosen=if(takeLeft)leftHeap.poll()else rightHeap.poll();
            answer+=chosen[0];
            if(left<=right){
                if(takeLeft){
                    leftHeap.offer(intArrayOf(costs[left],left));
                    left++
                }else{
                    rightHeap.offer(intArrayOf(costs[right],right));
                    right--
                }
            }
        };
        return answer
    }
}
