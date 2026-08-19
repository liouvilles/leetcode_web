class Solution {
    public:bool canChange(string start,string target){
        int n=start.size(),i=0,j=0;
        while(true){
            while(i<n&&start[i]=='_')++i;
            while(j<n&&target[j]=='_')++j;
            if(i==n||j==n)return i==n&&j==n;
            char piece=start[i];
            if(piece!=target[j])return false;
            if((piece=='L'&&i<j)||(piece=='R'&&i>j))return false;
            ++i;
            ++j;
        }
    }
};
