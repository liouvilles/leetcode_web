class Solution {
    private fun add(difference:LongArray,left:Int,right:Int,value:Long){
        if(left>right)return;
        difference[left]+=value;
        difference[right+1]-=value
    }
    private fun addTailToCycle(difference:LongArray,tail:Int,cycle:Int){
        if(tail==0)return;
        add(difference,1,tail,1);
        var distance=1;
        while(2*distance<cycle){
            add(difference,distance+1,distance+tail,2);
            distance++
        };
        if(cycle%2==0)add(difference,cycle/2+1,cycle/2+tail,1)
    }
    fun countOfPairs(n:Int,xValue:Int,yValue:Int):LongArray{
        var x=xValue;
        var y=yValue;
        if(x>y){
            val value=x;
            x=y;
            y=value
        };
        val answer=LongArray(n);
        if(y-x<=1){
            for(distance in 1 until n)answer[distance-1]=2L*(n-distance);
            return answer
        };
        val leftTail=x-1;
        val rightTail=n-y;
        val cycle=y-x+1;
        val difference=LongArray(n+2);
        for(distance in 1 until leftTail)add(difference,distance,distance,(leftTail-distance).toLong());
        for(distance in 1 until rightTail)add(difference,distance,distance,(rightTail-distance).toLong());
        var distance=1;
        while(2*distance<cycle){
            add(difference,distance,distance,cycle.toLong());
            distance++
        };
        if(cycle%2==0)add(difference,cycle/2,cycle/2,(cycle/2).toLong());
        addTailToCycle(difference,leftTail,cycle);
        addTailToCycle(difference,rightTail,cycle);
        if(rightTail>0)for(depth in 1..leftTail)add(difference,depth+2,depth+rightTail+1,1);
        var current=0L;
        for(value in 1..n){
            current+=difference[value];
            answer[value-1]=2*current
        };
        return answer
    }
}
