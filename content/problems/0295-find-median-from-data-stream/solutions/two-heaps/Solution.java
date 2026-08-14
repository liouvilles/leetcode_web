class MedianFinder {
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) { lower.offer(num); upper.offer(lower.poll()); if (upper.size() > lower.size()) lower.offer(upper.poll()); }
    public double findMedian() { return lower.size() > upper.size() ? lower.peek() : ((long) lower.peek() + upper.peek()) / 2.0; }
}
