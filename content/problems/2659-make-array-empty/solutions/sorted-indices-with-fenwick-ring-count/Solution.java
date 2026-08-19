class Solution {
    static class Fenwick{
        int[] tree;
        Fenwick(int n){
            tree=new int[n+1];
        }
        void add(int index,int delta){
            for(index++;index<tree.length;index+=index&-index)tree[index]+=delta;
        }
        int sum(int index){
            int answer=0;
            for(index++;index>0;index-=index&-index)answer+=tree[index];
            return answer;
        }
        int range(int left,int right){
            return left>right?0:sum(right)-(left==0?0:sum(left-1));
        }
    }
    public long countOperationsToEmptyArray(int[] nums){
        Integer[] order=new Integer[nums.length];
        Fenwick fenwick=new Fenwick(nums.length);
        for(int i=0;i<nums.length;i++){
            order[i]=i;
            fenwick.add(i,1);
        }
        Arrays.sort(order,Comparator.comparingInt(index->nums[index]));
        long answer=0;
        int current=0;
        for(int target:order){
            answer+=target>=current?fenwick.range(current,target):fenwick.range(current,nums.length-1)+fenwick.range(0,target);
            fenwick.add(target,-1);
            current=(target+1)%nums.length;
        }
        return answer;
    }
}
