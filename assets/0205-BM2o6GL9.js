const f=205,n="isomorphic-strings",r="Isomorphic Strings",l="简单",w="字符串",s=["哈希表","字符串"],u=!1,i="https://leetcode.cn/problems/isomorphic-strings/",t="同构字符串",o=["双向映射","一一对应","字符串"],a="判断能否通过把第一个字符串中的每个字符统一替换为另一个字符得到第二个字符串，同时保持字符顺序。",e="映射必须是一一对应，因此既要保证 s→t 一致，也要保证 t→s 不被另一个字符占用。",c=["不同源字符不能映射到同一个目标字符","同一源字符的所有出现位置必须映射一致","字符可以映射为自身"],d=[{id:"two-way-mapping",title:"双向字符映射",kind:"最优",idea:"扫描对应字符并同时维护两个方向的映射约束。",steps:["读取同一位置的两个字符","任一方向已有映射则检查一致性","两方向都未建立时同时登记"],complexity:{time:"O(n)",space:"O(|Σ|)"},code:{java:`class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] forward = new int[256], backward = new int[256]; Arrays.fill(forward, -1); Arrays.fill(backward, -1);
        for (int index = 0; index < s.length(); index++) { int first = s.charAt(index), second = t.charAt(index); if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
}
`,kotlin:`class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val forward = IntArray(256) { -1 }; val backward = IntArray(256) { -1 }
        for (index in s.indices) { val first = s[index].code; val second = t[index].code; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first } else if (forward[first] != second || backward[second] != first) return false }
        return true
    }
}
`,cpp:`class Solution {
public:
    bool isIsomorphic(string s, string t) {
        array<int, 256> forward, backward; forward.fill(-1); backward.fill(-1);
        for (int index = 0; index < (int)s.size(); ++index) { unsigned char first = s[index], second = t[index]; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
};
`}}],p={id:205,slug:n,titleEn:r,difficulty:"简单",category:"字符串",officialTags:s,paidOnly:!1,sourceUrl:i,title:t,studyTags:o,summary:a,insight:e,pitfalls:c,solutions:d};export{w as category,p as default,l as difficulty,f as id,e as insight,s as officialTags,u as paidOnly,c as pitfalls,n as slug,d as solutions,i as sourceUrl,o as studyTags,a as summary,t as title,r as titleEn};
