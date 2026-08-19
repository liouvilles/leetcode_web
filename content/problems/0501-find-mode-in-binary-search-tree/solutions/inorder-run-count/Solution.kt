class Solution {
    private var previous:Int?=null;
    private var count=0;
    private var best=0;
    private val modes=mutableListOf<Int>();
    fun findMode(root:TreeNode?):IntArray{
        fun inorder(node:TreeNode?){
            if(node==null)return;
            inorder(node.left);
            count=if(previous==node.`val`)count+1 else 1;
            if(count>best){
                best=count;
                modes.clear();
                modes.add(node.`val`)
            }else if(count==best)modes.add(node.`val`);
            previous=node.`val`;
            inorder(node.right)
        };
        inorder(root);
        return modes.toIntArray()
    }
}
