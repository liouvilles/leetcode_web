class Solution {
    public int countHousePlacements(int n){
        long mod=1_000_000_007L,older=1,newer=2;
        for(int length=2;length<=n;length++){
            long current=(older+newer)%mod;
            older=newer;
            newer=current;
        }
        return (int)(newer*newer%mod);
    }
}
