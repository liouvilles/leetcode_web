class Allocator(n:Int) {
    private val memory=IntArray(n);
    fun allocate(size:Int,mID:Int):Int{
        var run=0;
        for(i in memory.indices){
            run=if(memory[i]==0)run+1 else 0;
            if(run==size){
                val start=i-size+1;
                for(position in start..i)memory[position]=mID;
                return start
            }
        };
        return -1
    }
    fun freeMemory(mID:Int):Int{
        var released=0;
        for(i in memory.indices)if(memory[i]==mID){
            memory[i]=0;
            released++
        };
        return released
    }
}
