class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits){
        Collections.sort(usageLimits);
        long total=0;
        int groups=0;
        for(int limit:usageLimits){
            total+=limit;
            long next=groups+1L;
            if(total>=next*(next+1)/2)groups++;
        }
        return groups;
    }
}
