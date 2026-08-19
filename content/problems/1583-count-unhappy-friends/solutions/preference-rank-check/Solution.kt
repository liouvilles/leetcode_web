class Solution {
    fun unhappyFriends(n:Int,preferences:Array<IntArray>,pairs:Array<IntArray>):Int{
        val rank=Array(n){
            IntArray(n)
        };
        for(person in 0 until n)for(order in 0 until n-1)rank[person][preferences[person][order]]=order;
        val partner=IntArray(n);
        for(pair in pairs){
            partner[pair[0]]=pair[1];
            partner[pair[1]]=pair[0]
        };
        var answer=0;
        for(x in 0 until n)for(u in preferences[x]){
            if(u==partner[x])break;
            if(rank[u][x]<rank[u][partner[u]]){
                answer++;
                break
            }
        };
        return answer
    }
}
