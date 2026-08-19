class Solution {
    public int numberOfBeams(String[] bank){
        int previous=0,answer=0;
        for(String row:bank){
            int current=0;
            for(int i=0;i<row.length();i++)if(row.charAt(i)=='1')current++;
            if(current>0){
                answer+=previous*current;
                previous=current;
            }
        }
        return answer;
    }
}
