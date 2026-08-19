class MyCircularQueue(k:Int){
    private val values=IntArray(k);
    private var head=0;
    private var size=0;
    fun enQueue(value:Int):Boolean{
        if(isFull())return false;
        values[(head+size)%values.size]=value;
        size++;
        return true
    };
    fun deQueue():Boolean{
        if(isEmpty())return false;
        head=(head+1)%values.size;
        size--;
        return true
    };
    fun Front():Int=if(isEmpty())-1 else values[head];
    fun Rear():Int=if(isEmpty())-1 else values[(head+size-1)%values.size];
    fun isEmpty():Boolean=size==0;
    fun isFull():Boolean=size==values.size
}
