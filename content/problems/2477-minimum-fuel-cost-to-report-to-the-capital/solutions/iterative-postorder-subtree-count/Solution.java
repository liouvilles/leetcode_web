class Solution {
    public long minimumFuelCost(int[][] roads,int seats){
        int n=roads.length+1;
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] road:roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        int[] parent=new int[n],order=new int[n];
        Arrays.fill(parent,-2);
        parent[0]=-1;
        int size=1;
        order[0]=0;
        for(int index=0;index<size;index++){
            int node=order[index];
            for(int next:graph[node])if(parent[next]==-2){
                parent[next]=node;
                order[size++]=next;
            }
        }
        long[] people=new long[n];
        Arrays.fill(people,1);
        long fuel=0;
        for(int index=n-1;index>0;index--){
            int node=order[index];
            fuel+=(people[node]+seats-1)/seats;
            people[parent[node]]+=people[node];
        }
        return fuel;
    }
}
