class Solution {
    struct Window{
        int need;
        multiset<int> small,large;
        long long sum=0;
        Window(int need):need(need){
        }
        void add(int value){
            small.insert(value);
            sum+=value;
            if((int)small.size()>need){
                auto it=prev(small.end());
                int moved=*it;
                sum-=moved;
                small.erase(it);
                large.insert(moved);
            }
        }
        void remove(int value){
            auto it=small.find(value);
            if(it!=small.end()){
                sum-=value;
                small.erase(it);
            }else large.erase(large.find(value));
            if((int)small.size()<need&&!large.empty()){
                auto first=large.begin();
                int moved=*first;
                large.erase(first);
                small.insert(moved);
                sum+=moved;
            }
        }
    };
    public:long long minimumCost(vector<int>& nums,int k,int dist){
        Window window(k-1);
        for(int index=1;index<=dist+1;++index)window.add(nums[index]);
        long long answer=nums[0]+window.sum;
        for(int right=dist+2;right<(int)nums.size();++right){
            window.remove(nums[right-dist-1]);
            window.add(nums[right]);
            answer=min(answer,nums[0]+window.sum);
        }
        return answer;
    }
};
