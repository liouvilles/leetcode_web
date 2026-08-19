class Solution {
    public int maxEvents(int[][] events){
        Arrays.sort(events,Comparator.comparingInt(event->event[0]));
        PriorityQueue<Integer> ends=new PriorityQueue<>();
        int index=0,day=0,answer=0;
        while(index<events.length||!ends.isEmpty()){
            if(ends.isEmpty())day=Math.max(day,events[index][0]);
            while(index<events.length&&events[index][0]<=day)ends.offer(events[index++][1]);
            while(!ends.isEmpty()&&ends.peek()<day)ends.poll();
            if(!ends.isEmpty()){
                ends.poll();
                answer++;
                day++;
            }
        }
        return answer;
    }
}
