const c=283,n="move-zeroes",s="Move Zeroes",r="简单",t="数组与矩阵",i=["数组","双指针"],f=!1,o="https://leetcode.cn/problems/move-zeroes/",w="移动零",e=["原地修改","稳定移动","快慢指针"],u="原地把数组中的零移动到末尾，同时保持所有非零元素的相对顺序。",m="慢指针表示下一个非零元素应该写入的位置，快指针负责发现非零元素。",l=["必须保持非零元素顺序","要求原地修改","覆盖写法结束后要补零"],a=[{id:"compact-fill",title:"压缩后补零",kind:"基础",idea:"先把非零元素依次写到数组前部，再把剩余位置统一写成零。",steps:["write 指向下一个写入位置","顺序复制所有非零元素","将 write 之后的位置补零"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        for (int num : nums) if (num != 0) nums[write++] = num;
        while (write < nums.length) nums[write++] = 0;
    }
}
`,kotlin:`class Solution {
    fun moveZeroes(nums: IntArray) {
        var write = 0
        for (num in nums) if (num != 0) nums[write++] = num
        while (write < nums.size) nums[write++] = 0
    }
}
`,cpp:`class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int write = 0;
        for (int num : nums) if (num != 0) nums[write++] = num;
        while (write < (int)nums.size()) nums[write++] = 0;
    }
};
`}},{id:"swap-two-pointers",title:"交换式快慢指针",kind:"最优",idea:"每发现一个非零元素，就与慢指针位置交换；每个位置最多处理一次。",steps:["slow 指向首个未安置位置","fast 找到非零元素后交换","slow 向前推进"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = temp;
            }
        }
    }
}
`,kotlin:`class Solution {
    fun moveZeroes(nums: IntArray) {
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast].also { nums[fast] = nums[slow] }
                slow++
            }
        }
    }
}
`,cpp:`class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int slow = 0;
        for (int fast = 0; fast < (int)nums.size(); ++fast) {
            if (nums[fast] != 0) swap(nums[slow++], nums[fast]);
        }
    }
};
`}}],p={id:283,slug:n,titleEn:s,difficulty:"简单",category:t,officialTags:i,paidOnly:!1,sourceUrl:o,title:"移动零",studyTags:e,summary:u,insight:m,pitfalls:l,solutions:a};export{t as category,p as default,r as difficulty,c as id,m as insight,i as officialTags,f as paidOnly,l as pitfalls,n as slug,a as solutions,o as sourceUrl,e as studyTags,u as summary,w as title,s as titleEn};
