const g=49,n="group-anagrams",s="Group Anagrams",l="中等",p="字符串",t=["数组","哈希表","字符串","排序"],d=!1,r="https://leetcode.cn/problems/group-anagrams/",a="字母异位词分组",e=["规范化键","哈希分组","排序字符"],o="把字符串数组中由相同字符以不同顺序组成的字符串归入同一组。",i="字母异位词排序后会得到完全相同的字符串，因此排序结果可以作为稳定的分组键。",c=["空字符串也需要形成合法分组","每个分组中的原字符串不能被排序后替换","题目不要求组之间的固定顺序"],u=[{id:"sorted-key-hash",title:"排序键哈希分组",kind:"最优",idea:"为每个字符串生成排序后的规范键，用映射收集相同键对应的原字符串。",steps:["把字符串转成字符数组并排序","用排序字符串查找或创建分组","按首次出现顺序返回所有分组"],complexity:{time:"O(n · k log k)",space:"O(n · k)"},code:{java:`class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new LinkedHashMap<>();
        for (String value : strs) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(value);
        }
        return new ArrayList<>(groups.values());
    }
}
`,kotlin:`class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = linkedMapOf<String, MutableList<String>>()
        for (value in strs) {
            val chars = value.toCharArray()
            chars.sort()
            val key = chars.concatToString()
            groups.getOrPut(key) { ArrayList() }.add(value)
        }
        return groups.values.map { it.toList() }
    }
}
`,cpp:`class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, int> indexByKey;
        vector<vector<string>> groups;
        for (const string& value : strs) {
            string key = value;
            sort(key.begin(), key.end());
            auto [it, inserted] = indexByKey.emplace(key, groups.size());
            if (inserted) groups.push_back({});
            groups[it->second].push_back(value);
        }
        return groups;
    }
};
`}}],y={id:49,slug:n,titleEn:s,difficulty:"中等",category:"字符串",officialTags:t,paidOnly:!1,sourceUrl:r,title:a,studyTags:e,summary:o,insight:i,pitfalls:c,solutions:u};export{p as category,y as default,l as difficulty,g as id,i as insight,t as officialTags,d as paidOnly,c as pitfalls,n as slug,u as solutions,r as sourceUrl,e as studyTags,o as summary,a as title,s as titleEn};
