class MyLinkedList {
    struct Node{
        int value;
        Node* previous;
        Node* next;
        Node(int value):value(value),previous(nullptr),next(nullptr){
        }
    };
    Node* head;
    Node* tail;
    int size=0;
    Node* nodeAt(int index){
        if(index<size/2){
            Node* node=head->next;
            while(index--)node=node->next;
            return node;
        }
        Node* node=tail->previous;
        for(int current=size-1;current>index;--current)node=node->previous;
        return node;
    }
    void insertBefore(Node* next,int value){
        Node* node=new Node(value);
        Node* previous=next->previous;
        previous->next=node;
        node->previous=previous;
        node->next=next;
        next->previous=node;
        ++size;
    }
    public:MyLinkedList(){
        head=new Node(0);
        tail=new Node(0);
        head->next=tail;
        tail->previous=head;
    }
    int get(int index){
        return index<0||index>=size?-1:nodeAt(index)->value;
    }
    void addAtHead(int val){
        insertBefore(head->next,val);
    }
    void addAtTail(int val){
        insertBefore(tail,val);
    }
    void addAtIndex(int index,int val){
        index=max(index,0);
        if(index>size)return;
        insertBefore(index==size?tail:nodeAt(index),val);
    }
    void deleteAtIndex(int index){
        if(index<0||index>=size)return;
        Node* node=nodeAt(index);
        node->previous->next=node->next;
        node->next->previous=node->previous;
        delete node;
        --size;
    }
};
