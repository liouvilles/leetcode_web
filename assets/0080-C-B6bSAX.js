const m=80,t="remove-duplicates-from-sorted-array-ii",e="Remove Duplicates from Sorted Array II",w="中等",i="数组与矩阵",n=["数组","双指针"],d=!1,s="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/",r="删除有序数组中的重复项 II",o=["快慢指针","原地去重","有序数组"],u="原地修改非递减数组，使每个不同元素最多保留两次，并返回有效前缀长度。",l="当已写入至少两个数时，新值只有不同于有效前缀倒数第二项才可写入。",a=["前两个元素总能保留","只要求有效前缀满足条件","短于三个元素的数组无需特殊修改"],c=[{id:"two-behind-check",title:"检查倒数第二个已写元素",kind:"最优",idea:"写指针表示有效长度，通过与 write-2 位置比较控制出现次数。",steps:["遍历原数组","write<2 或 value!=nums[write-2] 时写入","返回 write"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0; for (int value : nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write;
    }
}
`,kotlin:`class Solution {
    fun removeDuplicates(nums: IntArray): Int { var write = 0; for (value in nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write }
}
`,cpp:`class Solution {
public:
    int removeDuplicates(vector<int>& nums) { int write = 0; for (int value : nums) if (write < 2 || value != nums[write - 2]) nums[write++] = value; return write; }
};
`}}],f={id:80,slug:t,titleEn:e,difficulty:"中等",category:i,officialTags:n,paidOnly:!1,sourceUrl:s,title:r,studyTags:o,summary:u,insight:l,pitfalls:a,solutions:c};export{i as category,f as default,w as difficulty,m as id,l as insight,n as officialTags,d as paidOnly,a as pitfalls,t as slug,c as solutions,s as sourceUrl,o as studyTags,u as summary,r as title,e as titleEn};
