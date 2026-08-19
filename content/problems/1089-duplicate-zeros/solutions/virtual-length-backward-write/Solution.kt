class Solution {
    fun duplicateZeros(arr:IntArray){
        val zeros=arr.count{
            it==0
        };
        var read=arr.lastIndex;
        var write=arr.size+zeros-1;
        while(read>=0){
            val value=arr[read--];
            if(write<arr.size)arr[write]=value;
            write--;
            if(value==0){
                if(write<arr.size)arr[write]=0;
                write--
            }
        }
    }
}
