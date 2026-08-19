class Bitset(private val size:Int){
    private val bits=BooleanArray(size);
    private var flipped=false;
    private var ones=0;
    fun fix(idx:Int){
        if(!(bits[idx] xor flipped)){
            bits[idx]=!flipped;
            ones++
        }
    }
    fun unfix(idx:Int){
        if(bits[idx] xor flipped){
            bits[idx]=flipped;
            ones--
        }
    }
    fun flip(){
        flipped=!flipped;
        ones=size-ones
    }
    fun all()=ones==size;
    fun one()=ones>0;
    fun count()=ones;
    override fun toString():String=buildString{
        for(bit in bits)append(if(bit xor flipped)'1' else '0')
    }
}
