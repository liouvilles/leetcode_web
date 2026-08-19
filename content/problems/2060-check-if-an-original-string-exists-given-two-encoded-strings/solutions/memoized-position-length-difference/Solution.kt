class Solution {
    private lateinit var first:String;
    private lateinit var second:String;
    private val failed=HashSet<String>();
    private fun digit(value:Char)=value.isDigit();
    private fun dfs(i:Int,j:Int,difference:Int):Boolean{
        if(i==first.length&&j==second.length)return difference==0;
        val key="$i,$j,$difference";
        if(key in failed)return false;
        if(i<first.length&&digit(first[i])){
            var value=0;
            var end=i;
            while(end<first.length&&end<i+3&&digit(first[end])){
                value=value*10+first[end].digitToInt();
                if(dfs(end+1,j,difference+value))return true;
                end++
            }
        }else if(j<second.length&&digit(second[j])){
            var value=0;
            var end=j;
            while(end<second.length&&end<j+3&&digit(second[end])){
                value=value*10+second[end].digitToInt();
                if(dfs(i,end+1,difference-value))return true;
                end++
            }
        }else if(difference<0&&i<first.length&&dfs(i+1,j,difference+1))return true else if(difference>0&&j<second.length&&dfs(i,j+1,difference-1))return true else if(difference==0&&i<first.length&&j<second.length&&first[i]==second[j]&&dfs(i+1,j+1,0))return true;
        failed.add(key);
        return false
    };
    fun possiblyEquals(s1:String,s2:String):Boolean{
        first=s1;
        second=s2;
        failed.clear();
        return dfs(0,0,0)
    }
}
