const a=26,n="remove-duplicates-from-sorted-array",t="Remove Duplicates from Sorted Array",d="简单",e="数组与矩阵",s=["数组","双指针"],f=!1,i="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/",o="删除有序数组中的重复项",l=["快慢指针","原地修改","有序去重"],u="原地删除非严格递增数组中的重复值，使前 k 个位置保存所有不同元素并返回 k。",r="有序数组的相同值连续出现，慢指针只需指向下一个不同元素应写入的位置。",c=["返回值是不同元素数量","只要求前 k 个位置正确","空数组需要返回 0"],m=[{id:"two-pointers",title:"快慢指针覆盖",kind:"最优",idea:"快指针扫描新值，慢指针维护去重后前缀长度。",steps:["空数组直接返回零","当前值不同于已写入前缀末尾时写到 slow","返回 slow 作为有效长度"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        }
        return length;
    }
}
`,kotlin:`class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var length = 1
        for (index in 1 until nums.size) if (nums[index] != nums[length - 1]) nums[length++] = nums[index]
        return length
    }
}
`,cpp:`class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int length = 1;
        for (int index = 1; index < (int)nums.size(); ++index) if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        return length;
    }
};
`}}],p={id:26,slug:n,titleEn:t,difficulty:"简单",category:e,officialTags:s,paidOnly:!1,sourceUrl:i,title:o,studyTags:l,summary:u,insight:r,pitfalls:c,solutions:m};export{e as category,p as default,d as difficulty,a as id,r as insight,s as officialTags,f as paidOnly,c as pitfalls,n as slug,m as solutions,i as sourceUrl,l as studyTags,u as summary,o as title,t as titleEn};
