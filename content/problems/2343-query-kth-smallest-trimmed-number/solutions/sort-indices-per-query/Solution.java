class Solution {
    public int[] smallestTrimmedNumbers(String[] nums,int[][] queries){
        int[] answer=new int[queries.length];
        int length=nums[0].length();
        for(int q=0;q<queries.length;q++){
            int trim=queries[q][1];
            Integer[] indices=new Integer[nums.length];
            for(int i=0;i<nums.length;i++)indices[i]=i;
            Arrays.sort(indices,(a,b)->{
                int compare=nums[a].substring(length-trim).compareTo(nums[b].substring(length-trim));
                return compare!=0?compare:Integer.compare(a,b);
            });
            answer[q]=indices[queries[q][0]-1];
        }
        return answer;
    }
}
