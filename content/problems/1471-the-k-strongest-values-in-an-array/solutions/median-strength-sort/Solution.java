class Solution {
    public int[] getStrongest(int[] arr,int k){
        Arrays.sort(arr);
        int median=arr[(arr.length-1)/2];
        Integer[] values=Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(values,(a,b)->{
            int strength=Integer.compare(Math.abs(b-median),Math.abs(a-median));
            return strength!=0?strength:Integer.compare(b,a);
        });
        int[] answer=new int[k];
        for(int i=0;i<k;i++)answer[i]=values[i];
        return answer;
    }
}
