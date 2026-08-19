class Solution {
    public String bestHand(int[] ranks,char[] suits){
        boolean flush=true;
        for(char suit:suits)flush&=suit==suits[0];
        if(flush)return "Flush";
        int[] frequency=new int[14];
        int maximum=0;
        for(int rank:ranks)maximum=Math.max(maximum,++frequency[rank]);
        if(maximum>=3)return "Three of a Kind";
        if(maximum>=2)return "Pair";
        return "High Card";
    }
}
