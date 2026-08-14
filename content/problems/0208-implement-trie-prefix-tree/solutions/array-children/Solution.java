class Trie {
    private static class Node { Node[] children = new Node[26]; boolean end; }
    private final Node root = new Node();
    public Trie() {}
    public void insert(String word) { Node node = root; for (int index = 0; index < word.length(); index++) { int offset = word.charAt(index) - 'a'; if (node.children[offset] == null) node.children[offset] = new Node(); node = node.children[offset]; } node.end = true; }
    public boolean search(String word) { Node node = find(word); return node != null && node.end; }
    public boolean startsWith(String prefix) { return find(prefix) != null; }
    private Node find(String value) { Node node = root; for (int index = 0; index < value.length() && node != null; index++) node = node.children[value.charAt(index) - 'a']; return node; }
}
