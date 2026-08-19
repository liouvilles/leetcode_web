class Solution {
    private void next(char[] value){
        int i=value.length-2;
        while(i>=0&&value[i]>=value[i+1])i--;
        int j=value.length-1;
        while(value[j]<=value[i])j--;
        char t=value[i];
        value[i]=value[j];
        value[j]=t;
        for(int l=i+1,r=value.length-1;l<r;l++,r--){
            t=value[l];
            value[l]=value[r];
            value[r]=t;
        }
    }
    public int getMinSwaps(String num,int k){
        char[] target=num.toCharArray();
        while(k-->0)next(target);
        char[] current=num.toCharArray();
        int swaps=0;
        for(int i=0;i<current.length;i++){
            int j=i;
            while(current[j]!=target[i])j++;
            swaps+=j-i;
            while(j>i){
                char t=current[j];
                current[j]=current[j-1];
                current[j-1]=t;
                j--;
            }
        }
        return swaps;
    }
}
