class Solution {
    fun snakesAndLadders(board:Array<IntArray>):Int{
        val n=board.size;
        val target=n*n;
        val queue=java.util.ArrayDeque<IntArray>();
        val seen=BooleanArray(target+1);
        queue.addLast(intArrayOf(1,0));
        seen[1]=true;
        while(queue.isNotEmpty()){
            val state=queue.removeFirst();
            if(state[0]==target)return state[1];
            for(next in state[0]+1..minOf(target,state[0]+6)){
                val quotient=(next-1)/n;
                val row=n-1-quotient;
                var column=(next-1)%n;
                if(quotient%2==1)column=n-1-column;
                val destination=if(board[row][column]==-1)next else board[row][column];
                if(!seen[destination]){
                    seen[destination]=true;
                    queue.addLast(intArrayOf(destination,state[1]+1))
                }
            }
        };
        return -1
    }
}
