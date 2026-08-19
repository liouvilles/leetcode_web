class Solution {
    private String labels;
    private int[] answer;
    private List<Integer>[] graph;
    private int[] dfs(int node,int parent){
        int[] count=new int[26];
        count[labels.charAt(node)-'a']=1;
        for(int child:graph[node])if(child!=parent){
            int[] childCount=dfs(child,node);
            for(int letter=0;letter<26;letter++)count[letter]+=childCount[letter];
        }
        answer[node]=count[labels.charAt(node)-'a'];
        return count;
    }
    public int[] countSubTrees(int n,int[][] edges,String labels){
        this.labels=labels;
        answer=new int[n];
        graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0,-1);
        return answer;
    }
}
