class Solution {
    fun kthDistinct(arr:Array<String>,kValue:Int):String{
        val frequency=arr.groupingBy{
            it
        }.eachCount();
        var k=kValue;
        for(value in arr)if(frequency[value]==1&&--k==0)return value;
        return ""
    }
}
