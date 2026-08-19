class Solution {
    fun reinitializePermutation(n:Int):Int{
        var position=1;
        var operations=0;
        do{
            position=if(position%2==0)position/2 else n/2+(position-1)/2;
            operations++
        }while(position!=1);
        return operations
    }
}
