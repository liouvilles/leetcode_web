class Solution {
    fun getCollisionTimes(cars:Array<IntArray>):DoubleArray{
        val answer=DoubleArray(cars.size){
            -1.0
        };
        val stack=java.util.ArrayDeque<Int>();
        for(i in cars.lastIndex downTo 0){
            while(stack.isNotEmpty()){
                val next=stack.last;
                if(cars[i][1]<=cars[next][1]){
                    stack.removeLast();
                    continue
                };
                val time=(cars[next][0]-cars[i][0]).toDouble()/(cars[i][1]-cars[next][1]);
                if(answer[next]<0||time<=answer[next]){
                    answer[i]=time;
                    break
                };
                stack.removeLast()
            };
            stack.addLast(i)
        };
        return answer
    }
}
