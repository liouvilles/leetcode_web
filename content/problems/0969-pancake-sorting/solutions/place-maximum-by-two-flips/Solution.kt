class Solution {
    fun pancakeSort(arr:IntArray):List<Int>{
        val moves=mutableListOf<Int>();
        fun flip(length:Int){
            var left=0;
            var right=length-1;
            while(left<right){
                val temporary=arr[left];
                arr[left++]=arr[right];
                arr[right--]=temporary
            }
        };
        for(size in arr.size downTo 2){
            var index=0;
            for(i in 1 until size)if(arr[i]>arr[index])index=i;
            if(index==size-1)continue;
            if(index>0){
                flip(index+1);
                moves.add(index+1)
            };
            flip(size);
            moves.add(size)
        };
        return moves
    }
}
