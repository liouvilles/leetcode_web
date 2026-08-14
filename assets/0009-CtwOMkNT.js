const a=9,e="palindrome-number",n="Palindrome Number",c="简单",v="数学",r=["数学"],u=!1,s="https://leetcode.cn/problems/palindrome-number/",x="回文数",t=["数字反转","只反转一半","边界判断"],l="判断一个整数从左向右和从右向左读取时是否相同，且不把数字转换成字符串。",i="只需反转数字的后一半，当原数字缩短到不大于反转部分时即可比较，避免完整反转溢出。",o=["负数一定不是回文数","除零本身外，末位为零的数不可能回文","奇数位数字比较时要丢弃中间位"],d=[{id:"reverse-half",title:"反转后一半数字",kind:"最优",idea:"逐位把原数字末尾移到 reversed 中，直到 reversed 的位数达到原数字的一半。",steps:["排除负数和非零末位零","循环反转末位直到 x <= reversed","比较两半，奇数位时忽略 reversed 的末位"],complexity:{time:"O(log x)",space:"O(1)"},code:{java:`class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
`,kotlin:`class Solution {
    fun isPalindrome(value: Int): Boolean {
        if (value < 0 || (value % 10 == 0 && value != 0)) return false
        var x = value
        var reversed = 0
        while (x > reversed) {
            reversed = reversed * 10 + x % 10
            x /= 10
        }
        return x == reversed || x == reversed / 10
    }
}
`,cpp:`class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
};
`}}],f={id:9,slug:e,titleEn:n,difficulty:"简单",category:"数学",officialTags:r,paidOnly:!1,sourceUrl:s,title:"回文数",studyTags:t,summary:l,insight:i,pitfalls:o,solutions:d};export{v as category,f as default,c as difficulty,a as id,i as insight,r as officialTags,u as paidOnly,o as pitfalls,e as slug,d as solutions,s as sourceUrl,t as studyTags,l as summary,x as title,n as titleEn};
