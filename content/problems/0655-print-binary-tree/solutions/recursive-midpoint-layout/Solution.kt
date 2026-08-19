class Solution {
    fun printTree(root:TreeNode?):List<List<String>>{
        val height=height(root);
        val columns=(1 shl height)-1;
        val answer=MutableList(height){
            MutableList(columns){
                ""
            }
        };
        fun fill(node:TreeNode?,row:Int,left:Int,right:Int){
            if(node==null)return;
            val middle=(left+right)/2;
            answer[row][middle]=node.`val`.toString();
            fill(node.left,row+1,left,middle-1);
            fill(node.right,row+1,middle+1,right)
        };
        fill(root,0,0,columns-1);
        return answer
    };
    private fun height(node:TreeNode?):Int=if(node==null)0 else 1+maxOf(height(node.left),height(node.right))
}
