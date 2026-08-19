class Solution {
    public boolean canBeEqual(String s1,String s2){
        int[][] count=new int[2][26];
        for(int i=0;i<4;i++){
            count[i%2][s1.charAt(i)-'a']++;
            count[i%2][s2.charAt(i)-'a']--;
        }
        for(int[] row:count)for(int value:row)if(value!=0)return false;
        return true;
    }
}
