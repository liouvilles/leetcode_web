const h=15,n="3sum",t="3Sum",o="中等",s="数组与矩阵",i=["数组","双指针","排序"],g=!1,e="https://leetcode.cn/problems/3sum/",r="三数之和",u=["排序去重","双指针","固定一个数"],l="找出数组中所有由三个不同位置组成且元素和为零的不重复三元组。",f="排序后固定第一个数，剩余两数之和可以用相向双指针线性求出，同时在移动时完成去重。",m=["结果按数值组合去重而不是按下标","固定值大于零后可以提前结束","命中答案后左右两端都要跳过重复值"],a=[{id:"sort-two-pointers",title:"排序 + 双指针",kind:"最优",idea:"排序将三数关系转化为固定一数后的两数之和，并利用相邻相等元素去重。",steps:["先对数组排序","枚举第一个元素并跳过重复值","在右侧区间用左右指针寻找相反数并去重"],complexity:{time:"O(n²)",space:"O(log n)"},code:{java:`class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;
            int left = first + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    answer.add(Arrays.asList(nums[first], nums[left], nums[right]));
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) left++;
                    while (left < right && nums[right] == rightValue) right--;
                }
            }
        }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val answer = ArrayList<List<Int>>()
        for (first in 0 until nums.size - 2) {
            if (first > 0 && nums[first] == nums[first - 1]) continue
            if (nums[first] > 0) break
            var left = first + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[first] + nums[left] + nums[right]
                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        answer.add(listOf(nums[first], nums[left], nums[right]))
                        val leftValue = nums[left]
                        val rightValue = nums[right]
                        while (left < right && nums[left] == leftValue) left++
                        while (left < right && nums[right] == rightValue) right--
                    }
                }
            }
        }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> answer;
        for (int first = 0; first + 2 < (int)nums.size(); ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;
            int left = first + 1, right = (int)nums.size() - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum < 0) ++left;
                else if (sum > 0) --right;
                else {
                    answer.push_back({nums[first], nums[left], nums[right]});
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) ++left;
                    while (left < right && nums[right] == rightValue) --right;
                }
            }
        }
        return answer;
    }
};
`}}],c={id:15,slug:n,titleEn:t,difficulty:"中等",category:s,officialTags:i,paidOnly:!1,sourceUrl:e,title:r,studyTags:u,summary:l,insight:f,pitfalls:m,solutions:a};export{s as category,c as default,o as difficulty,h as id,f as insight,i as officialTags,g as paidOnly,m as pitfalls,n as slug,a as solutions,e as sourceUrl,u as studyTags,l as summary,r as title,t as titleEn};
