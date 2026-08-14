const m=27,n="remove-element",t="Remove Element",v="简单",e="数组与矩阵",i=["数组","双指针"],f=!1,s="https://leetcode.cn/problems/remove-element/",l="移除元素",o=["快慢指针","原地修改","稳定覆盖"],r="原地移除数组中等于指定值的元素，并返回保留下来的元素数量。",a="用写指针维护有效前缀，读指针遇到需要保留的元素时才写入并前进。",u=["只保证返回长度以内的前缀有效","空数组应返回零","覆盖过程不需要额外数组"],c=[{id:"stable-compaction",title:"稳定快慢指针",kind:"最优",idea:"读指针扫描全部元素，写指针只记录非目标值。",steps:["初始化 write=0","遇到不等于 val 的元素就写入 nums[write]","返回 write"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int value : nums) if (value != val) nums[write++] = value;
        return write;
    }
}
`,kotlin:`class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        var write = 0
        for (item in nums) if (item != value) nums[write++] = item
        return write
    }
}
`,cpp:`class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int write = 0;
        for (int value : nums) if (value != val) nums[write++] = value;
        return write;
    }
};
`}}],p={id:27,slug:n,titleEn:t,difficulty:"简单",category:e,officialTags:i,paidOnly:!1,sourceUrl:s,title:l,studyTags:o,summary:r,insight:a,pitfalls:u,solutions:c};export{e as category,p as default,v as difficulty,m as id,a as insight,i as officialTags,f as paidOnly,u as pitfalls,n as slug,c as solutions,s as sourceUrl,o as studyTags,r as summary,l as title,t as titleEn};
