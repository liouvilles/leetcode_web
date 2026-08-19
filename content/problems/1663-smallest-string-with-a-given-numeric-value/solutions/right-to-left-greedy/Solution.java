class Solution {
    public String getSmallestString(int n,int k){
        char[] letters=new char[n];
        Arrays.fill(letters,'a');
        int remaining=k-n;
        for(int index=n-1;index>=0&&remaining>0;index--){
            int add=Math.min(25,remaining);
            letters[index]+=add;
            remaining-=add;
        }
        return new String(letters);
    }
}
