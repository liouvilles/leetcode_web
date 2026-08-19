class Solution {
    public double trimMean(int[] arr){
        Arrays.sort(arr);
        int trim=arr.length/20;
        double sum=0;
        for(int i=trim;i<arr.length-trim;i++)sum+=arr[i];
        return sum/(arr.length-2*trim);
    }
}
