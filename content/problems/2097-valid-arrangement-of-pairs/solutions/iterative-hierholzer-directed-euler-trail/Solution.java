class Solution {
    public int[][] validArrangement(int[][] pairs){
        Map<Integer,Deque<Integer>> graph=new HashMap<>();
        Map<Integer,Integer> balance=new HashMap<>();
        for(int[] pair:pairs){
            graph.computeIfAbsent(pair[0],ignored->new ArrayDeque<>()).addLast(pair[1]);
            balance.merge(pair[0],1,Integer::sum);
            balance.merge(pair[1],-1,Integer::sum);
        }
        int start=pairs[0][0];
        for(Map.Entry<Integer,Integer> entry:balance.entrySet())if(entry.getValue()==1)start=entry.getKey();
        Deque<Integer> stack=new ArrayDeque<>();
        List<int[]> reversed=new ArrayList<>();
        stack.addLast(start);
        while(!stack.isEmpty()){
            int node=stack.peekLast();
            Deque<Integer> edges=graph.get(node);
            if(edges!=null&&!edges.isEmpty())stack.addLast(edges.pollLast());
            else{
                int end=stack.pollLast();
                if(!stack.isEmpty())reversed.add(new int[]{
                    stack.peekLast(),end
                });
            }
        }
        Collections.reverse(reversed);
        return reversed.toArray(new int[0][]);
    }
}
