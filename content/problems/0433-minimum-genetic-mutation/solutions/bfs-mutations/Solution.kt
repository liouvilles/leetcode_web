class Solution {
    fun minMutation(start:String,end:String,bank:Array<String>):Int{
        if(start==end)return 0;
        val available=bank.toMutableSet();
        if(end !in available)return -1;
        val queue=ArrayDeque<String>();
        queue.addLast(start);
        val genes=charArrayOf('A','C','G','T');
        var steps=0;
        while(queue.isNotEmpty()){
            steps++;
            repeat(queue.size){
                val current=queue.removeFirst().toCharArray();
                for(i in current.indices){
                    val original=current[i];
                    for(gene in genes){
                        current[i]=gene;
                        val next=String(current);
                        if(next==end)return steps;
                        if(available.remove(next))queue.addLast(next)
                    };
                    current[i]=original
                }
            }
        };
        return -1
    }
}
