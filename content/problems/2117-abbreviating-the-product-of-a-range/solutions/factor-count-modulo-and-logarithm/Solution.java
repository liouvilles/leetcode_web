class Solution {
    public String abbreviateProduct(int left,int right){
        long modulo=10_000_000_000L,value=1;
        int twos=0,fives=0;
        double logarithm=0;
        for(int number=left;number<=right;number++){
            logarithm+=Math.log10(number);
            int current=number;
            while(current%2==0){
                twos++;
                current/=2;
            }while(current%5==0){
                fives++;
                current/=5;
            }
            value=value*current%modulo;
        }
        int zeros=Math.min(twos,fives);
        for(int i=0;i<twos-zeros;i++)value=value*2%modulo;
        for(int i=0;i<fives-zeros;i++)value=value*5%modulo;
        logarithm-=zeros;
        int digits=(int)Math.floor(logarithm+1e-10)+1;
        if(digits<=10)return value+"e"+zeros;
        long leading=(long)Math.pow(10,logarithm-Math.floor(logarithm)+4);
        if(leading>=100000)leading/=10;
        return leading+"..."+String.format("%05d",value%100000)+"e"+zeros;
    }
}
