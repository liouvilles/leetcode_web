class Solution {
    public String alphabetBoardPath(String target){
        StringBuilder path=new StringBuilder();
        int row=0,column=0;
        for(char ch:target.toCharArray()){
            int index=ch-'a',nextRow=index/5,nextColumn=index%5;
            while(row>nextRow){
                path.append('U');
                row--;
            }while(column>nextColumn){
                path.append('L');
                column--;
            }while(row<nextRow){
                path.append('D');
                row++;
            }while(column<nextColumn){
                path.append('R');
                column++;
            }
            path.append('!');
        }
        return path.toString();
    }
}
