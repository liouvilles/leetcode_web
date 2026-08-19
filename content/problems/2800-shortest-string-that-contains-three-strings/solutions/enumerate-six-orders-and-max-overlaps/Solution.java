class Solution {
    private String merge(String first,String second){
        if(first.contains(second))return first;
        if(second.contains(first))return second;
        for(int overlap=Math.min(first.length(),second.length());overlap>=0;overlap--)if(first.regionMatches(first.length()-overlap,second,0,overlap))return first+second.substring(overlap);
        return first+second;
    }
    public String minimumString(String a,String b,String c){
        String[] values={
            a,b,c
        };
        int[][] orders={
            {
                0,1,2
            },{
                0,2,1
            },{
                1,0,2
            },{
                1,2,0
            },{
                2,0,1
            },{
                2,1,0
            }
        };
        String best=null;
        for(int[] order:orders){
            String candidate=merge(merge(values[order[0]],values[order[1]]),values[order[2]]);
            if(best==null||candidate.length()<best.length()||candidate.length()==best.length()&&candidate.compareTo(best)<0)best=candidate;
        }
        return best;
    }
}
