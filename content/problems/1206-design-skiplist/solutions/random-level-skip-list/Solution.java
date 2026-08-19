class Skiplist {
    private static final int MAX_LEVEL=16;
    private static class Node{
        int value;
        Node[] next;
        Node(int value){
            this.value=value;
            next=new Node[MAX_LEVEL];
        }
    }
    private final Node head=new Node(-1);
    private int seed=1;
    private Node[] predecessors(int target){
        Node[] update=new Node[MAX_LEVEL];
        Node node=head;
        for(int level=MAX_LEVEL-1;level>=0;level--){
            while(node.next[level]!=null&&node.next[level].value<target)node=node.next[level];
            update[level]=node;
        }
        return update;
    }
    private int randomLevel(){
        int level=1;
        while(level<MAX_LEVEL){
            seed=seed*1103515245+12345;
            if((seed&1)!=0)break;
            level++;
        }
        return level;
    }
    public boolean search(int target){
        Node node=predecessors(target)[0].next[0];
        return node!=null&&node.value==target;
    }
    public void add(int num){
        Node[] update=predecessors(num);
        Node node=new Node(num);
        int limit=randomLevel();
        for(int level=0;level<limit;level++){
            node.next[level]=update[level].next[level];
            update[level].next[level]=node;
        }
    }
    public boolean erase(int num){
        Node[] update=predecessors(num);
        Node target=update[0].next[0];
        if(target==null||target.value!=num)return false;
        for(int level=0;level<MAX_LEVEL&&update[level].next[level]==target;level++)update[level].next[level]=target.next[level];
        return true;
    }
}
