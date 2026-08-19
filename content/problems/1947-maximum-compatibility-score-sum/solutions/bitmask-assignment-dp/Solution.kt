class Solution {
    private lateinit var score:Array<IntArray>;
    private lateinit var memo:IntArray;
    private fun dfs(mask:Int):Int{
        if(mask==memo.lastIndex)return 0;
        if(memo[mask]>=0)return memo[mask];
        val student=Integer.bitCount(mask);
        var best=0;
        for(mentor in score.indices)if(mask and (1 shl mentor)==0)best=maxOf(best,score[student][mentor]+dfs(mask or (1 shl mentor)));
        memo[mask]=best;
        return best
    };
    fun maxCompatibilitySum(students:Array<IntArray>,mentors:Array<IntArray>):Int{
        val n=students.size;
        score=Array(n){
            student->IntArray(n){
                mentor->students[student].indices.count{
                    students[student][it]==mentors[mentor][it]
                }
            }
        };
        memo=IntArray(1 shl n){
            -1
        };
        return dfs(0)
    }
}
