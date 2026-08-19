class Solution {
    fun sumZero(n:Int):IntArray{
        val answer=IntArray(n);
        var write=0;
        for(value in 1..n/2){
            answer[write++]=value;
            answer[write++]=-value
        };
        if(n%2==1)answer[write]=0;
        return answer
    }
}
