class Solution {
    private lateinit var child:Array<IntArray>;
    private lateinit var count:IntArray;
    private var nodes=1;
    private fun update(value:Int,delta:Int){
        var node=0;
        for(bit in 20 downTo 0){
            val direction=value shr bit and 1;
            if(child[node][direction]==0)child[node][direction]=nodes++;
            node=child[node][direction];
            count[node]+=delta
        }
    };
    private fun query(value:Int):Int{
        var node=0;
        var result=0;
        for(bit in 20 downTo 0){
            val direction=value shr bit and 1;
            val preferred=direction xor 1;
            val next=child[node][preferred];
            if(next!=0&&count[next]>0){
                result=result or (1 shl bit);
                node=next
            }else node=child[node][direction]
        };
        return result
    };
    fun maximumStrongPairXor(nums:IntArray):Int{
        nums.sort();
        child=Array((nums.size+1)*21){
            IntArray(2)
        };
        count=IntArray((nums.size+1)*21);
        var answer=0;
        var left=0;
        for(value in nums){
            update(value,1);
            while(nums[left].toLong()*2<value){
                update(nums[left],-1);
                left++
            };
            answer=maxOf(answer,query(value))
        };
        return answer
    }
}
