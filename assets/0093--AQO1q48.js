const g=93,n="restore-ip-addresses",s="Restore IP Addresses",l="中等",p="字符串",e=["字符串","回溯"],u=!1,r="https://leetcode.cn/problems/restore-ip-addresses/",i="复原 IP 地址",t=["回溯","字符串分段","剪枝"],a="在只含数字的字符串中插入三个点，返回所有每段在 0 到 255 且格式合法的 IPv4 地址。",d="深度固定为四段，每段尝试一到三位；用剩余字符数与剩余段数的范围提前剪枝。",c=["多位段不能以零开头","段值不能超过 255","必须恰好使用全部字符并得到四段"],o=[{id:"four-segment-backtracking",title:"四段回溯",kind:"最优",idea:"按顺序枚举每段长度，合法时递归构造下一段。",steps:["检查剩余字符能否填满剩余段","尝试长度 1..3 并校验前导零和值","四段且用完字符串时加入答案"],complexity:{time:"O(1)",space:"O(1) excluding output"},code:{java:`class Solution {
    public List<String> restoreIpAddresses(String s) { List<String> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int index, List<String> parts, List<String> answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.length() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == s.length()) answer.add(String.join(".", parts)); return; }
        int value = 0; for (int end = index; end < Math.min(index + 3, s.length()); end++) { if (end > index && s.charAt(index) == '0') break; value = value * 10 + s.charAt(end) - '0'; if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(s, end + 1, parts, answer); parts.remove(parts.size() - 1); }
    }
}
`,kotlin:`class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val answer = mutableListOf<String>(); val parts = mutableListOf<String>()
        fun backtrack(index: Int) { val remainingParts = 4 - parts.size; val remainingChars = s.length - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return; if (parts.size == 4) { if (index == s.length) answer.add(parts.joinToString(".")); return }; var value = 0; for (end in index until minOf(index + 3, s.length)) { if (end > index && s[index] == '0') break; value = value * 10 + (s[end] - '0'); if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(end + 1); parts.removeAt(parts.lastIndex) } }
        backtrack(0); return answer
    }
}
`,cpp:`class Solution {
    void backtrack(const string& s, int index, vector<string>& parts, vector<string>& answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.size() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == (int)s.size()) { string address = parts[0]; for (int i = 1; i < 4; ++i) address += "." + parts[i]; answer.push_back(address); } return; }
        int value = 0; for (int end = index; end < min(index + 3, (int)s.size()); ++end) { if (end > index && s[index] == '0') break; value = value * 10 + s[end] - '0'; if (value > 255) break; parts.push_back(s.substr(index, end - index + 1)); backtrack(s, end + 1, parts, answer); parts.pop_back(); }
    }
public:
    vector<string> restoreIpAddresses(string s) { vector<string> answer, parts; backtrack(s, 0, parts, answer); return answer; }
};
`}}],f={id:93,slug:n,titleEn:s,difficulty:"中等",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:r,title:i,studyTags:t,summary:a,insight:d,pitfalls:c,solutions:o};export{p as category,f as default,l as difficulty,g as id,d as insight,e as officialTags,u as paidOnly,c as pitfalls,n as slug,o as solutions,r as sourceUrl,t as studyTags,a as summary,i as title,s as titleEn};
