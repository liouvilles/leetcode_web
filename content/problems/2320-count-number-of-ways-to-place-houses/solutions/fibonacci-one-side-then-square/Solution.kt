class Solution {
    fun countHousePlacements(n:Int):Int{
        val mod=1_000_000_007L;
        var older=1L;
        var newer=2L;
        for(length in 2..n){
            val current=(older+newer)%mod;
            older=newer;
            newer=current
        };
        return (newer*newer%mod).toInt()
    }
}
