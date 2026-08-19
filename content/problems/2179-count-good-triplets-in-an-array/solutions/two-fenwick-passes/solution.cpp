class Solution {
    struct Fenwick{
        vector<long long> tree;
        Fenwick(int n):tree(n+1){
        }
        void add(int index){
            for(++index;index<(int)tree.size();index+=index&-index)++tree[index];
        }
        long long sum(int index){
            long long value=0;
            for(++index;index>0;index-=index&-index)value+=tree[index];
            return value;
        }
    };
    public:long long goodTriplets(vector<int>& nums1,vector<int>& nums2){
        int n=nums1.size();
        vector<int> position(n),mapped(n);
        for(int i=0;i<n;++i)position[nums2[i]]=i;
        for(int i=0;i<n;++i)mapped[i]=position[nums1[i]];
        vector<long long> left(n);
        Fenwick bit(n);
        for(int i=0;i<n;++i){
            left[i]=mapped[i]?bit.sum(mapped[i]-1):0;
            bit.add(mapped[i]);
        }
        bit=Fenwick(n);
        long long answer=0;
        for(int i=n-1;i>=0;--i){
            long long greater=n-1-i-bit.sum(mapped[i]);
            answer+=left[i]*greater;
            bit.add(mapped[i]);
        }
        return answer;
    }
};
