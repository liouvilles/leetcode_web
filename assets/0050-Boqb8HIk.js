const c=50,n="powx-n",o="Pow(x, n)",u="中等",e="搜索与回溯",s=["数学","递归"],b=!1,t="https://leetcode.cn/problems/powx-n/",r="Pow(x, n)",i=["快速幂","二进制拆分","负指数"],l="计算浮点数 x 的整数次幂，并正确处理负指数和 32 位指数边界。",a="把指数按二进制拆分；每轮平方底数，当前位为一时乘入答案，使乘法次数降为对数级。",w=["先把指数转成长整型再取负，避免最小整数溢出","负指数等价于底数取倒数","指数为零时结果为一"],p=[{id:"binary-exponentiation",title:"迭代快速幂",kind:"最优",idea:"用指数二进制位决定是否乘入当前底数，并逐轮平方。",steps:["将 n 转为 long，负数时底数取倒数并翻转指数","若当前最低位为一则 answer*=base","base 自乘，指数右移"],complexity:{time:"O(log |n|)",space:"O(1)"},code:{java:`class Solution {
    public double myPow(double x, int n) {
        long power = n; if (power < 0) { x = 1.0 / x; power = -power; }
        double answer = 1.0;
        while (power > 0) { if ((power & 1) == 1) answer *= x; x *= x; power >>= 1; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun myPow(input: Double, n: Int): Double {
        var base = input; var power = n.toLong(); if (power < 0) { base = 1.0 / base; power = -power }
        var answer = 1.0
        while (power > 0) { if (power and 1L == 1L) answer *= base; base *= base; power = power shr 1 }
        return answer
    }
}
`,cpp:`class Solution {
public:
    double myPow(double x, int n) {
        long long power = n; if (power < 0) { x = 1.0 / x; power = -power; }
        double answer = 1.0;
        while (power > 0) { if (power & 1LL) answer *= x; x *= x; power >>= 1; }
        return answer;
    }
};
`}}],d={id:50,slug:n,titleEn:o,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:t,title:r,studyTags:i,summary:l,insight:a,pitfalls:w,solutions:p};export{e as category,d as default,u as difficulty,c as id,a as insight,s as officialTags,b as paidOnly,w as pitfalls,n as slug,p as solutions,t as sourceUrl,i as studyTags,l as summary,r as title,o as titleEn};
