class Solution {
    public boolean isFascinating(int n){
        String value=""+n+(2*n)+(3*n);
        if(value.length()!=9)return false;
        boolean[] seen=new boolean[10];
        for(char ch:value.toCharArray()){
            int digit=ch-'0';
            if(digit==0||seen[digit])return false;
            seen[digit]=true;
        }
        return true;
    }
}
