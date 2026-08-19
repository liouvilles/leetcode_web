class Solution {
    public int minimumEffort(int[][] tasks){
        Arrays.sort(tasks,(a,b)->Integer.compare(b[1]-b[0],a[1]-a[0]));
        int required=0,spent=0;
        for(int[] task:tasks){
            required=Math.max(required,spent+task[1]);
            spent+=task[0];
        }
        return required;
    }
}
