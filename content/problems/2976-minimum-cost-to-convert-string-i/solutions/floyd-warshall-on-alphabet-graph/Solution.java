class Solution {
    public long minimumCost(String source,String target,char[] original,char[] changed,int[] cost){
        long infinity=Long.MAX_VALUE/4;
        long[][] distance=new long[26][26];
        for(int from=0;from<26;from++){
            Arrays.fill(distance[from],infinity);
            distance[from][from]=0;
        }
        for(int i=0;i<cost.length;i++){
            int from=original[i]-'a',to=changed[i]-'a';
            distance[from][to]=Math.min(distance[from][to],cost[i]);
        }
        for(int middle=0;middle<26;middle++)for(int from=0;from<26;from++)for(int to=0;to<26;to++)if(distance[from][middle]<infinity&&distance[middle][to]<infinity)distance[from][to]=Math.min(distance[from][to],distance[from][middle]+distance[middle][to]);
        long answer=0;
        for(int i=0;i<source.length();i++){
            long value=distance[source.charAt(i)-'a'][target.charAt(i)-'a'];
            if(value==infinity)return -1;
            answer+=value;
        }
        return answer;
    }
}
