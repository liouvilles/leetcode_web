class RLEIterator {
    private final long[] encoding;
    private int index;
    public RLEIterator(int[] encoding){
        this.encoding=new long[encoding.length];
        for(int i=0;i<encoding.length;i++)this.encoding[i]=encoding[i];
    }
    public int next(int n){
        long remaining=n;
        while(index<encoding.length){
            if(encoding[index]>=remaining){
                encoding[index]-=remaining;
                return(int)encoding[index+1];
            }
            remaining-=encoding[index];
            index+=2;
        }
        return -1;
    }
}
