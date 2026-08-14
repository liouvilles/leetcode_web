const d=12,n="integer-to-roman",e="Integer to Roman",c="中等",m="字符串",t=["哈希表","数学","字符串"],g=!1,i="https://leetcode.cn/problems/integer-to-roman/",s="整数转罗马数字",o=["贪心","符号表","减法组合"],l="把给定范围内的正整数转换为标准罗马数字表示。",a="把普通符号和六种减法组合一起按数值降序排列，反复取当前最大可用符号即可。",r=["必须把 4、9、40 等减法组合放进符号表","每个数值可能重复使用","符号选择顺序必须从大到小"],u=[{id:"greedy-symbol-table",title:"降序符号贪心",kind:"最优",idea:"按降序表不断减去最大不超过剩余值的数并追加符号。",steps:["准备数值与符号对应表","对每项在剩余值足够时重复追加","剩余值归零后返回结果"],complexity:{time:"O(1)",space:"O(1)"},code:{java:`class Solution {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder answer = new StringBuilder();
        for (int index = 0; index < values.length; index++) while (num >= values[index]) { num -= values[index]; answer.append(symbols[index]); }
        return answer.toString();
    }
}
`,kotlin:`class Solution {
    fun intToRoman(input: Int): String {
        val values = intArrayOf(1000,900,500,400,100,90,50,40,10,9,5,4,1); val symbols = arrayOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
        var num = input; val answer = StringBuilder()
        for (index in values.indices) while (num >= values[index]) { num -= values[index]; answer.append(symbols[index]) }
        return answer.toString()
    }
}
`,cpp:`class Solution {
public:
    string intToRoman(int num) {
        vector<int> values = {1000,900,500,400,100,90,50,40,10,9,5,4,1}; vector<string> symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; string answer;
        for (int index = 0; index < (int)values.size(); ++index) while (num >= values[index]) { num -= values[index]; answer += symbols[index]; }
        return answer;
    }
};
`}}],p={id:12,slug:n,titleEn:e,difficulty:"中等",category:"字符串",officialTags:t,paidOnly:!1,sourceUrl:i,title:s,studyTags:o,summary:l,insight:a,pitfalls:r,solutions:u};export{m as category,p as default,c as difficulty,d as id,a as insight,t as officialTags,g as paidOnly,r as pitfalls,n as slug,u as solutions,i as sourceUrl,o as studyTags,l as summary,s as title,e as titleEn};
