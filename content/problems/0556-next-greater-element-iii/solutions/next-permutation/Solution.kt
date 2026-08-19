class Solution {
    fun nextGreaterElement(n:Int):Int{
        val digits=n.toString().toCharArray();
        var pivot=digits.size-2;
        while(pivot>=0&&digits[pivot]>=digits[pivot+1])pivot--;
        if(pivot<0)return -1;
        var successor=digits.lastIndex;
        while(digits[successor]<=digits[pivot])successor--;
        var value=digits[pivot];
        digits[pivot]=digits[successor];
        digits[successor]=value;
        var left=pivot+1;
        var right=digits.lastIndex;
        while(left<right){
            value=digits[left];
            digits[left++]=digits[right];
            digits[right--]=value
        };
        val answer=String(digits).toLong();
        return if(answer>Int.MAX_VALUE)-1 else answer.toInt()
    }
}
