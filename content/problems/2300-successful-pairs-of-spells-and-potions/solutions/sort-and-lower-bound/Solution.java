class Solution {
    public int[] successfulPairs(int[] spells,int[] potions,long success){
        Arrays.sort(potions);
        int[] answer=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            long required=(success+spells[i]-1)/spells[i];
            int left=0,right=potions.length;
            while(left<right){
                int middle=(left+right)/2;
                if(potions[middle]>=required)right=middle;
                else left=middle+1;
            }
            answer[i]=potions.length-left;
        }
        return answer;
    }
}
