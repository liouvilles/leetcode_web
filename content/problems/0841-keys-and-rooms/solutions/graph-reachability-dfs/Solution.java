class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] seen=new boolean[rooms.size()];
        Deque<Integer> stack=new ArrayDeque<>();
        seen[0]=true;
        stack.push(0);
        int visited=0;
        while(!stack.isEmpty()){
            int room=stack.pop();
            visited++;
            for(int key:rooms.get(room))if(!seen[key]){
                seen[key]=true;
                stack.push(key);
            }
        }
        return visited==rooms.size();
    }
}
