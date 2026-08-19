class Solution {
    fun sortPeople(names:Array<String>,heights:IntArray):Array<String>{
        val indices=names.indices.sortedByDescending{
            heights[it]
        };
        return Array(names.size){
            names[indices[it]]
        }
    }
}
