class DataStream {
    private final int value,k;
    private int streak=0;
    public DataStream(int value,int k){
        this.value=value;
        this.k=k;
    }
    public boolean consec(int num){
        streak=num==value?streak+1:0;
        return streak>=k;
    }
}
