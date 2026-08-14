const d=295,e="find-median-from-data-stream",n="Find Median from Data Stream",c="困难",r="数据结构与设计",i=["双指针","设计","排序","堆（优先队列）","数据流"],f=!1,o="https://leetcode.cn/problems/find-median-from-data-stream/",t="数据流的中位数",p=["设计题","双堆","数据流"],l="设计数据结构，持续加入整数，并能随时返回当前所有元素的中位数。",u="最大堆保存较小的一半，最小堆保存较大的一半；保持两堆大小相差不超过一且最大堆不少于最小堆。",a=["偶数个元素时中位数是两个堆顶平均值","求和前转换为浮点或长整型避免溢出","每次加入后都要恢复大小平衡"],s=[{id:"two-heaps",title:"最大堆 + 最小堆",kind:"最优",idea:"用两个堆维护数据流的下半区和上半区。",steps:["新值先加入最大堆，再把最大值移到最小堆","若最小堆更大则把其最小值移回","按总数量奇偶读取一个或两个堆顶"],complexity:{time:"O(log n) add, O(1) median",space:"O(n)"},code:{java:`class MedianFinder {
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();
    public MedianFinder() {}
    public void addNum(int num) { lower.offer(num); upper.offer(lower.poll()); if (upper.size() > lower.size()) lower.offer(upper.poll()); }
    public double findMedian() { return lower.size() > upper.size() ? lower.peek() : ((long) lower.peek() + upper.peek()) / 2.0; }
}
`,kotlin:`class MedianFinder {
    private val lower = PriorityQueue<Int>(compareByDescending { it })
    private val upper = PriorityQueue<Int>()
    fun addNum(num: Int) { lower.add(num); upper.add(lower.remove()); if (upper.size > lower.size) lower.add(upper.remove()) }
    fun findMedian(): Double = if (lower.size > upper.size) lower.element().toDouble() else (lower.element().toLong() + upper.element()) / 2.0
}
`,cpp:`class MedianFinder {
    priority_queue<int> lower;
    priority_queue<int, vector<int>, greater<int>> upper;
public:
    MedianFinder() {}
    void addNum(int num) { lower.push(num); upper.push(lower.top()); lower.pop(); if (upper.size() > lower.size()) { lower.push(upper.top()); upper.pop(); } }
    double findMedian() { return lower.size() > upper.size() ? lower.top() : ((long long)lower.top() + upper.top()) / 2.0; }
};
`}}],m={id:295,slug:e,titleEn:n,difficulty:"困难",category:r,officialTags:i,paidOnly:!1,sourceUrl:o,title:t,studyTags:p,summary:l,insight:u,pitfalls:a,solutions:s};export{r as category,m as default,c as difficulty,d as id,u as insight,i as officialTags,f as paidOnly,a as pitfalls,e as slug,s as solutions,o as sourceUrl,p as studyTags,l as summary,t as title,n as titleEn};
