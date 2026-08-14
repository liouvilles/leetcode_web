const c=763,n="partition-labels",t="Partition Labels",x="中等",f="字符串",e=["哈希表","双指针","字符串","贪心"],u=!1,i="https://leetcode.cn/problems/partition-labels/",s="划分字母区间",a=["贪心","最远出现位置","区间闭合"],d="把字符串划分为尽可能多的连续片段，使每个字母最多出现在一个片段中，返回各片段长度。",r="扫描片段时，其内任一字符的最后出现位置都会扩展片段右边界；到达该最远边界时才能安全切分。",l=["目标是片段数量尽可能多","右边界要取当前片段所有字符最后位置的最大值","切分后新片段从下一字符开始"],o=[{id:"last-occurrence-greedy",title:"最后位置贪心",kind:"最优",idea:"预处理每个字符的最后下标，再扫描形成最早可闭合区间。",steps:["记录 26 个字符最后位置","end=max(end,last[current])","index==end 时记录长度并更新 start"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; for (int index = 0; index < s.length(); index++) last[s.charAt(index) - 'a'] = index;
        List<Integer> answer = new ArrayList<>(); int start = 0, end = 0;
        for (int index = 0; index < s.length(); index++) { end = Math.max(end, last[s.charAt(index) - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1; } }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun partitionLabels(s: String): List<Int> {
        val last = IntArray(26); for (index in s.indices) last[s[index] - 'a'] = index
        val answer = ArrayList<Int>(); var start = 0; var end = 0
        for (index in s.indices) { end = maxOf(end, last[s[index] - 'a']); if (index == end) { answer.add(end - start + 1); start = index + 1 } }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> partitionLabels(string s) {
        array<int, 26> last{}; for (int index = 0; index < (int)s.size(); ++index) last[s[index] - 'a'] = index;
        vector<int> answer; int start = 0, end = 0;
        for (int index = 0; index < (int)s.size(); ++index) { end = max(end, last[s[index] - 'a']); if (index == end) { answer.push_back(end - start + 1); start = index + 1; } }
        return answer;
    }
};
`}}],p={id:763,slug:n,titleEn:t,difficulty:"中等",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:i,title:s,studyTags:a,summary:d,insight:r,pitfalls:l,solutions:o};export{f as category,p as default,x as difficulty,c as id,r as insight,e as officialTags,u as paidOnly,l as pitfalls,n as slug,o as solutions,i as sourceUrl,a as studyTags,d as summary,s as title,t as titleEn};
