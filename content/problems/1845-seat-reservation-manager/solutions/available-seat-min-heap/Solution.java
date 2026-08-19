class SeatManager {
    PriorityQueue<Integer> available=new PriorityQueue<>();
    public SeatManager(int n){
        for(int seat=1;seat<=n;seat++)available.offer(seat);
    }
    public int reserve(){
        return available.poll();
    }
    public void unreserve(int seatNumber){
        available.offer(seatNumber);
    }
}
