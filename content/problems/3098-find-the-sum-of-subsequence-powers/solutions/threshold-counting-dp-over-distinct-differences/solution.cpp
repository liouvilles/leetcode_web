class Solution {
    static constexpr long long MOD=1000000007LL;
    long long countAtLeast(const vector<int>& nums,int k,int difference){
        int n=nums.size();
        vector<long long> previous(n,1);
        for(int length=2;length<=k;++length){
            vector<long long> prefix(n),current(n);
            long long sum=0;
            for(int index=0;index<n;++index){sum=(sum+previous[index])%MOD;prefix[index]=sum;}
            int pointer=-1;
            for(int index=0;index<n;++index){
                while(pointer+1<index&&(long long)nums[index]-nums[pointer+1]>=difference)++pointer;
                if(pointer>=0)current[index]=prefix[pointer];
            }
            previous.swap(current);
        }
        return accumulate(previous.begin(),previous.end(),0LL)%MOD;
    }
public:
    int sumOfPowers(vector<int>& nums,int k){
        sort(nums.begin(),nums.end());
        set<int> uniqueDifferences;
        for(int left=0;left<(int)nums.size();++left)for(int right=left+1;right<(int)nums.size();++right)if(nums[right]>nums[left])uniqueDifferences.insert(nums[right]-nums[left]);
        vector<int> differences(uniqueDifferences.begin(),uniqueDifferences.end());
        vector<long long> counts;
        for(int difference:differences)counts.push_back(countAtLeast(nums,k,difference));
        long long answer=0;
        for(int index=0;index<(int)differences.size();++index){
            long long next=index+1<(int)counts.size()?counts[index+1]:0;
            long long exact=(counts[index]-next+MOD)%MOD;
            answer=(answer+differences[index]%MOD*exact)%MOD;
        }
        return answer;
    }
};
