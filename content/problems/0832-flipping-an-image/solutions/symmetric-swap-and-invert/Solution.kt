class Solution {
    fun flipAndInvertImage(image:Array<IntArray>):Array<IntArray>{
        for(row in image){
            var left=0;
            var right=row.lastIndex;
            while(left<=right){
                val first=row[left];
                val second=row[right];
                row[left]=second xor 1;
                row[right]=first xor 1;
                left++;
                right--
            }
        };
        return image
    }
}
