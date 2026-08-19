class Solution {
    public: string alphabetBoardPath(string target){
        string path;
        int row=0,column=0;
        for(char ch:target){
            int index=ch-'a',nextRow=index/5,nextColumn=index%5;
            while(row>nextRow){
                path+='U';
                --row;
            }while(column>nextColumn){
                path+='L';
                --column;
            }while(row<nextRow){
                path+='D';
                ++row;
            }while(column<nextColumn){
                path+='R';
                ++column;
            }
            path+='!';
        }
        return path;
    }
};
