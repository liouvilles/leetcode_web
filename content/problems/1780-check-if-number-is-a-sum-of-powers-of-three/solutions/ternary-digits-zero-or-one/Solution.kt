class Solution {
    fun checkPowersOfThree(nValue:Int):Boolean{
        var n=nValue;
        while(n>0){
            if(n%3==2)return false;
            n/=3
        };
        return true
    }
}
