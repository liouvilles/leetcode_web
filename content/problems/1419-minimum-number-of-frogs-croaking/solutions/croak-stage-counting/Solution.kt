class Solution {
    fun minNumberOfFrogs(croak:String):Int{
        val order="croak";
        val stage=IntArray(5);
        var active=0;
        var answer=0;
        for(value in croak){
            val index=order.indexOf(value);
            if(index<0)return -1;
            if(index==0){
                stage[0]++;
                active++;
                answer=maxOf(answer,active)
            }else{
                if(stage[index-1]==0)return -1;
                stage[index-1]--;
                if(index==4)active-- else stage[index]++
            }
        };
        if((0..3).any{
            stage[it]!=0
        }||active!=0)return -1;
        return answer
    }
}
