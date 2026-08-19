class Solution {
    fun scoreOfStudents(s:String,answers:IntArray):Int{
        val count=(s.length+1)/2;
        val numbers=IntArray(count){
            s[2*it]-'0'
        };
        val operators=CharArray(count-1){
            s[2*it+1]
        };
        var correct=0;
        var term=numbers[0];
        for(i in operators.indices)if(operators[i]=='*')term*=numbers[i+1] else{
            correct+=term;
            term=numbers[i+1]
        };
        correct+=term;
        val dp=Array(count){
            arrayOfNulls<MutableSet<Int>>(count)
        };
        for(i in 0 until count)dp[i][i]=hashSetOf(numbers[i]);
        for(length in 2..count)for(left in 0..count-length){
            val right=left+length-1;
            val values=HashSet<Int>();
            for(split in left until right)for(a in dp[left][split]!!)for(b in dp[split+1][right]!!){
                val value=if(operators[split]=='+')a+b else a*b;
                if(value<=1000)values.add(value)
            };
            dp[left][right]=values
        };
        return answers.fold(0){score,answer ->
            score+if(answer==correct)5 else if(answer in dp[0][count-1]!!)2 else 0
        }
    }
}
