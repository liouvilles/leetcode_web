class Solution {
    fun canThreePartsEqualSum(arr:IntArray):Boolean{
        val total=arr.sum();
        if(total%3!=0)return false;
        val target=total/3;
        var running=0;
        var parts=0;
        for(i in 0 until arr.lastIndex){
            running+=arr[i];
            if(running==target){
                running=0;
                parts++;
                if(parts==2)return true
            }
        };
        return false
    }
}
