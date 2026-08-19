class RecentCounter {
    private final Deque<Integer> times=new ArrayDeque<>();
    public RecentCounter(){
    }
    public int ping(int t){
        times.offerLast(t);
        while(times.peekFirst()<t-3000)times.pollFirst();
        return times.size();
    }
}
