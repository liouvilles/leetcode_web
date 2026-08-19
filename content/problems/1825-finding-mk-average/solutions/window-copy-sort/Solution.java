class MKAverage {
    int m,k;
    Deque<Integer> window=new ArrayDeque<>();
    public MKAverage(int m,int k){
        this.m=m;
        this.k=k;
    }
    public void addElement(int num){
        window.offerLast(num);
        if(window.size()>m)window.pollFirst();
    }
    public int calculateMKAverage(){
        if(window.size()<m)return -1;
        List<Integer> values=new ArrayList<>(window);
        Collections.sort(values);
        long sum=0;
        for(int i=k;i<m-k;i++)sum+=values.get(i);
        return (int)(sum/(m-2*k));
    }
}
