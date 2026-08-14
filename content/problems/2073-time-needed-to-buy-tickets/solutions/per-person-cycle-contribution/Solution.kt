class Solution { fun timeRequiredToBuy(tickets:IntArray,k:Int)=tickets.indices.sumOf{minOf(tickets[it],tickets[k]-if(it>k)1 else 0)} }
