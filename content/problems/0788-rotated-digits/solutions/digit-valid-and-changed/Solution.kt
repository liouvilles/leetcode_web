class Solution {
    fun rotatedDigits(n:Int):Int{
        var answer=0;
        for(value in 1..n){
            var current=value;
            var valid=true;
            var changed=false;
            while(current>0){
                val digit=current%10;
                current/=10;
                if(digit==3||digit==4||digit==7){
                    valid=false;
                    break
                };
                if(digit==2||digit==5||digit==6||digit==9)changed=true
            };
            if(valid&&changed)answer++
        };
        return answer
    }
}
