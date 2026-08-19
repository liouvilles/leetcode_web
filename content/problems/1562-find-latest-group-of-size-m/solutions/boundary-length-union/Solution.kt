class Solution {
    fun findLatestStep(arr:IntArray,m:Int):Int{
        val length=IntArray(arr.size+2);
        var groups=0;
        var answer=-1;
        for(step in 1..arr.size){
            val position=arr[step-1];
            val left=length[position-1];
            val right=length[position+1];
            if(left==m)groups--;
            if(right==m)groups--;
            val merged=left+right+1;
            length[position-left]=merged;
            length[position+right]=merged;
            if(merged==m)groups++;
            if(groups>0)answer=step
        };
        return answer
    }
}
