class Solution {
    private boolean isPrime(int value){
        if(value<2)return false;
        if(value%2==0)return value==2;
        for(int divisor=3;divisor*divisor<=value;divisor+=2)if(value%divisor==0)return false;
        return true;
    }
    public int mostFrequentPrime(int[][] mat){
        int[] directions={
            -1,0,1
        };
        Map<Integer,Integer> frequency=new HashMap<>();
        Map<Integer,Boolean> primeCache=new HashMap<>();
        int rows=mat.length,cols=mat[0].length,answer=-1,bestCount=0;
        for(int startRow=0;startRow<rows;startRow++)for(int startCol=0;startCol<cols;startCol++)for(int rowStep:directions)for(int colStep:directions){
            if(rowStep==0&&colStep==0)continue;
            int row=startRow,col=startCol,value=0;
            while(row>=0&&row<rows&&col>=0&&col<cols){
                value=value*10+mat[row][col];
                if(value>10&&primeCache.computeIfAbsent(value,this::isPrime)){
                    int count=frequency.merge(value,1,Integer::sum);
                    if(count>bestCount||count==bestCount&&value>answer){
                        bestCount=count;
                        answer=value;
                    }
                }
                row+=rowStep;
                col+=colStep;
            }
        }
        return answer;
    }
}
