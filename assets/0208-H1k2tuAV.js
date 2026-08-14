const f=208,e="implement-trie-prefix-tree",n="Implement Trie (Prefix Tree)",u="中等",o="树与高级结构",r=["哈希表","字符串","设计","字典树"],h=!1,t="https://leetcode.cn/problems/implement-trie-prefix-tree/",d="实现 Trie（前缀树）",i=["设计题","字典树","前缀查询"],l="实现支持插入单词、查询完整单词和查询前缀是否存在的前缀树。",a="每个节点表示一个前缀，孩子边表示下一个字符；额外终止标记区分完整单词与普通前缀。",s=["startsWith 不要求终止标记为真","重复插入同一单词不会改变语义","输入只包含小写英文字母"],c=[{id:"array-children",title:"定长孩子数组字典树",kind:"最优",idea:"每个节点用长度 26 的数组保存下一字符节点，并记录是否为单词结尾。",steps:["从根按字符逐层创建或读取节点","insert 最终设置 end 标记","search 与 startsWith 共用前缀定位逻辑"],complexity:{time:"O(L)",space:"O(total characters)"},code:{java:`class Trie {
    private static class Node { Node[] children = new Node[26]; boolean end; }
    private final Node root = new Node();
    public Trie() {}
    public void insert(String word) { Node node = root; for (int index = 0; index < word.length(); index++) { int offset = word.charAt(index) - 'a'; if (node.children[offset] == null) node.children[offset] = new Node(); node = node.children[offset]; } node.end = true; }
    public boolean search(String word) { Node node = find(word); return node != null && node.end; }
    public boolean startsWith(String prefix) { return find(prefix) != null; }
    private Node find(String value) { Node node = root; for (int index = 0; index < value.length() && node != null; index++) node = node.children[value.charAt(index) - 'a']; return node; }
}
`,kotlin:`class Trie {
    private class Node { val children = arrayOfNulls<Node>(26); var end = false }
    private val root = Node()
    fun insert(word: String) { var node = root; for (char in word) { val offset = char - 'a'; if (node.children[offset] == null) node.children[offset] = Node(); node = node.children[offset]!! }; node.end = true }
    fun search(word: String): Boolean = find(word)?.end == true
    fun startsWith(prefix: String): Boolean = find(prefix) != null
    private fun find(value: String): Node? { var node: Node? = root; for (char in value) node = node?.children?.get(char - 'a'); return node }
}
`,cpp:`class Trie {
    struct Node { array<Node*, 26> children{}; bool end = false; };
    Node* root = new Node();
    Node* find(const string& value) { Node* node = root; for (char letter : value) { node = node->children[letter - 'a']; if (!node) return nullptr; } return node; }
public:
    Trie() {}
    void insert(string word) { Node* node = root; for (char letter : word) { Node*& child = node->children[letter - 'a']; if (!child) child = new Node(); node = child; } node->end = true; }
    bool search(string word) { Node* node = find(word); return node && node->end; }
    bool startsWith(string prefix) { return find(prefix) != nullptr; }
};
`}}],p={id:208,slug:e,titleEn:n,difficulty:"中等",category:o,officialTags:r,paidOnly:!1,sourceUrl:t,title:d,studyTags:i,summary:l,insight:a,pitfalls:s,solutions:c};export{o as category,p as default,u as difficulty,f as id,a as insight,r as officialTags,h as paidOnly,s as pitfalls,e as slug,c as solutions,t as sourceUrl,i as studyTags,l as summary,d as title,n as titleEn};
