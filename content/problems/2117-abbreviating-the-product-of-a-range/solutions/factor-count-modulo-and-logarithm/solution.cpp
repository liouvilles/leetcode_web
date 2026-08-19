class Solution {
    public:string abbreviateProduct(int left,int right){
        const long long modulo=10000000000LL;
        long long value=1;
        int twos=0,fives=0;
        long double logarithm=0;
        for(int number=left;number<=right;++number){
            logarithm+=log10((long double)number);
            int current=number;
            while(current%2==0){
                ++twos;
                current/=2;
            }while(current%5==0){
                ++fives;
                current/=5;
            }
            value=value*current%modulo;
        }
        int zeros=min(twos,fives);
        for(int i=0;i<twos-zeros;++i)value=value*2%modulo;
        for(int i=0;i<fives-zeros;++i)value=value*5%modulo;
        logarithm-=zeros;
        int digits=floor(logarithm+1e-12)+1;
        if(digits<=10)return to_string(value)+"e"+to_string(zeros);
        long long leading=pow((long double)10,logarithm-floor(logarithm)+4);
        if(leading>=100000)leading/=10;
        ostringstream out;
        out<<leading<<"..."<<setw(5)<<setfill('0')<<value%100000<<"e"<<zeros;
        return out.str();
    }
};
