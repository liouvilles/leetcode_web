class Solution {
    struct Node{
        Node* children[26]={
        };
        int count=0;
    };
    public:vector<int> sumPrefixScores(vector<string>& words){
        Node* root=new Node();
        for(string& word:words){
            Node* node=root;
            for(char ch:word){
                int index=ch-'a';
                if(!node->children[index])node->children[index]=new Node();
                node=node->children[index];
                ++node->count;
            }
        }
        vector<int> answer;
        for(string& word:words){
            Node* node=root;
            int score=0;
            for(char ch:word){
                node=node->children[ch-'a'];
                score+=node->count;
            }
            answer.push_back(score);
        }
        return answer;
    }
};
