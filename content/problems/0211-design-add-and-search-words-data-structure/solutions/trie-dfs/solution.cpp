class WordDictionary {
    struct Node{
        array<Node*,26> next{
        };
        bool word=false;
    };
    Node* root=new Node();
    bool dfs(Node* node,const string& word,int index){
        if(index==(int)word.size())return node->word;
        char c=word[index];
        if(c!='.')return node->next[c-'a']&&dfs(node->next[c-'a'],word,index+1);
        for(Node* child:node->next)if(child&&dfs(child,word,index+1))return true;
        return false;
    }
    public:void addWord(string word){
        Node* node=root;
        for(char c:word){
            int i=c-'a';
            if(!node->next[i])node->next[i]=new Node();
            node=node->next[i];
        }
        node->word=true;
    }
    bool search(string word){
        return dfs(root,word,0);
    }
};
