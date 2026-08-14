const m=168,e="excel-sheet-column-title",n="Excel Sheet Column Title",a="简单",b="字符串",t=["数学","字符串"],d=!1,l="https://leetcode.cn/problems/excel-sheet-column-title/",r="Excel 表列名称",o=["进制转换","字符串","一基数位"],c="把正整数列序号转换为 Excel 使用的 A 到 Z、AA 到 ZZ 等列名称。",u="这是没有零位的一基二十六进制；每轮先减一，再对二十六取余就能映射到 A 到 Z。",i=["取余前必须先减一","结果从低位到高位生成后要反转","Z 对应余数二十五而不是零"],s=[{id:"bijective-base-26",title:"一基二十六进制转换",kind:"最优",idea:"通过先减一把一基数位映射为普通的 0..25 余数。",steps:["while columnNumber>0","columnNumber-- 后追加余数对应字符","整除 26 继续，最后反转"],complexity:{time:"O(log26 n)",space:"O(log26 n)"},code:{java:`class Solution {
    public String convertToTitle(int columnNumber) { StringBuilder answer = new StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append((char)('A' + columnNumber % 26)); columnNumber /= 26; } return answer.reverse().toString(); }
}
`,kotlin:`class Solution {
    fun convertToTitle(input: Int): String { var columnNumber = input; val answer = StringBuilder(); while (columnNumber > 0) { columnNumber--; answer.append(('A'.code + columnNumber % 26).toChar()); columnNumber /= 26 }; return answer.reverse().toString() }
}
`,cpp:`class Solution {
public:
    string convertToTitle(int columnNumber) { string answer; while (columnNumber > 0) { --columnNumber; answer += char('A' + columnNumber % 26); columnNumber /= 26; } reverse(answer.begin(), answer.end()); return answer; }
};
`}}],p={id:168,slug:e,titleEn:n,difficulty:"简单",category:"字符串",officialTags:t,paidOnly:!1,sourceUrl:l,title:r,studyTags:o,summary:c,insight:u,pitfalls:i,solutions:s};export{b as category,p as default,a as difficulty,m as id,u as insight,t as officialTags,d as paidOnly,i as pitfalls,e as slug,s as solutions,l as sourceUrl,o as studyTags,c as summary,r as title,n as titleEn};
