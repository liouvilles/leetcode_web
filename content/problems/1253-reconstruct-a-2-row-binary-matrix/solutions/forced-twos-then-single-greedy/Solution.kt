class Solution {
    fun reconstructMatrix(upperValue:Int,lowerValue:Int,colsum:IntArray):List<List<Int>>{
        var upper=upperValue;
        var lower=lowerValue;
        val top=IntArray(colsum.size);
        val bottom=IntArray(colsum.size);
        for(i in colsum.indices)if(colsum[i]==2){
            top[i]=1;
            bottom[i]=1;
            upper--;
            lower--
        };
        if(upper<0||lower<0)return emptyList();
        for(i in colsum.indices)if(colsum[i]==1){
            if(upper>0){
                top[i]=1;
                upper--
            }else{
                bottom[i]=1;
                lower--
            }
        };
        if(upper!=0||lower!=0)return emptyList();
        return listOf(top.toList(),bottom.toList())
    }
}
