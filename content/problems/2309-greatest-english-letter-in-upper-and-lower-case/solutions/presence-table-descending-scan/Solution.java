class Solution {
    public String greatestLetter(String s){
        boolean[] seen=new boolean[128];
        for(char ch:s.toCharArray())seen[ch]=true;
        for(char upper='Z';upper>='A';upper--)if(seen[upper]&&seen[Character.toLowerCase(upper)])return String.valueOf(upper);
        return "";
    }
}
