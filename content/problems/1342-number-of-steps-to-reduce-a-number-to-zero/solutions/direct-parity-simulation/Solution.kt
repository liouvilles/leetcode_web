class Solution {
    fun numberOfSteps(numValue:Int):Int{
        var num=numValue;
        var steps=0;
        while(num>0){
            num=if(num%2==0)num/2 else num-1;
            steps++
        };
        return steps
    }
}
