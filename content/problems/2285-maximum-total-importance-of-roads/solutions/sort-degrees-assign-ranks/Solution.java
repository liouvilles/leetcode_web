class Solution {
    public long maximumImportance(int n,int[][] roads){
        long[] degree=new long[n];
        for(int[] road:roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        long answer=0;
        for(int i=0;i<n;i++)answer+=degree[i]*(i+1);
        return answer;
    }
}
