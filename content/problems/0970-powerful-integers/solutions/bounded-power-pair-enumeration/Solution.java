class Solution {
    public List<Integer> powerfulIntegers(int x,int y,int bound){
        Set<Integer> values=new TreeSet<>();
        for(long a=1;a<=bound;){
            for(long b=1;b<=bound;){
                if(a+b<=bound)values.add((int)(a+b));
                if(y==1||b>bound/y)break;
                b*=y;
            }
            if(x==1||a>bound/x)break;
            a*=x;
        }
        return new ArrayList<>(values);
    }
}
