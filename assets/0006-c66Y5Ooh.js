const a=6,n="zigzag-conversion",s="Zigzag Conversion",c="中等",g="字符串",o=["字符串"],p=!1,t="https://leetcode.cn/problems/zigzag-conversion/",r="Z 字形变换",e=["按行模拟","方向切换","字符串"],i="把字符串按指定行数上下折返排列，再逐行连接得到变换后的字符串。",u="只需维护当前行和移动方向；到达第一行或最后一行时反转方向。",w=["行数为一时直接返回原串","有效行数可能大于字符串长度","方向应在写入当前字符后按边界切换"],l=[{id:"row-simulation",title:"逐字符折返模拟",kind:"最优",idea:"用每行一个构造器记录字符，行指针在上下边界间往返。",steps:["创建 min(numRows,length) 行","字符加入当前行","到达首尾行切换步长正负，最后连接所有行"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;
        List<StringBuilder> rows = new ArrayList<>(); for (int row = 0; row < numRows; row++) rows.add(new StringBuilder());
        int row = 0, step = 1;
        for (char value : s.toCharArray()) { rows.get(row).append(value); if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        StringBuilder answer = new StringBuilder(); for (StringBuilder value : rows) answer.append(value); return answer.toString();
    }
}
`,kotlin:`class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length) return s
        val rows = List(numRows) { StringBuilder() }; var row = 0; var step = 1
        for (value in s) { rows[row].append(value); if (row == 0) step = 1 else if (row == numRows - 1) step = -1; row += step }
        return rows.joinToString("")
    }
}
`,cpp:`class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || numRows >= (int)s.size()) return s;
        vector<string> rows(numRows); int row = 0, step = 1;
        for (char value : s) { rows[row] += value; if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        return accumulate(rows.begin(), rows.end(), string());
    }
};
`}}],d={id:6,slug:n,titleEn:s,difficulty:"中等",category:"字符串",officialTags:o,paidOnly:!1,sourceUrl:t,title:r,studyTags:e,summary:i,insight:u,pitfalls:w,solutions:l};export{g as category,d as default,c as difficulty,a as id,u as insight,o as officialTags,p as paidOnly,w as pitfalls,n as slug,l as solutions,t as sourceUrl,e as studyTags,i as summary,r as title,s as titleEn};
