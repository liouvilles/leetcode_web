class Solution {
    fun canBeEqual(s1:String,s2:String):Boolean{
        val count=Array(2){
            IntArray(26)
        };
        for(i in 0 until 4){
            count[i%2][s1[i]-'a']++;
            count[i%2][s2[i]-'a']--
        };
        return count.all{
            row->row.all{
                it==0
            }
        }
    }
}
