class Solution {
    fun getLucky(s:String,k:Int):Int{
        var value=0;
        for(letter in s){
            val number=letter-'a'+1;
            value+=number/10+number%10
        };
        repeat(k-1){
            var next=0;
            while(value>0){
                next+=value%10;
                value/=10
            };
            value=next
        };
        return value
    }
}
