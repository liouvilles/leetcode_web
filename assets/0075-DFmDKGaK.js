const a=75,n="sort-colors",s="Sort Colors",c="中等",t="数组与矩阵",i=["数组","双指针","排序","快速排序","Bubble Sort"],f=!1,l="https://leetcode.cn/problems/sort-colors/",e="颜色分类",d=["荷兰国旗","三指针","原地排序"],o="把只包含 0、1、2 的数组原地排序，使相同数字相邻并按 0、1、2 排列。",m="维护已放好 0 的左区间和已放好 2 的右区间，中间指针处理尚未分类的值。",u=["交换到右侧的值尚未检查，middle 不能立即递增","交换零后 middle 可以前进","循环条件包含 right 所在位置"],r=[{id:"dutch-national-flag",title:"荷兰国旗三指针",kind:"最优",idea:"一次扫描把 0 交换到左端、2 交换到右端，1 留在中部。",steps:["left、middle 从零开始，right 从末尾开始","遇 0 与 left 交换并同时前进","遇 2 与 right 交换且只收缩 right"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public void sortColors(int[] nums) {
        int left = 0, middle = 0, right = nums.length - 1;
        while (middle <= right) {
            if (nums[middle] == 0) { swap(nums, left++, middle++); }
            else if (nums[middle] == 2) { swap(nums, middle, right--); }
            else middle++;
        }
    }
    private void swap(int[] nums, int first, int second) { int value = nums[first]; nums[first] = nums[second]; nums[second] = value; }
}
`,kotlin:`class Solution {
    fun sortColors(nums: IntArray) {
        var left = 0; var middle = 0; var right = nums.lastIndex
        while (middle <= right) {
            when (nums[middle]) { 0 -> swap(nums, left++, middle++); 2 -> swap(nums, middle, right--); else -> middle++ }
        }
    }
    private fun swap(nums: IntArray, first: Int, second: Int) { val value = nums[first]; nums[first] = nums[second]; nums[second] = value }
}
`,cpp:`class Solution {
public:
    void sortColors(vector<int>& nums) {
        int left = 0, middle = 0, right = nums.size() - 1;
        while (middle <= right) { if (nums[middle] == 0) swap(nums[left++], nums[middle++]); else if (nums[middle] == 2) swap(nums[middle], nums[right--]); else ++middle; }
    }
};
`}}],p={id:75,slug:n,titleEn:s,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:l,title:e,studyTags:d,summary:o,insight:m,pitfalls:u,solutions:r};export{t as category,p as default,c as difficulty,a as id,m as insight,i as officialTags,f as paidOnly,u as pitfalls,n as slug,r as solutions,l as sourceUrl,d as studyTags,o as summary,e as title,s as titleEn};
