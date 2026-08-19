class Solution {
    public String minimizeResult(String expression){
        int plus=expression.indexOf('+');
        String left=expression.substring(0,plus),right=expression.substring(plus+1),answer="";
        int best=Integer.MAX_VALUE;
        for(int i=0;i<left.length();i++)for(int j=1;j<=right.length();j++){
            int outsideLeft=i==0?1:Integer.parseInt(left.substring(0,i));
            int insideLeft=Integer.parseInt(left.substring(i));
            int insideRight=Integer.parseInt(right.substring(0,j));
            int outsideRight=j==right.length()?1:Integer.parseInt(right.substring(j));
            int value=outsideLeft*(insideLeft+insideRight)*outsideRight;
            if(value<best){
                best=value;
                answer=left.substring(0,i)+"("+left.substring(i)+"+"+right.substring(0,j)+")"+right.substring(j);
            }
        }
        return answer;
    }
}
