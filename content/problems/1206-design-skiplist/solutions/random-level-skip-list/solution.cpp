class Skiplist {
    static const int MAX_LEVEL=16;
    struct Node{
        int value;
        array<Node*,MAX_LEVEL> next{
        };
        Node(int value):value(value){
        }
    };
    Node* head=new Node(-1);
    unsigned seed=1;
    array<Node*,MAX_LEVEL> predecessors(int target){
        array<Node*,MAX_LEVEL> update;
        Node* node=head;
        for(int level=MAX_LEVEL-1;level>=0;--level){
            while(node->next[level]&&node->next[level]->value<target)node=node->next[level];
            update[level]=node;
        }
        return update;
    }
    int randomLevel(){
        int level=1;
        while(level<MAX_LEVEL){
            seed=seed*1103515245u+12345u;
            if(seed&1u)break;
            ++level;
        }
        return level;
    }
    public:bool search(int target){
        Node* node=predecessors(target)[0]->next[0];
        return node&&node->value==target;
    }
    void add(int num){
        auto update=predecessors(num);
        Node* node=new Node(num);
        for(int level=0,limit=randomLevel();level<limit;++level){
            node->next[level]=update[level]->next[level];
            update[level]->next[level]=node;
        }
    }
    bool erase(int num){
        auto update=predecessors(num);
        Node* target=update[0]->next[0];
        if(!target||target->value!=num)return false;
        for(int level=0;level<MAX_LEVEL&&update[level]->next[level]==target;++level)update[level]->next[level]=target->next[level];
        delete target;
        return true;
    }
};
