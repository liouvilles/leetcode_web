class Solution {
    public String orderlyQueue(String s,int k){
        if(k>1){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String best=s;
        for(int shift=1;shift<s.length();shift++){
            String candidate=s.substring(shift)+s.substring(0,shift);
            if(candidate.compareTo(best)<0)best=candidate;
        }
        return best;
    }
}
