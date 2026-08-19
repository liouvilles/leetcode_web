class Solution {
    public:int countHousePlacements(int n){
        const long long mod=1000000007;
        long long older=1,newer=2;
        for(int length=2;length<=n;++length){
            long long current=(older+newer)%mod;
            older=newer;
            newer=current;
        }
        return newer*newer%mod;
    }
};
