class Fancy {
    static const long long MOD=1000000007;
    vector<long long> values;
    long long multiply=1,addition=0;
    long long power(long long base,long long exponent){
        long long answer=1;
        while(exponent){
            if(exponent&1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return answer;
    }
    public:Fancy(){
    }
    void append(int val){
        long long normalized=(val-addition+MOD)%MOD;
        values.push_back(normalized*power(multiply,MOD-2)%MOD);
    }
    void addAll(int inc){
        addition=(addition+inc)%MOD;
    }
    void multAll(int m){
        multiply=multiply*m%MOD;
        addition=addition*m%MOD;
    }
    int getIndex(int index){
        return index>=(int)values.size()?-1:(values[index]*multiply+addition)%MOD;
    }
};
