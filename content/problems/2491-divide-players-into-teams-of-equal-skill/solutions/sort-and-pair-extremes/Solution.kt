class Solution {
    fun dividePlayers(skill:IntArray):Long{
        skill.sort();
        val target=skill.first()+skill.last();
        var chemistry=0L;
        var left=0;
        var right=skill.lastIndex;
        while(left<right){
            if(skill[left]+skill[right]!=target)return -1;
            chemistry+=skill[left++].toLong()*skill[right--]
        };
        return chemistry
    }
}
