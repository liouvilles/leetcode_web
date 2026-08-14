const f=103,e="binary-tree-zigzag-level-order-traversal",t="Binary Tree Zigzag Level Order Traversal",c="中等",n="树与高级结构",i=["树","广度优先搜索","二叉树"],g=!1,o="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/",r="二叉树的锯齿形层序遍历",l=["二叉树","广度优先搜索","方向切换"],s="按层遍历二叉树，并让相邻层的节点值输出方向在从左到右与从右到左之间交替。",d="队列仍按普通层序顺序扩展节点，只需根据层方向把值写入本层数组的正向或反向下标。",a=["改变的是输出顺序而非子节点入队顺序","每处理完一层再切换方向","空树返回空列表"],u=[{id:"bfs-index-placement",title:"层序遍历按方向写入",kind:"最优",idea:"逐层固定大小出队，并用镜像下标生成锯齿顺序。",steps:["根节点入队","按当前层 size 创建列表","值写入 index 或 size-1-index，子节点正常入队，随后切换方向"],complexity:{time:"O(n)",space:"O(w)"},code:{java:`class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>(); if (root == null) return answer; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root); boolean leftToRight = true;
        while (!queue.isEmpty()) { int size = queue.size(); Integer[] level = new Integer[size]; for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); level[leftToRight ? index : size - 1 - index] = node.val; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } answer.add(Arrays.asList(level)); leftToRight = !leftToRight; }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList(); val answer = mutableListOf<List<Int>>(); val queue = ArrayDeque<TreeNode>(); queue.add(root); var leftToRight = true
        while (queue.isNotEmpty()) { val size = queue.size; val level = MutableList(size) { 0 }; repeat(size) { index -> val node = queue.removeFirst(); level[if (leftToRight) index else size - 1 - index] = node.\`val\`; node.left?.let { queue.add(it) }; node.right?.let { queue.add(it) } }; answer.add(level); leftToRight = !leftToRight }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (!root) return {}; vector<vector<int>> answer; queue<TreeNode*> nodes; nodes.push(root); bool leftToRight = true;
        while (!nodes.empty()) { int size = nodes.size(); vector<int> level(size); for (int index = 0; index < size; ++index) { TreeNode* node = nodes.front(); nodes.pop(); level[leftToRight ? index : size - 1 - index] = node->val; if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } answer.push_back(level); leftToRight = !leftToRight; } return answer;
    }
};
`}}],v={id:103,slug:e,titleEn:t,difficulty:"中等",category:n,officialTags:i,paidOnly:!1,sourceUrl:o,title:r,studyTags:l,summary:s,insight:d,pitfalls:a,solutions:u};export{n as category,v as default,c as difficulty,f as id,d as insight,i as officialTags,g as paidOnly,a as pitfalls,e as slug,u as solutions,o as sourceUrl,l as studyTags,s as summary,r as title,t as titleEn};
