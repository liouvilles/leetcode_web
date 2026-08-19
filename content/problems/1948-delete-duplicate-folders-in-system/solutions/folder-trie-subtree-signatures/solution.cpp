class Solution {
    struct Node{
        map<string,Node*> children;
        string signature;
    };
    Node* root;
    unordered_map<string,int> counts;
    string encode(Node* node){
        string result;
        for(auto [name,child]:node->children)result+='('+name+encode(child)+')';
        node->signature=result;
        if(node!=root&&!node->children.empty())++counts[result];
        return result;
    }
    void collect(Node* node,vector<string>& path,vector<vector<string>>& answer){
        for(auto [name,child]:node->children){
            if(!child->children.empty()&&counts[child->signature]>1)continue;
            path.push_back(name);
            answer.push_back(path);
            collect(child,path,answer);
            path.pop_back();
        }
    }
    public: vector<vector<string>> deleteDuplicateFolder(vector<vector<string>>& paths){
        root=new Node();
        for(auto& path:paths){
            Node* node=root;
            for(string& name:path){
                if(!node->children.count(name))node->children[name]=new Node();
                node=node->children[name];
            }
        }
        encode(root);
        vector<vector<string>> answer;
        vector<string> path;
        collect(root,path,answer);
        return answer;
    }
};
