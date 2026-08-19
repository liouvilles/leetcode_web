class Solution {
    string changed(string text,char from,char to){
        replace(text.begin(),text.end(),from,to);
        return text;
    }
    public:int maxDiff(int num){
        string text=to_string(num),maximum=text,minimum=text;
        for(char value:text)if(value!='9'){
            maximum=changed(text,value,'9');
            break;
        }
        if(text[0]!='1')minimum=changed(text,text[0],'1');
        else for(int i=1;i<(int)text.size();++i)if(text[i]!='0'&&text[i]!='1'){
            minimum=changed(text,text[i],'0');
            break;
        }
        return stoi(maximum)-stoi(minimum);
    }
};
