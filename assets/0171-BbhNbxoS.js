const u=171,n="excel-sheet-column-number",e="Excel Sheet Column Number",m="简单",w="字符串",t=["数学","字符串"],d=!1,l="https://leetcode.cn/problems/excel-sheet-column-number/",s="Excel 表列序号",c=["进制转换","字符串","位权累积"],o="把 Excel 的字母列名称转换为对应的正整数列序号。",a="从左到右把已有结果乘二十六，再加当前字母对应的 1 到 26，等价于一基二十六进制求值。",r=["A 映射为一而不是零","每读一个字符都要先扩大原位权","输入只含大写英文字母"],i=[{id:"base-26-accumulation",title:"从高位到低位累积",kind:"最优",idea:"像解析普通进制整数一样逐字符更新结果。",steps:["answer 初始化为零","对每个字符执行 answer*=26","加上 character-A+1"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int titleToNumber(String columnTitle) { int answer = 0; for (char value : columnTitle.toCharArray()) answer = answer * 26 + value - 'A' + 1; return answer; }
}
`,kotlin:`class Solution {
    fun titleToNumber(columnTitle: String): Int { var answer = 0; for (value in columnTitle) answer = answer * 26 + (value - 'A') + 1; return answer }
}
`,cpp:`class Solution {
public:
    int titleToNumber(string columnTitle) { int answer = 0; for (char value : columnTitle) answer = answer * 26 + value - 'A' + 1; return answer; }
};
`}}],f={id:171,slug:n,titleEn:e,difficulty:"简单",category:"字符串",officialTags:t,paidOnly:!1,sourceUrl:l,title:s,studyTags:c,summary:o,insight:a,pitfalls:r,solutions:i};export{w as category,f as default,m as difficulty,u as id,a as insight,t as officialTags,d as paidOnly,r as pitfalls,n as slug,i as solutions,l as sourceUrl,c as studyTags,o as summary,s as title,e as titleEn};
