class NumArray {
    private final int[] values,tree;
    public NumArray(int[] nums){
        values=nums.clone();
        tree=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)add(i+1,nums[i]);
    }
    private void add(int index,int delta){
        for(;index<tree.length;index+=index&-index)tree[index]+=delta;
    }
    private int prefix(int index){
        int sum=0;
        for(;index>0;index-=index&-index)sum+=tree[index];
        return sum;
    }
    public void update(int index,int val){
        int delta=val-values[index];
        values[index]=val;
        add(index+1,delta);
    }
    public int sumRange(int left,int right){
        return prefix(right+1)-prefix(left);
    }
}
