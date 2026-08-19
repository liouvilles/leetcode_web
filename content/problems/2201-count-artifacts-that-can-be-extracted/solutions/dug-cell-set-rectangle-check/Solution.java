class Solution {
    public int digArtifacts(int n,int[][] artifacts,int[][] dig){
        Set<Integer> dug=new HashSet<>();
        for(int[] cell:dig)dug.add(cell[0]*n+cell[1]);
        int answer=0;
        for(int[] artifact:artifacts){
            boolean complete=true;
            for(int row=artifact[0];row<=artifact[2]&&complete;row++)for(int column=artifact[1];column<=artifact[3];column++)if(!dug.contains(row*n+column)){
                complete=false;
                break;
            }
            if(complete)answer++;
        }
        return answer;
    }
}
