const c=13,n="roman-to-integer",t="Roman to Integer",d="简单",f="字符串",e=["哈希表","数学","字符串"],m=!1,r="https://leetcode.cn/problems/roman-to-integer/",i="罗马数字转整数",s=["相邻比较","减法组合","线性扫描"],o="把由合法罗马数字字符组成的字符串转换成对应整数。",l="若当前字符代表的数值小于右侧相邻字符，它就是减法组合的一部分，应从总和中减去；否则加上。",a=["比较的是相邻数值而不是字符编码","最后一个字符总是加到结果中","输入保证为合法罗马数字"],u=[{id:"adjacent-values",title:"相邻数值扫描",kind:"最优",idea:"从左到右比较当前值与后一值，用符号决定当前值的贡献。",steps:["建立罗马字符数值映射","当前值小于后一值时减去当前值","其他情况加上当前值"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int romanToInt(String s) {
        int total = 0;
        for (int index = 0; index < s.length(); index++) {
            int current = value(s.charAt(index));
            int next = index + 1 < s.length() ? value(s.charAt(index + 1)) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }

    private int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
}
`,kotlin:`class Solution {
    fun romanToInt(s: String): Int {
        var total = 0
        for (index in s.indices) {
            val current = value(s[index])
            val next = if (index < s.lastIndex) value(s[index + 1]) else 0
            total += if (current < next) -current else current
        }
        return total
    }

    private fun value(symbol: Char): Int = when (symbol) {
        'I' -> 1; 'V' -> 5; 'X' -> 10; 'L' -> 50
        'C' -> 100; 'D' -> 500; else -> 1000
    }
}
`,cpp:`class Solution {
    int value(char symbol) {
        if (symbol == 'I') return 1;
        if (symbol == 'V') return 5;
        if (symbol == 'X') return 10;
        if (symbol == 'L') return 50;
        if (symbol == 'C') return 100;
        if (symbol == 'D') return 500;
        return 1000;
    }
public:
    int romanToInt(string s) {
        int total = 0;
        for (int index = 0; index < (int)s.size(); ++index) {
            int current = value(s[index]);
            int next = index + 1 < (int)s.size() ? value(s[index + 1]) : 0;
            total += current < next ? -current : current;
        }
        return total;
    }
};
`}}],x={id:13,slug:n,titleEn:t,difficulty:"简单",category:"字符串",officialTags:e,paidOnly:!1,sourceUrl:r,title:i,studyTags:s,summary:o,insight:l,pitfalls:a,solutions:u};export{f as category,x as default,d as difficulty,c as id,l as insight,e as officialTags,m as paidOnly,a as pitfalls,n as slug,u as solutions,r as sourceUrl,s as studyTags,o as summary,i as title,t as titleEn};
