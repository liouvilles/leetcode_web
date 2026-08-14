const c=704,t="binary-search",n="Binary Search",d="简单",i="数组与矩阵",e=["数组","二分查找"],f=!1,r="https://leetcode.cn/problems/binary-search/",s="二分查找",a=["有序数组","闭区间模板","边界控制"],l="在升序整数数组中查找目标值；存在则返回下标，否则返回 -1。",m="每次比较都能排除一半候选区间，关键是区间定义与循环条件保持一致。",u=["闭区间模板使用 left <= right","计算中点时避免 left + right 溢出","更新边界必须排除 mid"],g=[{id:"iterative",title:"迭代二分",kind:"最优",idea:"维护包含目标候选位置的闭区间 [left, right]，直到区间为空。",steps:["计算安全中点","命中则返回","根据大小关系排除左半或右半"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1; else right = mid - 1;
        }
        return -1;
    }
}
`,kotlin:`class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }
}
`,cpp:`class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1; else right = mid - 1;
        }
        return -1;
    }
};
`}},{id:"recursive",title:"递归二分",kind:"进阶",idea:"把每次缩小后的区间交给下一层递归处理，结构接近数学定义。",steps:["区间为空时返回 -1","比较中点","递归进入仍可能包含目标的一半"],complexity:{time:"O(log n)",space:"O(log n)"},code:{java:`class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] < target
            ? search(nums, target, mid + 1, right)
            : search(nums, target, left, mid - 1);
    }
}
`,kotlin:`class Solution {
    fun search(nums: IntArray, target: Int): Int =
        search(nums, target, 0, nums.lastIndex)

    private fun search(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        return if (nums[mid] < target) search(nums, target, mid + 1, right)
        else search(nums, target, left, mid - 1)
    }
}
`,cpp:`class Solution {
public:
    int search(vector<int>& nums, int target) {
        return search(nums, target, 0, nums.size() - 1);
    }

private:
    int search(vector<int>& nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        return nums[mid] < target ? search(nums, target, mid + 1, right)
                                  : search(nums, target, left, mid - 1);
    }
};
`}}],h={id:704,slug:t,titleEn:n,difficulty:"简单",category:i,officialTags:e,paidOnly:!1,sourceUrl:r,title:s,studyTags:a,summary:l,insight:m,pitfalls:u,solutions:g};export{i as category,h as default,d as difficulty,c as id,m as insight,e as officialTags,f as paidOnly,u as pitfalls,t as slug,g as solutions,r as sourceUrl,a as studyTags,l as summary,s as title,n as titleEn};
