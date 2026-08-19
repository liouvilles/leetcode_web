class Solution {
    public List<Integer> findMinHeightTrees(int n,int[][] edges){
        if(n==1)return Arrays.asList(0);
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        int[] degree=new int[n];
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> leaves=new ArrayDeque<>();
        for(int i=0;i<n;i++)if(degree[i]==1)leaves.offer(i);
        int remaining=n;
        while(remaining>2){
            int size=leaves.size();
            remaining-=size;
            while(size-->0){
                int leaf=leaves.poll();
                for(int neighbor:graph.get(leaf))if(--degree[neighbor]==1)leaves.offer(neighbor);
            }
        }
        List<Integer> answer=new ArrayList<>(leaves);
        Collections.sort(answer);
        return answer;
    }
}
