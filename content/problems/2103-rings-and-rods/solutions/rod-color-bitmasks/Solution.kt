class Solution {
    fun countPoints(rings:String):Int{
        val mask=IntArray(10);
        for(i in rings.indices step 2){
            val bit=when(rings[i]){
                'R'->1;
                'G'->2;
                else->4
            };
            val rod=rings[i+1]-'0';
            mask[rod]=mask[rod] or bit
        };
        return mask.count{
            it==7
        }
    }
}
