const l=239,n="sliding-window-maximum",t="Sliding Window Maximum",m="困难",e="数据结构与设计",i=["数组","队列","滑动窗口","堆（优先队列）","单调队列","Range Minimum/Maximum Query"],g=!1,s="https://leetcode.cn/problems/sliding-window-maximum/",r="滑动窗口最大值",a=["单调队列","滑动窗口","下标过期"],d="固定长度 k 的窗口从数组左端滑到右端，返回每个窗口中的最大值。",u="双端队列只保留值严格递减的候选下标；队首永远是当前窗口最大值，较小且更早的元素永久失去竞争力。",o=["队列保存下标才能判断过期","新值入队前要从队尾移除不大于它的值","右端到达 k-1 后才产生答案"],c=[{id:"monotonic-deque",title:"递减单调队列",kind:"最优",idea:"维护当前窗口中仍可能成为最大值的下标序列。",steps:["移除小于窗口左边界的队首","移除值不大于当前值的队尾","当前下标入队并在窗口成形后记录队首值"],complexity:{time:"O(n)",space:"O(k)"},code:{java:`class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1]; Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) { while (!deque.isEmpty() && deque.peekFirst() <= right - k) deque.pollFirst(); while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) deque.pollLast(); deque.offerLast(right); if (right >= k - 1) answer[right - k + 1] = nums[deque.peekFirst()]; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answer = IntArray(nums.size - k + 1); val deque: ArrayDeque<Int> = ArrayDeque()
        for (right in nums.indices) { while (deque.isNotEmpty() && deque.first() <= right - k) deque.removeFirst(); while (deque.isNotEmpty() && nums[deque.last()] <= nums[right]) deque.removeLast(); deque.addLast(right); if (right >= k - 1) answer[right - k + 1] = nums[deque.first()] }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> answer; deque<int> candidates;
        for (int right = 0; right < (int)nums.size(); ++right) { while (!candidates.empty() && candidates.front() <= right - k) candidates.pop_front(); while (!candidates.empty() && nums[candidates.back()] <= nums[right]) candidates.pop_back(); candidates.push_back(right); if (right >= k - 1) answer.push_back(nums[candidates.front()]); }
        return answer;
    }
};
`}}],h={id:239,slug:n,titleEn:t,difficulty:"困难",category:e,officialTags:i,paidOnly:!1,sourceUrl:s,title:r,studyTags:a,summary:d,insight:u,pitfalls:o,solutions:c};export{e as category,h as default,m as difficulty,l as id,u as insight,i as officialTags,g as paidOnly,o as pitfalls,n as slug,c as solutions,s as sourceUrl,a as studyTags,d as summary,r as title,t as titleEn};
