class Solution {
    private boolean match(ListNode head,TreeNode node){
        if(head==null)return true;
        if(node==null||head.val!=node.val)return false;
        return match(head.next,node.left)||match(head.next,node.right);
    }
    public boolean isSubPath(ListNode head,TreeNode root){
        return root!=null&&(match(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right));
    }
}
