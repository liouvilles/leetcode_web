class Solution {
    private boolean find(TreeNode node,int target,StringBuilder path){
        if(node==null)return false;
        if(node.val==target)return true;
        path.append('L');
        if(find(node.left,target,path))return true;
        path.deleteCharAt(path.length()-1);
        path.append('R');
        if(find(node.right,target,path))return true;
        path.deleteCharAt(path.length()-1);
        return false;
    }
    public String getDirections(TreeNode root,int startValue,int destValue){
        StringBuilder start=new StringBuilder(),destination=new StringBuilder();
        find(root,startValue,start);
        find(root,destValue,destination);
        int common=0;
        while(common<start.length()&&common<destination.length()&&start.charAt(common)==destination.charAt(common))common++;
        return "U".repeat(start.length()-common)+destination.substring(common);
    }
}
