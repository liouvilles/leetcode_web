class Solution {
    fun flipLights(n:Int,presses:Int):Int{
        val states=hashSetOf<Int>();
        val lamps=minOf(n,6);
        for(mask in 0 until 16){
            val used=Integer.bitCount(mask);
            if(used>presses||(presses-used)%2!=0)continue;
            var state=0;
            for(index in 1..lamps){
                var on=true;
                if(mask and 1!=0)on=!on;
                if(mask and 2!=0&&index%2==0)on=!on;
                if(mask and 4!=0&&index%2==1)on=!on;
                if(mask and 8!=0&&(index-1)%3==0)on=!on;
                if(on)state=state or (1 shl index-1)
            };
            states.add(state)
        };
        return states.size
    }
}
