class Solution {
    fun chalkReplacer(chalk:IntArray,k:Int):Int{
        val sum=chalk.sumOf{
            it.toLong()
        };
        var remaining=k%sum;
        for(i in chalk.indices){
            if(remaining<chalk[i])return i;
            remaining-=chalk[i]
        };
        return 0
    }
}
