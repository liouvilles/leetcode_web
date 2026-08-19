class NumArray {
    vector<int> values,tree;
    void add(int index,int delta){
        for(;index<(int)tree.size();index+=index&-index)tree[index]+=delta;
    }
    int prefix(int index){
        int sum=0;
        for(;index>0;index-=index&-index)sum+=tree[index];
        return sum;
    }
    public:NumArray(vector<int>& nums):values(nums),tree(nums.size()+1){
        for(int i=0;i<(int)nums.size();++i)add(i+1,nums[i]);
    }
    void update(int index,int value){
        int delta=value-values[index];
        values[index]=value;
        add(index+1,delta);
    }
    int sumRange(int left,int right){
        return prefix(right+1)-prefix(left);
    }
};
