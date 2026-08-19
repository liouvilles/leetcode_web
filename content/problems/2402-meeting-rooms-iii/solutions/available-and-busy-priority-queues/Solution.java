class Solution {
    public int mostBooked(int n,int[][] meetings){
        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> available=new PriorityQueue<>();
        for(int room=0;room<n;room++)available.add(room);
        PriorityQueue<long[]> busy=new PriorityQueue<>((a,b)->a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1]));
        int[] count=new int[n];
        for(int[] meeting:meetings){
            long start=meeting[0],duration=meeting[1]-meeting[0];
            while(!busy.isEmpty()&&busy.peek()[0]<=start)available.add((int)busy.poll()[1]);
            int room;
            long end;
            if(!available.isEmpty()){
                room=available.poll();
                end=start+duration;
            }else{
                long[] state=busy.poll();
                room=(int)state[1];
                end=state[0]+duration;
            }
            count[room]++;
            busy.add(new long[]{
                end,room
            });
        }
        int answer=0;
        for(int room=1;room<n;room++)if(count[room]>count[answer])answer=room;
        return answer;
    }
}
