class MyLinkedList {
    private static class Node{
        int value;
        Node previous,next;
        Node(int value){
            this.value=value;
        }
    }
    private final Node head=new Node(0),tail=new Node(0);
    private int size;
    public MyLinkedList(){
        head.next=tail;
        tail.previous=head;
    }
    public int get(int index){
        return index<0||index>=size?-1:nodeAt(index).value;
    }
    public void addAtHead(int val){
        insertBefore(head.next,val);
    }
    public void addAtTail(int val){
        insertBefore(tail,val);
    }
    public void addAtIndex(int index,int val){
        if(index<0)index=0;
        if(index>size)return;
        insertBefore(index==size?tail:nodeAt(index),val);
    }
    public void deleteAtIndex(int index){
        if(index<0||index>=size)return;
        Node node=nodeAt(index);
        node.previous.next=node.next;
        node.next.previous=node.previous;
        size--;
    }
    private void insertBefore(Node next,int value){
        Node node=new Node(value),previous=next.previous;
        previous.next=node;
        node.previous=previous;
        node.next=next;
        next.previous=node;
        size++;
    }
    private Node nodeAt(int index){
        if(index<size/2){
            Node node=head.next;
            while(index-->0)node=node.next;
            return node;
        }
        Node node=tail.previous;
        for(int current=size-1;current>index;current--)node=node.previous;
        return node;
    }
}
