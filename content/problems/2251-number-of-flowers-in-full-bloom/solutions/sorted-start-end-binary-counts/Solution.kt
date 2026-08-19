class Solution {
    private fun lower(values:IntArray,target:Int):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right)/2;
            if(values[middle]<target)left=middle+1 else right=middle
        };
        return left
    };
    private fun upper(values:IntArray,target:Int):Int{
        var left=0;
        var right=values.size;
        while(left<right){
            val middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1 else right=middle
        };
        return left
    };
    fun fullBloomFlowers(flowers:Array<IntArray>,people:IntArray):IntArray{
        val starts=IntArray(flowers.size){
            flowers[it][0]
        };
        val ends=IntArray(flowers.size){
            flowers[it][1]
        };
        starts.sort();
        ends.sort();
        return IntArray(people.size){
            upper(starts,people[it])-lower(ends,people[it])
        }
    }
}
