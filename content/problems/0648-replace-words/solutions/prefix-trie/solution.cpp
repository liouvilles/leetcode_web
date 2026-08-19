class Solution {
    struct Node{
        array<Node*,26> next{
        };
        bool end=false;
    };
    Node root;
    void insert(string& word){
        Node* node=&root;
        for(char c:word){
            int index=c-'a';
            if(!node->next[index])node->next[index]=new Node();
            node=node->next[index];
        }
        node->end=true;
    }
    string replace(string word){
        Node* node=&root;
        for(int i=0;i<(int)word.size();++i){
            node=node->next[word[i]-'a'];
            if(!node)return word;
            if(node->end)return word.substr(0,i+1);
        }
        return word;
    }
    public:string replaceWords(vector<string>& dictionary,string sentence){
        for(string& word:dictionary)insert(word);
        stringstream stream(sentence);
        string word,answer;
        while(stream>>word){
            if(!answer.empty())answer+=' ';
            answer+=replace(word);
        }
        return answer;
    }
};
