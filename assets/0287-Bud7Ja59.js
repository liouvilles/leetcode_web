const r=287,n="find-the-duplicate-number",s="Find the Duplicate Number",c="中等",i="数组与矩阵",t=["数组","双指针","二分查找","位运算","Pigeonhole Principle","Floyd's Cycle Finding Algorithm"],m=!1,l="https://leetcode.cn/problems/find-the-duplicate-number/",e="寻找重复数",o=["Floyd 判环","数组映射","常数空间"],u="长度为 n+1 的数组只包含 1 到 n，找出唯一重复值；不能修改数组且只用常数额外空间。",f="把下标到 nums[index] 视为链表后继，重复值就是环入口，可用 Floyd 快慢指针定位。",d=["返回的是重复值，也等于环入口下标","第二阶段一个指针从起点零重新出发","题目可能让重复值出现多次"],a=[{id:"floyd-entry",title:"函数图环入口",kind:"最优",idea:"先让快慢指针在环内相遇，再等速前进找到入口。",steps:["slow 走一步、fast 走两步直到相遇","finder 从下标零出发","finder 与 slow 同速移动，相遇位置即重复值"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]]; }
        int finder = 0;
        while (finder != slow) { finder = nums[finder]; slow = nums[slow]; }
        return finder;
    }
}
`,kotlin:`class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]; var fast = nums[nums[0]]
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]] }
        var finder = 0
        while (finder != slow) { finder = nums[finder]; slow = nums[slow] }
        return finder
    }
}
`,cpp:`class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]]; }
        int finder = 0;
        while (finder != slow) { finder = nums[finder]; slow = nums[slow]; }
        return finder;
    }
};
`}}],w={id:287,slug:n,titleEn:s,difficulty:"中等",category:i,officialTags:t,paidOnly:!1,sourceUrl:l,title:e,studyTags:o,summary:u,insight:f,pitfalls:d,solutions:a};export{i as category,w as default,c as difficulty,r as id,f as insight,t as officialTags,m as paidOnly,d as pitfalls,n as slug,a as solutions,l as sourceUrl,o as studyTags,u as summary,e as title,s as titleEn};
