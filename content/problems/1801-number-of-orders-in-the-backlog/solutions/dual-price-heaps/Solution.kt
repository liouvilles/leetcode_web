class Solution {
    fun getNumberOfBacklogOrders(orders:Array<IntArray>):Int{
        val buy=java.util.PriorityQueue<IntArray>{
            a,b->b[0]-a[0]
        };
        val sell=java.util.PriorityQueue<IntArray>(compareBy{
            it[0]
        });
        for(order in orders){
            val price=order[0];
            var amount=order[1];
            if(order[2]==0){
                while(amount>0&&sell.isNotEmpty()&&sell.peek()[0]<=price){
                    val other=sell.peek();
                    val traded=minOf(amount,other[1]);
                    amount-=traded;
                    other[1]-=traded;
                    if(other[1]==0)sell.remove()
                };
                if(amount>0)buy.add(intArrayOf(price,amount))
            }else{
                while(amount>0&&buy.isNotEmpty()&&buy.peek()[0]>=price){
                    val other=buy.peek();
                    val traded=minOf(amount,other[1]);
                    amount-=traded;
                    other[1]-=traded;
                    if(other[1]==0)buy.remove()
                };
                if(amount>0)sell.add(intArrayOf(price,amount))
            }
        };
        return ((buy.sumOf{
            it[1].toLong()
        }+sell.sumOf{
            it[1].toLong()
        })%1_000_000_007).toInt()
    }
}
