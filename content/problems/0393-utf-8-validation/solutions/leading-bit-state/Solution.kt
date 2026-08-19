class Solution {
    fun validUtf8(data:IntArray):Boolean{
        var remaining=0;
        for(raw in data){
            val value=raw and 255;
            if(remaining==0){
                if(value and 128==0)continue;
                var count=0;
                var mask=128;
                while(value and mask!=0){
                    count++;
                    mask=mask shr 1
                };
                if(count==1||count>4)return false;
                remaining=count-1
            }else{
                if(value and 192!=128)return false;
                remaining--
            }
        };
        return remaining==0
    }
}
