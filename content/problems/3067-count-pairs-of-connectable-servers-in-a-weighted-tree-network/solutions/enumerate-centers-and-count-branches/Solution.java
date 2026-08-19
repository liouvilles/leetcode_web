class Solution {
    private int count(int node,int parent,long distance,int speed,List<int[]>[] graph){
        int result=distance% speed==0?1:0;
        for(int[] edge:graph[node])if(edge[0]!=parent)result+=count(edge[0],node,distance+edge[1],speed,graph);
        return result;
    }
    public int[] countPairsOfConnectableServers(int[][] edges,int signalSpeed){
        int n=edges.length+1;
        List<int[]>[] graph=new ArrayList[n];
        for(int node=0;node<n;node++)graph[node]=new ArrayList<>();
        for(int[] edge:edges){graph[edge[0]].add(new int[]{edge[1],edge[2]});graph[edge[1]].add(new int[]{edge[0],edge[2]});}
        int[] answer=new int[n];
        for(int server=0;server<n;server++){
            int previous=0;
            for(int[] edge:graph[server]){
                int current=count(edge[0],server,edge[1],signalSpeed,graph);
                answer[server]+=previous*current;
                previous+=current;
            }
        }
        return answer;
    }
}
