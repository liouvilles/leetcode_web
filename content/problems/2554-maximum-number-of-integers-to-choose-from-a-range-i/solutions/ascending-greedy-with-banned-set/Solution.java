class Solution {
    public int maxCount(int[] banned,int n,int maxSum){
        Set<Integer> blocked=new HashSet<>();
        for(int value:banned)blocked.add(value);
        int sum=0,count=0;
        for(int value=1;value<=n;value++)if(!blocked.contains(value)){
            if(sum+value>maxSum)break;
            sum+=value;
            count++;
        }
        return count;
    }
}
