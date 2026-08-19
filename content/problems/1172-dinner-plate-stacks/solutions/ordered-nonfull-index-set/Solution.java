class DinnerPlates {
    private final int capacity;
    private final List<ArrayDeque<Integer>> stacks=new ArrayList<>();
    private final TreeSet<Integer> available=new TreeSet<>();
    public DinnerPlates(int capacity){
        this.capacity=capacity;
    }
    public void push(int val){
        int index;
        if(available.isEmpty()){
            index=stacks.size();
            stacks.add(new ArrayDeque<>());
        }else index=available.first();
        ArrayDeque<Integer> stack=stacks.get(index);
        stack.push(val);
        if(stack.size()==capacity)available.remove(index);
        else available.add(index);
    }
    public int pop(){
        return stacks.isEmpty()?-1:popAtStack(stacks.size()-1);
    }
    public int popAtStack(int index){
        if(index<0||index>=stacks.size()||stacks.get(index).isEmpty())return -1;
        int value=stacks.get(index).pop();
        available.add(index);
        while(!stacks.isEmpty()&&stacks.get(stacks.size()-1).isEmpty()){
            int last=stacks.size()-1;
            stacks.remove(last);
            available.remove(last);
        }
        return value;
    }
}
