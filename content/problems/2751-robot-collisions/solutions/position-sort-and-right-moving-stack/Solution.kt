class Solution {
    fun survivedRobotsHealths(positions:IntArray,healths:IntArray,directions:String):List<Int>{
        val order=Array(positions.size){
            it
        };
        order.sortWith(Comparator{
            a,b->positions[a].compareTo(positions[b])
        });
        val stack=java.util.ArrayDeque<Int>();
        for(robot in order){
            if(directions[robot]=='R'){
                stack.addLast(robot);
                continue
            };
            while(healths[robot]>0&&!stack.isEmpty()){
                val right=stack.peekLast();
                if(healths[right]<healths[robot]){
                    healths[right]=0;
                    stack.pollLast();
                    healths[robot]--
                }else if(healths[right]==healths[robot]){
                    healths[right]=0;
                    healths[robot]=0;
                    stack.pollLast()
                }else{
                    healths[right]--;
                    healths[robot]=0
                }
            }
        };
        return healths.filter{
            it>0
        }
    }
}
