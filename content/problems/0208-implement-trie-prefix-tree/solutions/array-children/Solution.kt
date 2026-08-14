class Trie {
    private class Node { val children = arrayOfNulls<Node>(26); var end = false }
    private val root = Node()
    fun insert(word: String) { var node = root; for (char in word) { val offset = char - 'a'; if (node.children[offset] == null) node.children[offset] = Node(); node = node.children[offset]!! }; node.end = true }
    fun search(word: String): Boolean = find(word)?.end == true
    fun startsWith(prefix: String): Boolean = find(prefix) != null
    private fun find(value: String): Node? { var node: Node? = root; for (char in value) node = node?.children?.get(char - 'a'); return node }
}
