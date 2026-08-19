class Solution {
    public int[] gardenNoAdj(int n,int[][] paths){
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:paths){
            graph[edge[0]-1].add(edge[1]-1);
            graph[edge[1]-1].add(edge[0]-1);
        }
        int[] colors=new int[n];
        for(int garden=0;garden<n;garden++){
            boolean[] used=new boolean[5];
            for(int neighbor:graph[garden])used[colors[neighbor]]=true;
            for(int color=1;color<=4;color++)if(!used[color]){
                colors[garden]=color;
                break;
            }
        }
        return colors;
    }
}
