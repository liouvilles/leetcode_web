class Trie {
    struct Node { array<Node*, 26> children{}; bool end = false; };
    Node* root = new Node();
    Node* find(const string& value) { Node* node = root; for (char letter : value) { node = node->children[letter - 'a']; if (!node) return nullptr; } return node; }
public:
    Trie() {}
    void insert(string word) { Node* node = root; for (char letter : word) { Node*& child = node->children[letter - 'a']; if (!child) child = new Node(); node = child; } node->end = true; }
    bool search(string word) { Node* node = find(word); return node && node->end; }
    bool startsWith(string prefix) { return find(prefix) != nullptr; }
};
