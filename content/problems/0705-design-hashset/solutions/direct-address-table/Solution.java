class MyHashSet {
    private final boolean[] present=new boolean[1000001];
    public MyHashSet(){
    }
    public void add(int key){
        present[key]=true;
    }
    public void remove(int key){
        present[key]=false;
    }
    public boolean contains(int key){
        return present[key];
    }
}
