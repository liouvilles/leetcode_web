const m=31,t="next-permutation",n="Next Permutation",v="中等",i="数组与矩阵",e=["数组","双指针"],g=!1,s="https://leetcode.cn/problems/next-permutation/",o="下一个排列",u=["字典序","逆序后缀","原地修改"],r="把整数数组原地变为字典序中紧邻的下一个更大排列；若已是最大排列，则变为最小排列。",a="从右向左找到第一个仍可增大的位置，用后缀中刚好更大的数替换，再把后缀变为最小升序。",l=["后缀原本是非递增序列","交换对象必须是最右侧大于 pivot 的值","不存在 pivot 时需要反转整个数组"],p=[{id:"pivot-swap-reverse",title:"转折点交换并反转",kind:"最优",idea:"定位最长非递增后缀前的 pivot，交换后反转后缀得到最小增量。",steps:["从右向左找到 nums[i] < nums[i+1]","从末尾找到第一个大于 nums[i] 的值并交换","反转 i+1 到末尾的后缀"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if (pivot >= 0) {
            int greater = nums.length - 1;
            while (nums[greater] <= nums[pivot]) greater--;
            swap(nums, pivot, greater);
        }
        for (int left = pivot + 1, right = nums.length - 1; left < right; left++, right--) swap(nums, left, right);
    }
    private void swap(int[] nums, int left, int right) { int value = nums[left]; nums[left] = nums[right]; nums[right] = value; }
}
`,kotlin:`class Solution {
    fun nextPermutation(nums: IntArray) {
        var pivot = nums.size - 2
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--
        if (pivot >= 0) {
            var greater = nums.lastIndex
            while (nums[greater] <= nums[pivot]) greater--
            swap(nums, pivot, greater)
        }
        var left = pivot + 1
        var right = nums.lastIndex
        while (left < right) swap(nums, left++, right--)
    }
    private fun swap(nums: IntArray, left: Int, right: Int) { val value = nums[left]; nums[left] = nums[right]; nums[right] = value }
}
`,cpp:`class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int pivot = (int)nums.size() - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) --pivot;
        if (pivot >= 0) {
            int greater = nums.size() - 1;
            while (nums[greater] <= nums[pivot]) --greater;
            swap(nums[pivot], nums[greater]);
        }
        reverse(nums.begin() + pivot + 1, nums.end());
    }
};
`}}],c={id:31,slug:t,titleEn:n,difficulty:"中等",category:i,officialTags:e,paidOnly:!1,sourceUrl:s,title:o,studyTags:u,summary:r,insight:a,pitfalls:l,solutions:p};export{i as category,c as default,v as difficulty,m as id,a as insight,e as officialTags,g as paidOnly,l as pitfalls,t as slug,p as solutions,s as sourceUrl,u as studyTags,r as summary,o as title,n as titleEn};
