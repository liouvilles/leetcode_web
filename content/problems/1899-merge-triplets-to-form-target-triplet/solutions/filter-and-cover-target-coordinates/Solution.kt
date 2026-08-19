class Solution {
    fun mergeTriplets(triplets:Array<IntArray>,target:IntArray):Boolean{
        val matched=BooleanArray(3);
        for(triplet in triplets){
            if((0..2).any{
                triplet[it]>target[it]
            })continue;
            for(i in 0..2)if(triplet[i]==target[i])matched[i]=true
        };
        return matched.all{
            it
        }
    }
}
