class Solution {
    fun minimumTeachings(n:Int,languages:Array<IntArray>,friendships:Array<IntArray>):Int{
        val known=languages.map{
            it.toSet()
        };
        val candidates=mutableSetOf<Int>();
        for(friendship in friendships){
            val first=friendship[0]-1;
            val second=friendship[1]-1;
            if(known[first].intersect(known[second]).isEmpty()){
                candidates.add(first);
                candidates.add(second)
            }
        };
        var answer=candidates.size;
        for(language in 1..n)answer=minOf(answer,candidates.count{
            language !in known[it]
        });
        return answer
    }
}
