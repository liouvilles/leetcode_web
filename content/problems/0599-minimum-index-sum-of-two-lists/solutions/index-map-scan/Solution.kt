class Solution {
    fun findRestaurant(list1:Array<String>,list2:Array<String>):Array<String>{
        val indices=list1.withIndex().associate{
            it.value to it.index
        };
        val answer=mutableListOf<String>();
        var best=Int.MAX_VALUE;
        for((index,name) in list2.withIndex()){
            val first=indices[name]?:continue;
            val sum=first+index;
            if(sum<best){
                best=sum;
                answer.clear();
                answer.add(name)
            }else if(sum==best)answer.add(name)
        };
        return answer.toTypedArray()
    }
}
