class Solution {
    static final long M1=1_000_000_007,M2=1_000_000_009,BASE=911382;
    long[] power1,power2;
    private long key(long first,long second){
        return (first<<32)^second;
    }
    private Set<Long> hashes(int[] path,int length){
        long[] first=new long[path.length+1],second=new long[path.length+1];
        for(int i=0;i<path.length;i++){
            first[i+1]=(first[i]*BASE+path[i]+1)%M1;
            second[i+1]=(second[i]*BASE+path[i]+1)%M2;
        }
        Set<Long> result=new HashSet<>();
        for(int left=0;left+length<=path.length;left++){
            long a=(first[left+length]-first[left]*power1[length]%M1+M1)%M1;
            long b=(second[left+length]-second[left]*power2[length]%M2+M2)%M2;
            result.add(key(a,b));
        }
        return result;
    }
    private boolean check(int[][] paths,int length){
        Set<Long> common=null;
        for(int[] path:paths){
            Set<Long> current=hashes(path,length);
            if(common==null)common=current;
            else common.retainAll(current);
            if(common.isEmpty())return false;
        }
        return true;
    }
    public int longestCommonSubpath(int n,int[][] paths){
        int maximum=0,right=Integer.MAX_VALUE;
        for(int[] path:paths){
            maximum=Math.max(maximum,path.length);
            right=Math.min(right,path.length);
        }
        power1=new long[maximum+1];
        power2=new long[maximum+1];
        power1[0]=power2[0]=1;
        for(int i=1;i<=maximum;i++){
            power1[i]=power1[i-1]*BASE%M1;
            power2[i]=power2[i-1]*BASE%M2;
        }
        int left=0;
        while(left<right){
            int middle=left+(right-left+1)/2;
            if(check(paths,middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
}
