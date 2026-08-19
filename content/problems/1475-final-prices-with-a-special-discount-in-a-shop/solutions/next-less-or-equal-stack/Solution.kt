class Solution {
    fun finalPrices(prices:IntArray):IntArray{
        val answer=prices.copyOf();
        val stack=java.util.ArrayDeque<Int>();
        for(i in prices.indices){
            while(stack.isNotEmpty()&&prices[stack.peek()]>=prices[i])answer[stack.pop()]-=prices[i];
            stack.push(i)
        };
        return answer
    }
}
