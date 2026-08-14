const f=238,n="product-of-array-except-self",e="Product of Array Except Self",c="中等",s="数组与矩阵",i=["数组","前缀和"],l=!1,t="https://leetcode.cn/problems/product-of-array-except-self/",r="除自身以外数组的乘积",u=["前缀乘积","后缀乘积","无除法"],o="对数组每个位置，计算除该位置元素外其余所有元素的乘积，不能使用除法。",x="答案由左侧所有元素乘积与右侧所有元素乘积相乘得到；前缀写进答案，后缀用一个滚动变量补上。",d=["前缀和后缀的空乘积为一","零元素由乘积流程自然处理","后缀变量应在写答案之后更新"],a=[{id:"prefix-suffix",title:"前缀数组 + 滚动后缀",kind:"最优",idea:"先把每个位置左侧乘积写入结果，再反向乘上右侧乘积。",steps:["answer[0] 初始化为一","正向累计左侧乘积","反向维护 suffix 并乘入答案"],complexity:{time:"O(n)",space:"O(1) extra"},code:{java:`class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length]; answer[0] = 1;
        for (int index = 1; index < nums.length; index++) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.length - 1; index >= 0; index--) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size); answer[0] = 1
        for (index in 1 until nums.size) answer[index] = answer[index - 1] * nums[index - 1]
        var suffix = 1
        for (index in nums.lastIndex downTo 0) { answer[index] *= suffix; suffix *= nums[index] }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> answer(nums.size(), 1);
        for (int index = 1; index < (int)nums.size(); ++index) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.size() - 1; index >= 0; --index) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
};
`}}],p={id:238,slug:n,titleEn:e,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:t,title:r,studyTags:u,summary:o,insight:x,pitfalls:d,solutions:a};export{s as category,p as default,c as difficulty,f as id,x as insight,i as officialTags,l as paidOnly,d as pitfalls,n as slug,a as solutions,t as sourceUrl,u as studyTags,o as summary,r as title,e as titleEn};
