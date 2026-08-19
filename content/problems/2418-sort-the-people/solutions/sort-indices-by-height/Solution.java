class Solution {
    public String[] sortPeople(String[] names,int[] heights){
        Integer[] indices=new Integer[names.length];
        for(int i=0;i<names.length;i++)indices[i]=i;
        Arrays.sort(indices,(a,b)->Integer.compare(heights[b],heights[a]));
        String[] answer=new String[names.length];
        for(int i=0;i<names.length;i++)answer[i]=names[indices[i]];
        return answer;
    }
}
