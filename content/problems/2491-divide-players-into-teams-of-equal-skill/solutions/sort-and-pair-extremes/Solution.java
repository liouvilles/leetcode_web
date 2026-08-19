class Solution {
    public long dividePlayers(int[] skill){
        Arrays.sort(skill);
        int target=skill[0]+skill[skill.length-1];
        long chemistry=0;
        for(int left=0,right=skill.length-1;left<right;left++,right--){
            if(skill[left]+skill[right]!=target)return -1;
            chemistry+=(long)skill[left]*skill[right];
        }
        return chemistry;
    }
}
