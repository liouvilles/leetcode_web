class Solution {
    fun processQueries(queries:IntArray,m:Int):IntArray{
        val permutation=(1..m).toMutableList();
        return IntArray(queries.size){
            i->val index=permutation.indexOf(queries[i]);
            permutation.removeAt(index);
            permutation.add(0,queries[i]);
            index
        }
    }
}
