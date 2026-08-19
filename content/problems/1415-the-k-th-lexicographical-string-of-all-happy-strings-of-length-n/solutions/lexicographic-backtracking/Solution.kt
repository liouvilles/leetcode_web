class Solution {
    private var count=0;
    private var k=0;
    private var n=0;
    private var answer="";
    private fun generate(current:StringBuilder):Boolean{
        if(current.length==n){
            count++;
            if(count==k){
                answer=current.toString();
                return true
            };
            return false
        };
        for(value in 'a'..'c'){
            if(current.isNotEmpty()&&current.last()==value)continue;
            current.append(value);
            if(generate(current))return true;
            current.deleteCharAt(current.lastIndex)
        };
        return false
    };
    fun getHappyString(n:Int,k:Int):String{
        this.n=n;
        this.k=k;
        generate(StringBuilder());
        return answer
    }
}
