class Solution {
    fun predictPartyVictory(senate:String):String{
        val radiant=java.util.ArrayDeque<Int>();
        val dire=java.util.ArrayDeque<Int>();
        for(i in senate.indices)if(senate[i]=='R')radiant.add(i) else dire.add(i);
        while(radiant.isNotEmpty()&&dire.isNotEmpty()){
            val r=radiant.remove();
            val d=dire.remove();
            if(r<d)radiant.add(r+senate.length) else dire.add(d+senate.length)
        };
        return if(radiant.isEmpty())"Dire" else "Radiant"
    }
}
