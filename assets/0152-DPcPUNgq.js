const m=152,n="maximum-product-subarray",a="Maximum Product Subarray",x="中等",r="动态规划",u=["数组","动态规划"],M=!1,e="https://leetcode.cn/problems/maximum-product-subarray/",t="乘积最大子数组",i=["动态规划","最大最小状态","负数翻转"],s="在整数数组中寻找乘积最大的非空连续子数组，并返回该最大乘积。",c="负数会交换最大值和最小值的角色，因此每个位置必须同时维护以它结尾的最大乘积与最小乘积。",l=["不能只维护最大乘积","遇到零时当前状态会自然重启","更新最小值时必须使用上一轮的最大值"],o=[{id:"max-min-dp",title:"最大最小双状态",kind:"最优",idea:"对每个新元素比较独立开始、乘以前一最大值、乘以前一最小值三种选择。",steps:["初始化最大、最小和答案为首元素","保存上一轮状态后计算三个候选值","分别更新当前最大、最小以及全局答案"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int value = nums[index];
            int previousMax = currentMax;
            currentMax = Math.max(value, Math.max(previousMax * value, currentMin * value));
            currentMin = Math.min(value, Math.min(previousMax * value, currentMin * value));
            answer = Math.max(answer, currentMax);
        }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun maxProduct(nums: IntArray): Int {
        var currentMax = nums[0]
        var currentMin = nums[0]
        var answer = nums[0]
        for (index in 1 until nums.size) {
            val value = nums[index]
            val previousMax = currentMax
            currentMax = maxOf(value, previousMax * value, currentMin * value)
            currentMin = minOf(value, previousMax * value, currentMin * value)
            answer = maxOf(answer, currentMax)
        }
        return answer
    }
}
`,cpp:`class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < (int)nums.size(); ++index) {
            int value = nums[index], previousMax = currentMax;
            currentMax = max({value, previousMax * value, currentMin * value});
            currentMin = min({value, previousMax * value, currentMin * value});
            answer = max(answer, currentMax);
        }
        return answer;
    }
};
`}}],v={id:152,slug:n,titleEn:a,difficulty:"中等",category:r,officialTags:u,paidOnly:!1,sourceUrl:e,title:t,studyTags:i,summary:s,insight:c,pitfalls:l,solutions:o};export{r as category,v as default,x as difficulty,m as id,c as insight,u as officialTags,M as paidOnly,l as pitfalls,n as slug,o as solutions,e as sourceUrl,i as studyTags,s as summary,t as title,a as titleEn};
