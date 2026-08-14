const u=67,r="add-binary",n="Add Binary",d="简单",o="字符串",t=["数学","字符串","位运算","模拟"],y=!1,i="https://leetcode.cn/problems/add-binary/",a="二进制求和",s=["双指针","进位模拟","字符串"],e="给定两个二进制字符串，返回它们相加后的二进制字符串。",c="从两个字符串末尾同步取位，加上进位后写入结果最低位，并把商作为下一位进位。",l=["两个字符串长度可能不同","循环结束后可能仍有最高位进位","逆序生成后需要反转结果"],g=[{id:"digit-carry",title:"逆序逐位进位",kind:"最优",idea:"用两个下标从低位向高位模拟二进制竖式加法。",steps:["下标从两串末尾开始","累加有效位和 carry，追加 sum%2","更新 carry=sum/2，最后反转"],complexity:{time:"O(m+n)",space:"O(m+n)"},code:{java:`class Solution {
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder(); int left = a.length() - 1, right = b.length() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry != 0) { int sum = carry; if (left >= 0) sum += a.charAt(left--) - '0'; if (right >= 0) sum += b.charAt(right--) - '0'; answer.append(sum & 1); carry = sum >> 1; }
        return answer.reverse().toString();
    }
}
`,kotlin:`class Solution {
    fun addBinary(a: String, b: String): String {
        val answer = StringBuilder(); var left = a.lastIndex; var right = b.lastIndex; var carry = 0
        while (left >= 0 || right >= 0 || carry != 0) { var sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer.append(sum and 1); carry = sum shr 1 }
        return answer.reverse().toString()
    }
}
`,cpp:`class Solution {
public:
    string addBinary(string a, string b) {
        string answer; int left = a.size() - 1, right = b.size() - 1, carry = 0;
        while (left >= 0 || right >= 0 || carry) { int sum = carry; if (left >= 0) sum += a[left--] - '0'; if (right >= 0) sum += b[right--] - '0'; answer += char('0' + (sum & 1)); carry = sum >> 1; }
        reverse(answer.begin(), answer.end()); return answer;
    }
};
`}}],f={id:67,slug:r,titleEn:n,difficulty:"简单",category:"字符串",officialTags:t,paidOnly:!1,sourceUrl:i,title:a,studyTags:s,summary:e,insight:c,pitfalls:l,solutions:g};export{o as category,f as default,d as difficulty,u as id,c as insight,t as officialTags,y as paidOnly,l as pitfalls,r as slug,g as solutions,i as sourceUrl,s as studyTags,e as summary,a as title,n as titleEn};
