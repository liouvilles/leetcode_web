class Solution {
    fun numberOfSets(n:Int,maxDistance:Int,roads:Array<IntArray>):Int{
        val inf=1_000_000_000;
        var answer=0;
        for(mask in 0 until (1 shl n)){
            val distance=Array(n){
                IntArray(n){
                    inf
                }
            };
            for(i in 0 until n)distance[i][i]=0;
            for(road in roads)if(mask shr road[0] and 1==1&&mask shr road[1] and 1==1){
                distance[road[0]][road[1]]=minOf(distance[road[0]][road[1]],road[2]);
                distance[road[1]][road[0]]=minOf(distance[road[1]][road[0]],road[2])
            };
            for(middle in 0 until n)if(mask shr middle and 1==1)for(from in 0 until n)if(mask shr from and 1==1)for(to in 0 until n)if(mask shr to and 1==1)distance[from][to]=minOf(distance[from][to],distance[from][middle]+distance[middle][to]);
            var valid=true;
            loop@for(i in 0 until n)if(mask shr i and 1==1)for(j in i+1 until n)if(mask shr j and 1==1&&distance[i][j]>maxDistance){
                valid=false;
                break@loop
            };
            if(valid)answer++
        };
        return answer
    }
}
