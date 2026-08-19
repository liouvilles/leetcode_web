class SmallestInfiniteSet {
    int current=1;
    TreeSet<Integer> addedBack=new TreeSet<>();
    public SmallestInfiniteSet(){
    }
    public int popSmallest(){
        return addedBack.isEmpty()?current++:addedBack.pollFirst();
    }
    public void addBack(int num){
        if(num<current)addedBack.add(num);
    }
}
