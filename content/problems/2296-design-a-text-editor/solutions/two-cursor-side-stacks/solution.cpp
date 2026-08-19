class TextEditor {
    string left,right;
    string view(){
        return left.substr(left.size()>10?left.size()-10:0);
    }
    public:TextEditor(){
    }
    void addText(string text){
        left+=text;
    }
    int deleteText(int k){
        int removed=min(k,(int)left.size());
        left.resize(left.size()-removed);
        return removed;
    }
    string cursorLeft(int k){
        while(k--&& !left.empty()){
            right+=left.back();
            left.pop_back();
        }
        return view();
    }
    string cursorRight(int k){
        while(k--&& !right.empty()){
            left+=right.back();
            right.pop_back();
        }
        return view();
    }
};
