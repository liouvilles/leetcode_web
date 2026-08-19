class MyCircularQueue {
    private final int[] values;
    private int head,size;
    public MyCircularQueue(int k){
        values=new int[k];
    }
    public boolean enQueue(int value){
        if(isFull())return false;
        values[(head+size)%values.length]=value;
        size++;
        return true;
    }
    public boolean deQueue(){
        if(isEmpty())return false;
        head=(head+1)%values.length;
        size--;
        return true;
    }
    public int Front(){
        return isEmpty()?-1:values[head];
    }
    public int Rear(){
        return isEmpty()?-1:values[(head+size-1)%values.length];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==values.length;
    }
}
