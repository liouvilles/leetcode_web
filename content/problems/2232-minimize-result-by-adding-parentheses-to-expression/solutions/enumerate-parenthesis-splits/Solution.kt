class Solution {
    fun minimizeResult(expression:String):String{
        val parts=expression.split('+');
        val left=parts[0];
        val right=parts[1];
        var answer="";
        var best=Int.MAX_VALUE;
        for(i in left.indices)for(j in 1..right.length){
            val outsideLeft=if(i==0)1 else left.substring(0,i).toInt();
            val insideLeft=left.substring(i).toInt();
            val insideRight=right.substring(0,j).toInt();
            val outsideRight=if(j==right.length)1 else right.substring(j).toInt();
            val value=outsideLeft*(insideLeft+insideRight)*outsideRight;
            if(value<best){
                best=value;
                answer=left.substring(0,i)+"("+left.substring(i)+"+"+right.substring(0,j)+")"+right.substring(j)
            }
        };
        return answer
    }
}
