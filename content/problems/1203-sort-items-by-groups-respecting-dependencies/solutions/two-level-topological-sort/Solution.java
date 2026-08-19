class Solution {
    public int[] sortItems(int n,int m,int[] group,List<List<Integer>> beforeItems){
        int groupCount=m;
        for(int i=0;i<n;i++)if(group[i]==-1)group[i]=groupCount++;
        List<List<Integer>> itemGraph=new ArrayList<>(),groupGraph=new ArrayList<>();
        for(int i=0;i<n;i++)itemGraph.add(new ArrayList<>());
        for(int i=0;i<groupCount;i++)groupGraph.add(new ArrayList<>());
        int[] itemDegree=new int[n],groupDegree=new int[groupCount];
        Set<Long> groupEdges=new HashSet<>();
        for(int item=0;item<n;item++)for(int previous:beforeItems.get(item)){
            itemGraph.get(previous).add(item);
            itemDegree[item]++;
            if(group[previous]!=group[item]){
                long key=(long)group[previous]*groupCount+group[item];
                if(groupEdges.add(key)){
                    groupGraph.get(group[previous]).add(group[item]);
                    groupDegree[group[item]]++;
                }
            }
        }
        List<Integer> itemOrder=topological(itemGraph,itemDegree),groupOrder=topological(groupGraph,groupDegree);
        if(itemOrder.size()!=n||groupOrder.size()!=groupCount)return new int[0];
        List<List<Integer>> byGroup=new ArrayList<>();
        for(int i=0;i<groupCount;i++)byGroup.add(new ArrayList<>());
        for(int item:itemOrder)byGroup.get(group[item]).add(item);
        int[] answer=new int[n];
        int write=0;
        for(int value:groupOrder)for(int item:byGroup.get(value))answer[write++]=item;
        return answer;
    }
    private List<Integer> topological(List<List<Integer>> graph,int[] degree){
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<degree.length;i++)if(degree[i]==0)queue.offer(i);
        List<Integer> order=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.poll();
            order.add(node);
            for(int next:graph.get(node))if(--degree[next]==0)queue.offer(next);
        }
        return order;
    }
}
