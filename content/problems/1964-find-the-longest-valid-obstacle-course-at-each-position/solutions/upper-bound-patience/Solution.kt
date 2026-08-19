class Solution {
    fun longestObstacleCourseAtEachPosition(obstacles:IntArray):IntArray{
        val tails=IntArray(obstacles.size);
        val answer=IntArray(obstacles.size);
        var size=0;
        for(i in obstacles.indices){
            var left=0;
            var right=size;
            while(left<right){
                val middle=(left+right)/2;
                if(tails[middle]<=obstacles[i])left=middle+1 else right=middle
            };
            tails[left]=obstacles[i];
            if(left==size)size++;
            answer[i]=left+1
        };
        return answer
    }
}
