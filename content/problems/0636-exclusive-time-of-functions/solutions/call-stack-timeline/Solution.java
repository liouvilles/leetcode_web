class Solution {
    public int[] exclusiveTime(int n,List<String> logs){
        int[] answer=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        int previous=0;
        for(String log:logs){
            String[] parts=log.split(":");
            int id=Integer.parseInt(parts[0]),time=Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){
                if(!stack.isEmpty())answer[stack.peekLast()]+=time-previous;
                stack.addLast(id);
                previous=time;
            }else{
                answer[stack.removeLast()]+=time-previous+1;
                previous=time+1;
            }
        }
        return answer;
    }
}
