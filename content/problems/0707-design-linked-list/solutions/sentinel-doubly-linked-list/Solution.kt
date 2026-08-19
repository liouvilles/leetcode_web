class MyLinkedList {
    private class Node(val value:Int){
        var previous:Node?=null;
        var next:Node?=null
    };
    private val head=Node(0);
    private val tail=Node(0);
    private var size=0;
    init{
        head.next=tail;
        tail.previous=head
    };
    fun get(index:Int):Int=if(index !in 0 until size)-1 else nodeAt(index).value;
    fun addAtHead(`val`:Int){
        insertBefore(head.next!!,`val`)
    };
    fun addAtTail(`val`:Int){
        insertBefore(tail,`val`)
    };
    fun addAtIndex(indexValue:Int,`val`:Int){
        val index=maxOf(indexValue,0);
        if(index>size)return;
        insertBefore(if(index==size)tail else nodeAt(index),`val`)
    };
    fun deleteAtIndex(index:Int){
        if(index !in 0 until size)return;
        val node=nodeAt(index);
        node.previous!!.next=node.next;
        node.next!!.previous=node.previous;
        size--
    };
    private fun insertBefore(next:Node,value:Int){
        val node=Node(value);
        val previous=next.previous!!;
        previous.next=node;
        node.previous=previous;
        node.next=next;
        next.previous=node;
        size++
    };
    private fun nodeAt(index:Int):Node{
        if(index<size/2){
            var node=head.next!!;
            repeat(index){
                node=node.next!!
            };
            return node
        };
        var node=tail.previous!!;
        for(current in size-1 downTo index+1)node=node.previous!!;
        return node
    }
}
