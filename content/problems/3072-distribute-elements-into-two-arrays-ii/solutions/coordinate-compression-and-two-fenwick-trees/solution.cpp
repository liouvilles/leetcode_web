class Solution {
    struct Fenwick{
        vector<int> tree;
        Fenwick(int n):tree(n+1){}
        void add(int index){for(;index<(int)tree.size();index+=index&-index)++tree[index];}
        int query(int index){int result=0;for(;index>0;index-=index&-index)result+=tree[index];return result;}
    };
public:
    vector<int> resultArray(vector<int>& nums){
        vector<int> sorted=nums,first{nums[0]},second{nums[1]};
        sort(sorted.begin(),sorted.end());
        Fenwick firstTree(nums.size()),secondTree(nums.size());
        auto rankOf=[&](int value){return int(lower_bound(sorted.begin(),sorted.end(),value)-sorted.begin())+1;};
        firstTree.add(rankOf(nums[0]));secondTree.add(rankOf(nums[1]));
        for(int index=2;index<(int)nums.size();++index){
            int rank=rankOf(nums[index]);
            int firstGreater=first.size()-firstTree.query(rank);
            int secondGreater=second.size()-secondTree.query(rank);
            if(firstGreater>secondGreater||(firstGreater==secondGreater&&first.size()<=second.size())){
                first.push_back(nums[index]);firstTree.add(rank);
            }else{
                second.push_back(nums[index]);secondTree.add(rank);
            }
        }
        first.insert(first.end(),second.begin(),second.end());
        return first;
    }
};
