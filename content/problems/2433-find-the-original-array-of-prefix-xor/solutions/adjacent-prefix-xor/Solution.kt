class Solution {
    fun findArray(pref:IntArray):IntArray{
        return IntArray(pref.size){
            if(it==0)pref[0] else pref[it-1] xor pref[it]
        }
    }
}
