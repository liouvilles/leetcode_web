class Solution {
    private Map<Integer,Integer> count;
    private int length;
    public int numSquarefulPerms(int[] nums){
        count=new HashMap<>();
        for(int value:nums)count.merge(value,1,Integer::sum);
        length=nums.length;
        return dfs(0,0,false);
    }
    private int dfs(int depth,int previous,boolean hasPrevious){
        if(depth==length)return 1;
        int ways=0;
        for(int value:new ArrayList<>(count.keySet()))if(count.get(value)>0&&(!hasPrevious||square(previous+value))){
            count.put(value,count.get(value)-1);
            ways+=dfs(depth+1,value,true);
            count.put(value,count.get(value)+1);
        }
        return ways;
    }
    private boolean square(int value){
        int root=(int)Math.sqrt(value);
        return root*root==value;
    }
}
