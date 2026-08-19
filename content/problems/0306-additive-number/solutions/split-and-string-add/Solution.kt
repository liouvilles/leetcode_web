class Solution {
    fun isAdditiveNumber(num:String):Boolean{
        fun add(a:String,b:String):String{
            val out=StringBuilder();
            var i=a.lastIndex;
            var j=b.lastIndex;
            var carry=0;
            while(i>=0||j>=0||carry>0){
                val value=carry+(if(i>=0)a[i--]-'0' else 0)+(if(j>=0)b[j--]-'0' else 0);
                out.append(value%10);
                carry=value/10
            };
            return out.reverse().toString()
        };
        for(i in 1 until num.lastIndex){
            if(num[0]=='0'&&i>1)break;
            for(j in i+1 until num.length){
                if(num[i]=='0'&&j-i>1)break;
                var a=num.substring(0,i);
                var b=num.substring(i,j);
                var index=j;
                while(index<num.length){
                    val sum=add(a,b);
                    if(!num.startsWith(sum,index))break;
                    index+=sum.length;
                    a=b;
                    b=sum
                };
                if(index==num.length)return true
            }
        };
        return false
    }
}
