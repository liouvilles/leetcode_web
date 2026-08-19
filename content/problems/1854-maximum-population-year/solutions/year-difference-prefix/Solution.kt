class Solution {
    fun maximumPopulation(logs:Array<IntArray>):Int{
        val difference=IntArray(101);
        for(log in logs){
            difference[log[0]-1950]++;
            difference[log[1]-1950]--
        };
        var population=0;
        var maximum=0;
        var answer=1950;
        for(year in 0 until 100){
            population+=difference[year];
            if(population>maximum){
                maximum=population;
                answer=1950+year
            }
        };
        return answer
    }
}
