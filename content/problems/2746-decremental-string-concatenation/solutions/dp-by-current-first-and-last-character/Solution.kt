class Solution {
    fun minimizeConcatenatedLength(words:Array<String>):Int{
        val inf=1000000000;
        var dp=Array(26){
            IntArray(26){
                inf
            }
        };
        val firstWord=words[0];
        dp[firstWord.first()-'a'][firstWord.last()-'a']=firstWord.length;
        for(index in 1 until words.size){
            val word=words[index];
            val a=word.first()-'a';
            val b=word.last()-'a';
            val length=word.length;
            val next=Array(26){
                IntArray(26){
                    inf
                }
            };
            for(first in 0 until 26)for(last in 0 until 26)if(dp[first][last]<inf){
                next[first][b]=minOf(next[first][b],dp[first][last]+length-if(last==a)1 else 0);
                next[a][last]=minOf(next[a][last],dp[first][last]+length-if(b==first)1 else 0)
            };
            dp=next
        };
        var answer=inf;
        for(row in dp)for(value in row)answer=minOf(answer,value);
        return answer
    }
}
