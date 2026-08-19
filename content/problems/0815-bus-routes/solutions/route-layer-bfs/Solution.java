class Solution {
    public int numBusesToDestination(int[][] routes,int source,int target){
        if(source==target)return 0;
        Map<Integer,List<Integer>> stopRoutes=new HashMap<>();
        for(int route=0;route<routes.length;route++)for(int stop:routes[route])stopRoutes.computeIfAbsent(stop,key->new ArrayList<>()).add(route);
        Queue<Integer> queue=new ArrayDeque<>();
        Set<Integer> seenStops=new HashSet<>();
        boolean[] seenRoutes=new boolean[routes.length];
        queue.offer(source);
        seenStops.add(source);
        int buses=0;
        while(!queue.isEmpty()){
            buses++;
            for(int size=queue.size();size>0;size--){
                int stop=queue.poll();
                for(int route:stopRoutes.getOrDefault(stop,Collections.emptyList()))if(!seenRoutes[route]){
                    seenRoutes[route]=true;
                    for(int next:routes[route]){
                        if(next==target)return buses;
                        if(seenStops.add(next))queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
