class Solution {
    fun sumOfMultiples(n:Int):Int{
        var answer=0;
        for(value in 1..n)if(value%3==0||value%5==0||value%7==0)answer+=value;
        return answer
    }
}
