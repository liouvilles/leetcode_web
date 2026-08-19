class Solution {
    fun areAlmostEqual(s1:String,s2:String):Boolean{
        val mismatch=s1.indices.filter{
            s1[it]!=s2[it]
        };
        return mismatch.isEmpty()||mismatch.size==2&&s1[mismatch[0]]==s2[mismatch[1]]&&s1[mismatch[1]]==s2[mismatch[0]]
    }
}
