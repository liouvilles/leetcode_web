const u=179,n="largest-number",t="Largest Number",c="中等",g="字符串",s=["数组","字符串","贪心","排序"],d=!1,e="https://leetcode.cn/problems/largest-number/",f="最大数",r=["自定义排序","字符串拼接","全零处理"],i="重新排列非负整数数组，使拼接得到的十进制字符串表示最大的数。",o="两个字符串 a、b 的相对顺序应比较 a+b 与 b+a，较大的拼接组合放在前面。",a=["不能按数值大小或普通字典序排序","全部为零时只返回一个零","结果可能超过整数范围，必须以字符串返回"],l=[{id:"concatenation-comparator",title:"拼接比较器排序",kind:"最优",idea:"把数字转成字符串后按 b+a 与 a+b 的降序关系排列。",steps:["转换所有数字为字符串","自定义比较器决定两两顺序","首字符为零时返回 0，否则连接全部字符串"],complexity:{time:"O(n log n · k)",space:"O(nk)"},code:{java:`class Solution {
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length]; for (int index = 0; index < nums.length; index++) values[index] = String.valueOf(nums[index]);
        Arrays.sort(values, (first, second) -> (second + first).compareTo(first + second));
        if (values[0].equals("0")) return "0";
        return String.join("", values);
    }
}
`,kotlin:`class Solution {
    fun largestNumber(nums: IntArray): String {
        val values = nums.map(Int::toString).sortedWith(Comparator { first, second -> (second + first).compareTo(first + second) })
        return if (values[0] == "0") "0" else values.joinToString("")
    }
}
`,cpp:`class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> values; for (int value : nums) values.push_back(to_string(value));
        sort(values.begin(), values.end(), [](const string& first, const string& second) { return first + second > second + first; });
        if (values[0] == "0") return "0";
        return accumulate(values.begin(), values.end(), string());
    }
};
`}}],m={id:179,slug:n,titleEn:t,difficulty:"中等",category:"字符串",officialTags:s,paidOnly:!1,sourceUrl:e,title:"最大数",studyTags:r,summary:i,insight:o,pitfalls:a,solutions:l};export{g as category,m as default,c as difficulty,u as id,o as insight,s as officialTags,d as paidOnly,a as pitfalls,n as slug,l as solutions,e as sourceUrl,r as studyTags,i as summary,f as title,t as titleEn};
