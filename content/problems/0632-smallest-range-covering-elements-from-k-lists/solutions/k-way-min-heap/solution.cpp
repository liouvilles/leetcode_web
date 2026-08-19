class Solution {
    public: vector<int> smallestRange(vector<vector<int>>& nums){
        using Item=array<int,3>;
        priority_queue<Item,vector<Item>,greater<Item>> heap;
        int maximum=INT_MIN;
        for(int row=0;row<(int)nums.size();++row){
            heap.push({
                nums[row][0],row,0
            });
            maximum=max(maximum,nums[row][0]);
        }
        int bestLeft=heap.top()[0],bestRight=maximum;
        while(true){
            auto item=heap.top();
            heap.pop();
            int minimum=item[0];
            if(maximum-minimum<bestRight-bestLeft||(maximum-minimum==bestRight-bestLeft&&minimum<bestLeft)){
                bestLeft=minimum;
                bestRight=maximum;
            }
            int nextIndex=item[2]+1;
            if(nextIndex==(int)nums[item[1]].size())break;
            int next=nums[item[1]][nextIndex];
            heap.push({
                next,item[1],nextIndex
            });
            maximum=max(maximum,next);
        }
        return{
            bestLeft,bestRight
        };
    }
};
