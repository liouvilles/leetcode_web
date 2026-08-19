class NumberContainers {
    private val indexToNumber=HashMap<Int,Int>();
    private val numberToIndices=HashMap<Int,java.util.TreeSet<Int>>();
    fun change(index:Int,number:Int){
        indexToNumber[index]?.let{
            numberToIndices[it]!!.remove(index)
        };
        indexToNumber[index]=number;
        numberToIndices.getOrPut(number){
            java.util.TreeSet()
        }.add(index)
    }
    fun find(number:Int):Int{
        return numberToIndices[number]?.firstOrNull()?:-1
    }
}
