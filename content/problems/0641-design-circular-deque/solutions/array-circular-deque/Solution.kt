class MyCircularDeque(k:Int){
    private val values=IntArray(k);
    private var head=0;
    private var size=0;
    fun insertFront(value:Int):Boolean{
        if(isFull())return false;
        head=(head-1+values.size)%values.size;
        values[head]=value;
        size++;
        return true
    };
    fun insertLast(value:Int):Boolean{
        if(isFull())return false;
        values[(head+size)%values.size]=value;
        size++;
        return true
    };
    fun deleteFront():Boolean{
        if(isEmpty())return false;
        head=(head+1)%values.size;
        size--;
        return true
    };
    fun deleteLast():Boolean{
        if(isEmpty())return false;
        size--;
        return true
    };
    fun getFront():Int=if(isEmpty())-1 else values[head];
    fun getRear():Int=if(isEmpty())-1 else values[(head+size-1)%values.size];
    fun isEmpty():Boolean=size==0;
    fun isFull():Boolean=size==values.size
}
