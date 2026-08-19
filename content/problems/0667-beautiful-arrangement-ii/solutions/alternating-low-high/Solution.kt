class Solution {
    fun constructArray(n:Int,k:Int):IntArray{
        val answer=IntArray(n);
        var index=0;
        var left=1;
        var right=k+1;
        while(left<=right){
            answer[index++]=left++;
            if(left<=right)answer[index++]=right--
        };
        for(value in k+2..n)answer[index++]=value;
        return answer
    }
}
