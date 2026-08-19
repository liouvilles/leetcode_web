class Solution {
    fun canFormArray(arr:IntArray,pieces:Array<IntArray>):Boolean{
        val byFirst=pieces.associateBy{
            it[0]
        };
        var index=0;
        while(index<arr.size){
            val piece=byFirst[arr[index]]?:return false;
            for(value in piece)if(index>=arr.size||arr[index++]!=value)return false
        };
        return true
    }
}
