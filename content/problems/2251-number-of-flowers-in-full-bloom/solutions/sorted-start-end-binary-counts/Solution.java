class Solution {
    private int lower(int[] values,int target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)/2;
            if(values[middle]<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    private int upper(int[] values,int target){
        int left=0,right=values.length;
        while(left<right){
            int middle=(left+right)/2;
            if(values[middle]<=target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    public int[] fullBloomFlowers(int[][] flowers,int[] people){
        int[] starts=new int[flowers.length],ends=new int[flowers.length];
        for(int i=0;i<flowers.length;i++){
            starts[i]=flowers[i][0];
            ends[i]=flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int[] answer=new int[people.length];
        for(int i=0;i<people.length;i++)answer[i]=upper(starts,people[i])-lower(ends,people[i]);
        return answer;
    }
}
