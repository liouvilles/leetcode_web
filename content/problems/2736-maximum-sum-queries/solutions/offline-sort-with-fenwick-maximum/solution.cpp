class Solution {
    public:vector<int> maximumSumQueries(vector<int>& nums1,vector<int>& nums2,vector<vector<int>>& queries){
        int n=nums1.size(),q=queries.size();
        vector<int> points(n),order(q),values=nums2,bit(n+1),answer(q);
        iota(points.begin(),points.end(),0);
        iota(order.begin(),order.end(),0);
        sort(points.begin(),points.end(),[&](int a,int b){
            return nums1[a]>nums1[b];
        });
        sort(order.begin(),order.end(),[&](int a,int b){
            return queries[a][0]>queries[b][0];
        });
        sort(values.begin(),values.end());
        auto lower=[&](int target){
            return lower_bound(values.begin(),values.end(),target)-values.begin();
        };
        auto update=[&](int index,int value){
            while(index<=n){
                bit[index]=max(bit[index],value);
                index+=index&-index;
            }
        };
        auto get=[&](int index){
            int result=0;
            while(index>0){
                result=max(result,bit[index]);
                index-=index&-index;
            }
            return result;
        };
        int added=0;
        for(int queryIndex:order){
            int x=queries[queryIndex][0],y=queries[queryIndex][1];
            while(added<n&&nums1[points[added]]>=x){
                int point=points[added++];
                update(n-lower(nums2[point]),nums1[point]+nums2[point]);
            }
            int best=get(n-lower(y));
            answer[queryIndex]=best?best:-1;
        }
        return answer;
    }
};
