class MyStack {
    private final Queue<Integer> queue=new ArrayDeque<>();
    public void push(int x){
        queue.offer(x);
        for(int i=queue.size()-1;i>0;i--)queue.offer(queue.poll());
    }
    public int pop(){
        return queue.remove();
    }
    public int top(){
        return queue.element();
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
