class Bitset {
    vector<char> bits;
    bool flipped=false;
    int ones=0;
    public:Bitset(int size):bits(size){
    }
    void fix(int idx){
        if(!(bits[idx]^flipped)){
            bits[idx]=!flipped;
            ++ones;
        }
    }
    void unfix(int idx){
        if(bits[idx]^flipped){
            bits[idx]=flipped;
            --ones;
        }
    }
    void flip(){
        flipped=!flipped;
        ones=bits.size()-ones;
    }
    bool all(){
        return ones==(int)bits.size();
    }
    bool one(){
        return ones>0;
    }
    int count(){
        return ones;
    }
    string toString(){
        string value;
        for(bool bit:bits)value+=bit^flipped?'1':'0';
        return value;
    }
};
