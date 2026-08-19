class Solution {
    fun minSwapsCouples(row:IntArray):Int{
        val position=IntArray(row.size);
        for(i in row.indices)position[row[i]]=i;
        var answer=0;
        for(i in row.indices step 2){
            val partner=row[i] xor 1;
            if(row[i+1]==partner)continue;
            val partnerSeat=position[partner];
            val displaced=row[i+1];
            row[partnerSeat]=displaced;
            row[i+1]=partner;
            position[displaced]=partnerSeat;
            position[partner]=i+1;
            answer++
        };
        return answer
    }
}
