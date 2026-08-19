class Solution {
    private boolean check(String s,String p,int[] removable,int count){
        boolean[] removed=new boolean[s.length()];
        for(int i=0;i<count;i++)removed[removable[i]]=true;
        int matched=0;
        for(int i=0;i<s.length()&&matched<p.length();i++)if(!removed[i]&&s.charAt(i)==p.charAt(matched))matched++;
        return matched==p.length();
    }
    public int maximumRemovals(String s,String p,int[] removable){
        int left=0,right=removable.length;
        while(left<right){
            int middle=left+(right-left+1)/2;
            if(check(s,p,removable,middle))left=middle;
            else right=middle-1;
        }
        return left;
    }
}
