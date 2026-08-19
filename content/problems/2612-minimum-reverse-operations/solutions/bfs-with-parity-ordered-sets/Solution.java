class Solution {
    public int[] minReverseOperations(int n,int p,int[] banned,int k){
        boolean[] forbidden=new boolean[n];
        for(int index:banned)forbidden[index]=true;
        TreeSet<Integer>[] unvisited=new TreeSet[]{
            new TreeSet<>(),new TreeSet<>()
        };
        for(int index=0;index<n;index++)if(index!=p&&!forbidden[index])unvisited[index&1].add(index);
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        distance[p]=0;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(p);
        while(!queue.isEmpty()){
            int node=queue.poll();
            int left=Math.max(0,node-k+1),right=Math.min(node,n-k);
            int minimum=2*left+k-1-node,maximum=2*right+k-1-node;
            TreeSet<Integer> set=unvisited[minimum&1];
            Integer next=set.ceiling(minimum);
            while(next!=null&&next<=maximum){
                int destination=next;
                set.remove(destination);
                distance[destination]=distance[node]+1;
                queue.add(destination);
                next=set.ceiling(minimum);
            }
        }
        return distance;
    }
}
