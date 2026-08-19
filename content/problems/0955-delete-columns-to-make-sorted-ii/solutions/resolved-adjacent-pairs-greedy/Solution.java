class Solution {
    public int minDeletionSize(String[] strs){
        boolean[] resolved=new boolean[strs.length];
        int deleted=0;
        for(int col=0;col<strs[0].length();col++){
            boolean invalid=false;
            for(int row=1;row<strs.length;row++)if(!resolved[row]&&strs[row-1].charAt(col)>strs[row].charAt(col)){
                invalid=true;
                break;
            }
            if(invalid){
                deleted++;
                continue;
            }
            for(int row=1;row<strs.length;row++)if(strs[row-1].charAt(col)<strs[row].charAt(col))resolved[row]=true;
        }
        return deleted;
    }
}
