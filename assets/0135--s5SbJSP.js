const g=135,i="candy",n="Candy",f="困难",t="数组与矩阵",s=["数组","贪心"],u=!1,a="https://leetcode.cn/problems/candy/",c="分发糖果",e=["贪心","双向扫描","相邻约束"],r="给每个孩子至少一颗糖，评分高于相邻孩子者必须拿到更多糖，求最少糖果总数。",d="从左到右满足相对左邻的约束，再从右到左用最大值补足相对右邻的约束。",o=["两个方向的约束都必须满足","相同评分不要求糖果更多","第二遍应取 max 而不是覆盖"],l=[{id:"two-direction-greedy",title:"左右两遍贪心",kind:"最优",idea:"第一遍确定递增段需求，第二遍补齐从右侧看递增的需求。",steps:["糖果数组初始化为一","左到右遇到评分上升则 candies[i]=candies[i-1]+1","右到左按右邻约束取最大值并求和"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int candy(int[] ratings) { int[] candies = new int[ratings.length]; Arrays.fill(candies, 1); for (int i = 1; i < ratings.length; i++) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (int i = ratings.length - 2; i >= 0; i--) if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1); int total = 0; for (int value : candies) total += value; return total; }
}
`,kotlin:`class Solution {
    fun candy(ratings: IntArray): Int { val candies = IntArray(ratings.size) { 1 }; for (i in 1 until ratings.size) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (i in ratings.size - 2 downTo 0) if (ratings[i] > ratings[i + 1]) candies[i] = maxOf(candies[i], candies[i + 1] + 1); return candies.sum() }
}
`,cpp:`class Solution {
public:
    int candy(vector<int>& ratings) { vector<int> candies(ratings.size(), 1); for (int i = 1; i < (int)ratings.size(); ++i) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (int i = ratings.size() - 2; i >= 0; --i) if (ratings[i] > ratings[i + 1]) candies[i] = max(candies[i], candies[i + 1] + 1); return accumulate(candies.begin(), candies.end(), 0); }
};
`}}],y={id:135,slug:i,titleEn:n,difficulty:"困难",category:t,officialTags:s,paidOnly:!1,sourceUrl:a,title:c,studyTags:e,summary:r,insight:d,pitfalls:o,solutions:l};export{t as category,y as default,f as difficulty,g as id,d as insight,s as officialTags,u as paidOnly,o as pitfalls,i as slug,l as solutions,a as sourceUrl,e as studyTags,r as summary,c as title,n as titleEn};
