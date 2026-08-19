class Solution {
    private int power(long base,int exponent,int modulus){
        long result=1%modulus;
        base%=modulus;
        while(exponent>0){
            if((exponent&1)==1)result=result*base%modulus;
            base=base*base%modulus;
            exponent>>=1;
        }
        return (int)result;
    }
    public List<Integer> getGoodIndices(int[][] variables,int target){
        List<Integer> answer=new ArrayList<>();
        for(int i=0;i<variables.length;i++){
            int[] row=variables[i];
            int first=power(row[0],row[1],10);
            if(power(first,row[2],row[3])==target)answer.add(i);
        }
        return answer;
    }
}
