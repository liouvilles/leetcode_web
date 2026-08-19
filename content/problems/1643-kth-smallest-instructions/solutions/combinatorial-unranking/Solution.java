class Solution {
    private long combination(int n,int choose){
        choose=Math.min(choose,n-choose);
        long answer=1;
        for(int i=1;i<=choose;i++)answer=answer*(n-i+1)/i;
        return answer;
    }
    public String kthSmallestPath(int[] destination,int k){
        int vertical=destination[0],horizontal=destination[1];
        StringBuilder answer=new StringBuilder();
        while(horizontal>0&&vertical>0){
            long startWithH=combination(horizontal+vertical-1,vertical);
            if(k<=startWithH){
                answer.append('H');
                horizontal--;
            }else{
                answer.append('V');
                vertical--;
                k-=startWithH;
            }
        }while(horizontal-->0)answer.append('H');
        while(vertical-->0)answer.append('V');
        return answer.toString();
    }
}
