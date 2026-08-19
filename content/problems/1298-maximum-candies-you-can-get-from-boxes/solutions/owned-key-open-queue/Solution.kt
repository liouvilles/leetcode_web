class Solution {
    fun maxCandies(status:IntArray,candies:IntArray,keys:Array<IntArray>,containedBoxes:Array<IntArray>,initialBoxes:IntArray):Int{
        val n=status.size;
        val owned=BooleanArray(n);
        val hasKey=BooleanArray(n);
        val opened=BooleanArray(n);
        val queue=java.util.ArrayDeque<Int>();
        for(box in initialBoxes){
            owned[box]=true;
            queue.addLast(box)
        };
        var total=0;
        while(queue.isNotEmpty()){
            val box=queue.removeFirst();
            if(opened[box]||!owned[box]||status[box]==0&&!hasKey[box])continue;
            opened[box]=true;
            total+=candies[box];
            for(key in keys[box]){
                hasKey[key]=true;
                if(owned[key])queue.addLast(key)
            };
            for(child in containedBoxes[box]){
                owned[child]=true;
                queue.addLast(child)
            }
        };
        return total
    }
}
