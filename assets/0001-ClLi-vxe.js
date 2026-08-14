const c=1,n="two-sum",t="Two Sum",p="简单",i="数组与矩阵",e=["数组","哈希表"],f=!1,s="https://leetcode.cn/problems/two-sum/",r="两数之和",a=["查找互补值","空间换时间","入门必做"],u="在整数数组中找到两个不同位置，使它们的元素之和等于目标值，并返回这两个位置。",o="枚举当前数字时，真正需要查找的不是另一个数字本身，而是 target - nums[i]。",l=["不能重复使用同一位置","先查询再写入哈希表可自然规避重复使用","排序法必须保留原下标"],m=[{id:"brute-force",title:"双重枚举",kind:"基础",idea:"枚举所有下标对，直接检查它们的和。这是最容易验证的基线解法。",steps:["固定第一个下标 i","从 i + 1 开始枚举 j","命中目标和后立即返回"],complexity:{time:"O(n²)",space:"O(1)"},code:{java:`class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}
`,kotlin:`class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}
`,cpp:`class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < (int)nums.size(); ++i) {
            for (int j = i + 1; j < (int)nums.size(); ++j) {
                if (nums[i] + nums[j] == target) return {i, j};
            }
        }
        return {};
    }
};
`}},{id:"one-pass-hash",title:"一次遍历哈希表",kind:"最优",idea:"哈希表记录已经见过的数字及其下标；处理当前元素时只需寻找互补值。",steps:["计算 complement = target - nums[i]","在表中查询 complement","未命中则记录 nums[i] 与 i"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] {seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }
}
`,kotlin:`class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val seen = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            seen[complement]?.let { return intArrayOf(it, i) }
            seen[nums[i]] = i
        }
        return intArrayOf()
    }
}
`,cpp:`class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;
        for (int i = 0; i < (int)nums.size(); ++i) {
            int complement = target - nums[i];
            auto it = seen.find(complement);
            if (it != seen.end()) return {it->second, i};
            seen[nums[i]] = i;
        }
        return {};
    }
};
`}},{id:"sort-two-pointers",title:"排序 + 双指针",kind:"进阶",idea:"把值与原下标绑定后排序，再根据当前和的大小移动左右指针。",steps:["建立 (值, 原下标) 数组并排序","左右端点求和","和偏小移动左端，偏大移动右端"],complexity:{time:"O(n log n)",space:"O(n)"},code:{java:`class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) pairs[i] = new int[] {nums[i], i};
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) return new int[] {pairs[left][1], pairs[right][1]};
            if (sum < target) left++; else right--;
        }
        return new int[0];
    }
}
`,kotlin:`class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val pairs = nums.mapIndexed { index, value -> intArrayOf(value, index) }
            .sortedBy { it[0] }
        var left = 0
        var right = pairs.lastIndex
        while (left < right) {
            val sum = pairs[left][0] + pairs[right][0]
            when {
                sum == target -> return intArrayOf(pairs[left][1], pairs[right][1])
                sum < target -> left++
                else -> right--
            }
        }
        return intArrayOf()
    }
}
`,cpp:`class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> pairs;
        for (int i = 0; i < (int)nums.size(); ++i) pairs.push_back({nums[i], i});
        sort(pairs.begin(), pairs.end());
        int left = 0, right = (int)pairs.size() - 1;
        while (left < right) {
            int sum = pairs[left].first + pairs[right].first;
            if (sum == target) return {pairs[left].second, pairs[right].second};
            if (sum < target) ++left; else --right;
        }
        return {};
    }
};
`}}],g={id:1,slug:n,titleEn:t,difficulty:"简单",category:i,officialTags:e,paidOnly:!1,sourceUrl:s,title:r,studyTags:a,summary:u,insight:o,pitfalls:l,solutions:m};export{i as category,g as default,p as difficulty,c as id,o as insight,e as officialTags,f as paidOnly,l as pitfalls,n as slug,m as solutions,s as sourceUrl,a as studyTags,u as summary,r as title,t as titleEn};
