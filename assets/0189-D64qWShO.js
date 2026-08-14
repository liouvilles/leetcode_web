const c=189,n="rotate-array",t="Rotate Array",v="中等",e="数组与矩阵",s=["数组","数学","双指针"],f=!1,r="https://leetcode.cn/problems/rotate-array/",i="轮转数组",l=["三次反转","原地数组","模运算"],u="把数组中的元素整体向右轮转 k 个位置，要求原地完成。",a="先反转整个数组，再分别反转前 k 个和后 n-k 个元素，就能保持两段内部的原顺序。",o=["k 需要对数组长度取模","k 为零时通用反转流程仍可处理","反转区间边界都包含端点"],m=[{id:"three-reversals",title:"三次区间反转",kind:"最优",idea:"通过整体反转与两段局部反转实现原地循环移动。",steps:["令 k %= n","反转整个数组","反转 [0,k-1] 和 [k,n-1]"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); reverse(nums, 0, k - 1); reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right) { while (left < right) { int value = nums[left]; nums[left++] = nums[right]; nums[right--] = value; } }
}
`,kotlin:`class Solution {
    fun rotate(nums: IntArray, shift: Int) {
        val k = shift % nums.size
        reverse(nums, 0, nums.lastIndex); reverse(nums, 0, k - 1); reverse(nums, k, nums.lastIndex)
    }
    private fun reverse(nums: IntArray, start: Int, end: Int) { var left = start; var right = end; while (left < right) { val value = nums[left]; nums[left++] = nums[right]; nums[right--] = value } }
}
`,cpp:`class Solution {
    void reverseRange(vector<int>& nums, int left, int right) { while (left < right) swap(nums[left++], nums[right--]); }
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverseRange(nums, 0, nums.size() - 1); reverseRange(nums, 0, k - 1); reverseRange(nums, k, nums.size() - 1);
    }
};
`}}],g={id:189,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:r,title:i,studyTags:l,summary:u,insight:a,pitfalls:o,solutions:m};export{e as category,g as default,v as difficulty,c as id,a as insight,s as officialTags,f as paidOnly,o as pitfalls,n as slug,m as solutions,r as sourceUrl,l as studyTags,u as summary,i as title,t as titleEn};
