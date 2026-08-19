class Solution {
    public int videoStitching(int[][] clips,int time){
        Arrays.sort(clips,Comparator.comparingInt(a->a[0]));
        int index=0,currentEnd=0,used=0;
        while(currentEnd<time){
            int farthest=currentEnd;
            while(index<clips.length&&clips[index][0]<=currentEnd)farthest=Math.max(farthest,clips[index++][1]);
            if(farthest==currentEnd)return -1;
            currentEnd=farthest;
            used++;
        }
        return used;
    }
}
