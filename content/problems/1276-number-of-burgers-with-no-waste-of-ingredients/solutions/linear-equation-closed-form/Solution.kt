class Solution {
    fun numOfBurgers(tomatoSlices:Int,cheeseSlices:Int):List<Int>{
        val difference=tomatoSlices-2*cheeseSlices;
        if(difference<0||difference%2!=0)return emptyList();
        val jumbo=difference/2;
        val small=cheeseSlices-jumbo;
        return if(small<0)emptyList() else listOf(jumbo,small)
    }
}
