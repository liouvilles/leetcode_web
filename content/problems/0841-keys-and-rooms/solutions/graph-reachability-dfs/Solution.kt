class Solution {
    fun canVisitAllRooms(rooms:List<List<Int>>):Boolean{
        val seen=BooleanArray(rooms.size);
        val stack=java.util.ArrayDeque<Int>();
        seen[0]=true;
        stack.push(0);
        var visited=0;
        while(stack.isNotEmpty()){
            val room=stack.pop();
            visited++;
            for(key in rooms[room])if(!seen[key]){
                seen[key]=true;
                stack.push(key)
            }
        };
        return visited==rooms.size
    }
}
