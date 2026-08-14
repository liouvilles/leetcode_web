const w=7,n="reverse-integer",e="Reverse Integer",u="中等",g="数学",s=["数学"],x=!1,t="https://leetcode.cn/problems/reverse-integer/",r="整数反转",i=["数字反转","溢出判断","十进制"],a="反转 32 位有符号整数的十进制数字，结果溢出 32 位范围时返回零。",o="逐位取余构造反转值，并用更宽的长整型暂存以检测最终范围。",l=["负数取余得到负数位，可用同一循环处理","反转后的前导零自然消失","溢出时必须返回零"],c=[{id:"digit-reversal",title:"长整型逐位反转",kind:"最优",idea:"每轮把末位追加到长整型结果，结束后检查整数边界。",steps:["digit=x%10","answer=answer*10+digit 并令 x/=10","范围外返回零，否则转换为 int"],complexity:{time:"O(log |x|)",space:"O(1)"},code:{java:`class Solution {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE ? 0 : (int) answer;
    }
}
`,kotlin:`class Solution {
    fun reverse(input: Int): Int {
        var x = input; var answer = 0L
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10 }
        return if (answer < Int.MIN_VALUE || answer > Int.MAX_VALUE) 0 else answer.toInt()
    }
}
`,cpp:`class Solution {
public:
    int reverse(int x) {
        long long answer = 0;
        while (x != 0) { answer = answer * 10 + x % 10; x /= 10; }
        return answer < INT_MIN || answer > INT_MAX ? 0 : answer;
    }
};
`}}],d={id:7,slug:n,titleEn:e,difficulty:"中等",category:"数学",officialTags:s,paidOnly:!1,sourceUrl:t,title:r,studyTags:i,summary:a,insight:o,pitfalls:l,solutions:c};export{g as category,d as default,u as difficulty,w as id,o as insight,s as officialTags,x as paidOnly,l as pitfalls,n as slug,c as solutions,t as sourceUrl,i as studyTags,a as summary,r as title,e as titleEn};
