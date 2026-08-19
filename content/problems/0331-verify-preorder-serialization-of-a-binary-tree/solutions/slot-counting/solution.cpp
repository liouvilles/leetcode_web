class Solution {
    public: bool isValidSerialization(string preorder){
        int slots=1;
        string token;
        stringstream stream(preorder);
        while(getline(stream,token,',')){
            if(slots==0)return false;
            --slots;
            if(token!="#")slots+=2;
        }
        return slots==0;
    }
};
