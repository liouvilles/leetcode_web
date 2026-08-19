class Solution {
    fun checkIfExist(arr:IntArray):Boolean{
        val seen=mutableSetOf<Int>();
        for(value in arr){
            if(value*2 in seen||value%2==0&&value/2 in seen)return true;
            seen.add(value)
        };
        return false
    }
}
