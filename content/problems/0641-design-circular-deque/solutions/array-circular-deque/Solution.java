class MyCircularDeque {
    private final int[] values;
    private int head,size;
    public MyCircularDeque(int k){
        values=new int[k];
    }
    public boolean insertFront(int value){
        if(isFull())return false;
        head=(head-1+values.length)%values.length;
        values[head]=value;
        size++;
        return true;
    }
    public boolean insertLast(int value){
        if(isFull())return false;
        values[(head+size)%values.length]=value;
        size++;
        return true;
    }
    public boolean deleteFront(){
        if(isEmpty())return false;
        head=(head+1)%values.length;
        size--;
        return true;
    }
    public boolean deleteLast(){
        if(isEmpty())return false;
        size--;
        return true;
    }
    public int getFront(){
        return isEmpty()?-1:values[head];
    }
    public int getRear(){
        return isEmpty()?-1:values[(head+size-1)%values.length];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==values.length;
    }
}
