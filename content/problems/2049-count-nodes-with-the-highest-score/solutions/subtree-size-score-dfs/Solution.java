class Solution {
    List<Integer>[] children;
    int n,count;
    long maximum;
    private int dfs(int node){
        int size=1;
        long score=1;
        for(int child:children[node]){
            int childSize=dfs(child);
            size+=childSize;
            score*=childSize;
        }
        if(n-size>0)score*=n-size;
        if(score>maximum){
            maximum=score;
            count=1;
        }else if(score==maximum)count++;
        return size;
    }
    public int countHighestScoreNodes(int[] parents){
        n=parents.length;
        children=new List[n];
        for(int i=0;i<n;i++)children[i]=new ArrayList<>();
        for(int i=1;i<n;i++)children[parents[i]].add(i);
        dfs(0);
        return count;
    }
}
