class Solution {
    public List<Integer> addToArrayForm(int[] num,int k){
        List<Integer> digits=new ArrayList<>();
        for(int i=num.length-1;i>=0||k>0;i--){
            if(i>=0)k+=num[i];
            digits.add(k%10);
            k/=10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
