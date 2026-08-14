const a=94,r="binary-tree-inorder-traversal",e="Binary Tree Inorder Traversal",p="简单",n="树与高级结构",t=["栈","树","深度优先搜索","二叉树"],h=!1,s="https://leetcode.cn/problems/binary-tree-inorder-traversal/",l="二叉树的中序遍历",o=["左根右","显式栈","Morris"],u="按“左子树、根结点、右子树”的顺序返回二叉树所有结点值。",c="递归调用栈和显式栈本质相同；Morris 则把空闲的右指针临时改造成返回路径。",i=["访问根结点的时机在左子树之后","迭代时外层条件要包含栈非空","Morris 结束前必须恢复树结构"],d=[{id:"recursive",title:"递归 DFS",kind:"基础",idea:"严格按照左、根、右的顺序递归访问并写入结果。",steps:["递归访问左子树","记录当前结点","递归访问右子树"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}
`,kotlin:`class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            result.add(node.\`val\`)
            dfs(node.right)
        }
        dfs(root)
        return result
    }
}
`,cpp:`class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        dfs(root, result);
        return result;
    }

private:
    void dfs(TreeNode* node, vector<int>& result) {
        if (!node) return;
        dfs(node->left, result);
        result.push_back(node->val);
        dfs(node->right, result);
    }
};
`}},{id:"iterative-stack",title:"显式栈迭代",kind:"进阶",idea:"不断把左链压栈，栈顶就是下一个应访问的结点。",steps:["沿左指针压入所有结点","弹出栈顶并记录","转向它的右子树重复过程"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
`,kotlin:`class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = java.util.ArrayDeque<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            result.add(current.\`val\`)
            current = current.right
        }
        return result
    }
}
`,cpp:`class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodes;
        TreeNode* current = root;
        while (current || !nodes.empty()) {
            while (current) {
                nodes.push(current);
                current = current->left;
            }
            current = nodes.top(); nodes.pop();
            result.push_back(current->val);
            current = current->right;
        }
        return result;
    }
};
`}},{id:"morris",title:"Morris 线索遍历",kind:"最优",idea:"利用左子树最右结点的空 right 指针建立临时返回路径，实现常数额外空间。",steps:["无左子树时直接访问并向右","首次找到前驱时建立前驱到当前结点的线索","再次遇到线索时恢复 null、访问当前结点并向右"],complexity:{time:"O(n)",space:"O(1)"},code:{java:`class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
`,kotlin:`class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        var current = root
        while (current != null) {
            if (current.left == null) {
                result.add(current.\`val\`)
                current = current.right
            } else {
                var predecessor = current.left!!
                while (predecessor.right != null && predecessor.right !== current) {
                    predecessor = predecessor.right!!
                }
                if (predecessor.right == null) {
                    predecessor.right = current
                    current = current.left
                } else {
                    predecessor.right = null
                    result.add(current.\`val\`)
                    current = current.right
                }
            }
        }
        return result
    }
}
`,cpp:`class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode* current = root;
        while (current) {
            if (!current->left) {
                result.push_back(current->val);
                current = current->right;
            } else {
                TreeNode* predecessor = current->left;
                while (predecessor->right && predecessor->right != current)
                    predecessor = predecessor->right;
                if (!predecessor->right) {
                    predecessor->right = current;
                    current = current->left;
                } else {
                    predecessor->right = nullptr;
                    result.push_back(current->val);
                    current = current->right;
                }
            }
        }
        return result;
    }
};
`}}],f={id:94,slug:r,titleEn:e,difficulty:"简单",category:n,officialTags:t,paidOnly:!1,sourceUrl:s,title:l,studyTags:o,summary:u,insight:c,pitfalls:i,solutions:d};export{n as category,f as default,p as difficulty,a as id,c as insight,t as officialTags,h as paidOnly,i as pitfalls,r as slug,d as solutions,s as sourceUrl,o as studyTags,u as summary,l as title,e as titleEn};
