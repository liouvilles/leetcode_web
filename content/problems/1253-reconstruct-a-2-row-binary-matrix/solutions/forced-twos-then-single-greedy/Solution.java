class Solution {
    public List<List<Integer>> reconstructMatrix(int upper,int lower,int[] colsum){
        int n=colsum.length;
        int[] top=new int[n],bottom=new int[n];
        for(int i=0;i<n;i++)if(colsum[i]==2){
            top[i]=bottom[i]=1;
            upper--;
            lower--;
        }
        if(upper<0||lower<0)return new ArrayList<>();
        for(int i=0;i<n;i++)if(colsum[i]==1){
            if(upper>0){
                top[i]=1;
                upper--;
            }else{
                bottom[i]=1;
                lower--;
            }
        }
        if(upper!=0||lower!=0)return new ArrayList<>();
        List<Integer> first=new ArrayList<>(),second=new ArrayList<>();
        for(int value:top)first.add(value);
        for(int value:bottom)second.add(value);
        return Arrays.asList(first,second);
    }
}
