class Solution {
    private var total=0L;
    private var maximum=0L;
    fun maxProduct(root:TreeNode?):Int{
        total=sum(root);
        sumAndProduct(root);
        return (maximum%1000000007L).toInt()
    };
    private fun sum(node:TreeNode?):Long=node?.let{
        it.`val`+sum(it.left)+sum(it.right)
    }?:0L;
    private fun sumAndProduct(node:TreeNode?):Long{
        node?:return 0;
        val sub=node.`val`+sumAndProduct(node.left)+sumAndProduct(node.right);
        maximum=maxOf(maximum,sub*(total-sub));
        return sub
    }
}
