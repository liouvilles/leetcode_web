const u=242,n="valid-anagram",t="Valid Anagram",d="简单",f="字符串",s=["哈希表","字符串","排序"],g=!1,i="https://leetcode.cn/problems/valid-anagram/",e="有效的字母异位词",o=["字符计数","频次抵消","字符串"],c="判断两个只含小写字母的字符串是否由完全相同的字符及出现次数组成。",r="长度相同是必要条件；一个字符串增加计数、另一个减少计数后，所有桶应归零。",a=["字符种类相同但次数不同仍不是异位词","先判断长度可以提前失败","输入限定小写英文字母"],l=[{id:"frequency-array",title:"定长频次数组",kind:"最优",idea:"用 26 个整数同时累计两个字符串的字符差值。",steps:["长度不同直接返回假","同一位置对 s 加一、对 t 减一","检查全部计数是否为零"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) return false;
        int[] counts = new int[26];
        for (int index = 0; index < first.length(); index++) { counts[first.charAt(index) - 'a']++; counts[second.charAt(index) - 'a']--; }
        for (int count : counts) if (count != 0) return false;
        return true;
    }
}
`,kotlin:`class Solution {
    fun isAnagram(first: String, second: String): Boolean {
        if (first.length != second.length) return false
        val counts = IntArray(26)
        for (index in first.indices) { counts[first[index] - 'a']++; counts[second[index] - 'a']-- }
        return counts.all { it == 0 }
    }
}
`,cpp:`class Solution {
public:
    bool isAnagram(string first, string second) {
        if (first.size() != second.size()) return false;
        array<int, 26> counts{};
        for (int index = 0; index < (int)first.size(); ++index) { ++counts[first[index] - 'a']; --counts[second[index] - 'a']; }
        return all_of(counts.begin(), counts.end(), [](int count) { return count == 0; });
    }
};
`}}],x={id:242,slug:n,titleEn:t,difficulty:"简单",category:"字符串",officialTags:s,paidOnly:!1,sourceUrl:i,title:e,studyTags:o,summary:c,insight:r,pitfalls:a,solutions:l};export{f as category,x as default,d as difficulty,u as id,r as insight,s as officialTags,g as paidOnly,a as pitfalls,n as slug,l as solutions,i as sourceUrl,o as studyTags,c as summary,e as title,t as titleEn};
