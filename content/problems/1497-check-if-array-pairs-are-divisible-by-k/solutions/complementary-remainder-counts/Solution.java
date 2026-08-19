class Solution {
    public boolean canArrange(int[] arr,int k){
        int[] count=new int[k];
        for(int value:arr)count[((value%k)+k)%k]++;
        if(count[0]%2!=0)return false;
        for(int remainder=1;remainder<k;remainder++)if(remainder==k-remainder){
            if(count[remainder]%2!=0)return false;
        }else if(count[remainder]!=count[k-remainder])return false;
        return true;
    }
}
