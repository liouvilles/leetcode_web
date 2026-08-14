const u=70,n="climbing-stairs",t="Climbing Stairs",c="简单",i="动态规划",r=["数学","动态规划","记忆化搜索"],b=!1,e="https://leetcode.cn/problems/climbing-stairs/",d="爬楼梯",s=["斐波那契型 DP","状态压缩","矩阵快速幂"],a="每次可以走一级或两级台阶，计算恰好到达第 n 级的不同走法数量。",l="到达第 i 级的最后一步只有两种来源，因此 ways[i] = ways[i-1] + ways[i-2]。",o=["n 从 1 开始","ways[1] 与 ways[2] 的初值要匹配定义","矩阵法内部乘法宜使用更宽整数类型"],p=[{id:"dp-array",title:"动态规划数组",kind:"基础",idea:"显式记录从第 0 级到第 n 级的走法数，直接套用递推式。",steps:["定义 dp[0] = dp[1] = 1","从 2 开始递推","返回 dp[n]"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
`,kotlin:`class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]
    }
}
`,cpp:`class Solution {
public:
    int climbStairs(int n) {
        vector<int> dp(n + 1);
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
};
`}},{id:"rolling-dp",title:"滚动变量",kind:"最优",idea:"递推只依赖前两个状态，用两个变量滚动保存即可。",steps:["previous 与 current 表示相邻两个状态","计算 next 后整体前移","循环结束返回 current"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public int climbStairs(int n) {
        int previous = 1, current = 1;
        for (int step = 2; step <= n; step++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
`,kotlin:`class Solution {
    fun climbStairs(n: Int): Int {
        var previous = 1
        var current = 1
        for (step in 2..n) {
            val next = previous + current
            previous = current
            current = next
        }
        return current
    }
}
`,cpp:`class Solution {
public:
    int climbStairs(int n) {
        int previous = 1, current = 1;
        for (int step = 2; step <= n; ++step) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
};
`}},{id:"matrix-power",title:"矩阵快速幂",kind:"进阶",idea:"把斐波那契递推写成 2×2 矩阵乘法，再用二进制快速幂计算第 n 项。",steps:["以单位矩阵初始化 result","指数当前位为 1 时乘入 base","base 自乘且指数右移"],complexity:{time:"O(log n)",space:"O(1)"},code:{java:`class Solution {
    public int climbStairs(int n) {
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        int power = n;
        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, base);
            base = multiply(base, base);
            power >>= 1;
        }
        return (int) result[0][0];
    }

    private long[][] multiply(long[][] a, long[][] b) {
        return new long[][] {
            {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
            {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
`,kotlin:`class Solution {
    fun climbStairs(n: Int): Int {
        var result = longArrayOf(1, 0, 0, 1)
        var base = longArrayOf(1, 1, 1, 0)
        var power = n
        while (power > 0) {
            if (power and 1 == 1) result = multiply(result, base)
            base = multiply(base, base)
            power = power shr 1
        }
        return result[0].toInt()
    }

    private fun multiply(a: LongArray, b: LongArray) = longArrayOf(
        a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
        a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]
    )
}
`,cpp:`class Solution {
    using Matrix = array<long long, 4>;

public:
    int climbStairs(int n) {
        Matrix result{1, 0, 0, 1};
        Matrix base{1, 1, 1, 0};
        while (n > 0) {
            if (n & 1) result = multiply(result, base);
            base = multiply(base, base);
            n >>= 1;
        }
        return result[0];
    }

private:
    Matrix multiply(const Matrix& a, const Matrix& b) {
        return {a[0] * b[0] + a[1] * b[2], a[0] * b[1] + a[1] * b[3],
                a[2] * b[0] + a[3] * b[2], a[2] * b[1] + a[3] * b[3]};
    }
};
`}}],y={id:70,slug:n,titleEn:t,difficulty:"简单",category:i,officialTags:r,paidOnly:!1,sourceUrl:e,title:"爬楼梯",studyTags:s,summary:a,insight:l,pitfalls:o,solutions:p};export{i as category,y as default,c as difficulty,u as id,l as insight,r as officialTags,b as paidOnly,o as pitfalls,n as slug,p as solutions,e as sourceUrl,s as studyTags,a as summary,d as title,t as titleEn};
