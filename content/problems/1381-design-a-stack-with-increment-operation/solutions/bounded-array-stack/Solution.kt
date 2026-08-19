class CustomStack(maxSize:Int){
    private val values=IntArray(maxSize);
    private var size=0;
    fun push(x:Int){
        if(size<values.size)values[size++]=x
    };
    fun pop():Int{
        if(size==0)return -1;
        size--;
        return values[size]
    };
    fun increment(k:Int,`val`:Int){
        for(i in 0 until minOf(k,size))values[i]+=`val`
    }
}
