class FreqStack {
    private val frequency=mutableMapOf<Int,Int>();
    private val groups=mutableMapOf<Int,java.util.ArrayDeque<Int>>();
    private var maximum=0;
    fun push(value:Int){
        val count=(frequency[value]?:0)+1;
        frequency[value]=count;
        maximum=maxOf(maximum,count);
        groups.getOrPut(count){
            java.util.ArrayDeque()
        }.push(value)
    };
    fun pop():Int{
        val stack=groups[maximum]!!;
        val value=stack.pop();
        frequency[value]=frequency[value]!!-1;
        if(stack.isEmpty())maximum--;
        return value
    }
}
