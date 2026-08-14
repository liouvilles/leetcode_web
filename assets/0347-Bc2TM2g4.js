const f=347,n="top-k-frequent-elements",e="Top K Frequent Elements",k="中等",t="数据结构与设计",s=["数组","哈希表","分治","排序","堆（优先队列）","桶排序","计数","快速选择"],d=!1,u="https://leetcode.cn/problems/top-k-frequent-elements/",r="前 K 个高频元素",i=["桶排序","频次统计","线性选择"],c="返回整数数组中出现频率最高的 k 个不同元素，答案顺序不限。",a="元素频率最大不超过数组长度，可以把频率作为桶下标，再从高频桶向低频桶收集。",o=["k 指不同元素数量","同频元素的输出顺序不影响正确性","收集到 k 个后应立即结束"],l=[{id:"frequency-buckets",title:"频率桶",kind:"最优",idea:"先按首次出现顺序计数，再把元素放进对应频率的桶中。",steps:["统计每个元素频率","将元素加入 buckets[frequency]","从最高频桶向下收集 k 个元素"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new LinkedHashMap<>(); for (int value : nums) counts.put(value, counts.getOrDefault(value, 0) + 1);
        List<List<Integer>> buckets = new ArrayList<>(); for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) buckets.get(entry.getValue()).add(entry.getKey());
        int[] answer = new int[k]; int index = 0;
        for (int frequency = nums.length; frequency > 0 && index < k; frequency--) for (int value : buckets.get(frequency)) { answer[index++] = value; if (index == k) break; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = linkedMapOf<Int, Int>(); for (value in nums) counts[value] = (counts[value] ?: 0) + 1
        val buckets = List(nums.size + 1) { ArrayList<Int>() }; for ((value, frequency) in counts) buckets[frequency].add(value)
        val answer = IntArray(k); var index = 0
        for (frequency in nums.size downTo 1) for (value in buckets[frequency]) { if (index < k) answer[index++] = value }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts; vector<int> order;
        for (int value : nums) { if (!counts.count(value)) order.push_back(value); ++counts[value]; }
        vector<vector<int>> buckets(nums.size() + 1); for (int value : order) buckets[counts[value]].push_back(value);
        vector<int> answer; answer.reserve(k);
        for (int frequency = nums.size(); frequency > 0 && (int)answer.size() < k; --frequency) for (int value : buckets[frequency]) { if ((int)answer.size() < k) answer.push_back(value); }
        return answer;
    }
};
`}}],y={id:347,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:s,paidOnly:!1,sourceUrl:u,title:r,studyTags:i,summary:c,insight:a,pitfalls:o,solutions:l};export{t as category,y as default,k as difficulty,f as id,a as insight,s as officialTags,d as paidOnly,o as pitfalls,n as slug,l as solutions,u as sourceUrl,i as studyTags,c as summary,r as title,e as titleEn};
