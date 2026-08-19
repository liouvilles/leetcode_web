class Solution {
    fun addNegabinary(arr1:IntArray,arr2:IntArray):IntArray{
        val reversed=mutableListOf<Int>();
        var i=arr1.lastIndex;
        var j=arr2.lastIndex;
        var carry=0;
        while(i>=0||j>=0||carry!=0){
            val sum=carry+(if(i>=0)arr1[i--] else 0)+(if(j>=0)arr2[j--] else 0);
            val bit=sum and 1;
            reversed.add(bit);
            carry=-(sum-bit)/2
        };
        while(reversed.size>1&&reversed.last()==0)reversed.removeAt(reversed.lastIndex);
        reversed.reverse();
        return reversed.toIntArray()
    }
}
