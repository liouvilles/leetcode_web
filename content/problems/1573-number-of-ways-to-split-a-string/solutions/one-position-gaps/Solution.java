class Solution {
    public int numWays(String text){
        List<Integer> ones=new ArrayList<>();
        for(int i=0;i<text.length();i++)if(text.charAt(i)=='1')ones.add(i);
        long mod=1_000_000_007L;
        if(ones.size()%3!=0)return 0;
        if(ones.isEmpty())return (int)(((long)(text.length()-1)*(text.length()-2)/2)%mod);
        int part=ones.size()/3;
        long first=ones.get(part)-ones.get(part-1),second=ones.get(2*part)-ones.get(2*part-1);
        return (int)(first*second%mod);
    }
}
