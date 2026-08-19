class Solution {
    fun lexicalOrder(n:Int):List<Int>{
        val answer=ArrayList<Int>(n);
        var current=1;
        repeat(n){
            answer.add(current);
            if(current.toLong()*10<=n)current*=10 else{
                while(current%10==9||current+1>n)current/=10;
                current++
            }
        };
        return answer
    }
}
