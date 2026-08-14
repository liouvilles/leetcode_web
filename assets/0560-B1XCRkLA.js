const p=560,n="subarray-sum-equals-k",t="Subarray Sum Equals K",f="中等",s="数组与矩阵",e=["数组","哈希表","前缀和"],x=!1,r="https://leetcode.cn/problems/subarray-sum-equals-k/",u="和为 K 的子数组",i=["前缀和","哈希计数","连续子数组"],a="统计整数数组中元素和恰好等于 k 的非空连续子数组数量。",o="当前前缀和为 prefix 时，每个此前出现的 prefix-k 都对应一个以当前位置结尾的合法子数组。",c=["数组包含负数，不能使用普通滑动窗口","前缀和零需要预先出现一次","哈希表保存出现次数而不是只保存是否存在"],l=[{id:"prefix-frequency",title:"前缀和频次表",kind:"最优",idea:"边扫描边查询所需旧前缀，再登记当前前缀。",steps:["counts[0]=1","累加当前元素到 prefix","答案增加 counts[prefix-k]，再增加 prefix 频次"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(); counts.put(0, 1); int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts.getOrDefault(prefix - k, 0); counts.put(prefix, counts.getOrDefault(prefix, 0) + 1); }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val counts = HashMap<Int, Int>(); counts[0] = 1; var prefix = 0; var answer = 0
        for (value in nums) { prefix += value; answer += counts[prefix - k] ?: 0; counts[prefix] = (counts[prefix] ?: 0) + 1 }
        return answer
    }
}
`,cpp:`class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> counts{{0, 1}}; int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts[prefix - k]; ++counts[prefix]; }
        return answer;
    }
};
`}}],m={id:560,slug:n,titleEn:t,difficulty:"中等",category:s,officialTags:e,paidOnly:!1,sourceUrl:r,title:u,studyTags:i,summary:a,insight:o,pitfalls:c,solutions:l};export{s as category,m as default,f as difficulty,p as id,o as insight,e as officialTags,x as paidOnly,c as pitfalls,n as slug,l as solutions,r as sourceUrl,i as studyTags,a as summary,u as title,t as titleEn};
