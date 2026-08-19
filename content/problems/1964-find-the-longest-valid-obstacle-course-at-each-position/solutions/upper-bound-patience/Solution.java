class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles){
        int[] tails=new int[obstacles.length],answer=new int[obstacles.length];
        int size=0;
        for(int i=0;i<obstacles.length;i++){
            int left=0,right=size;
            while(left<right){
                int middle=(left+right)/2;
                if(tails[middle]<=obstacles[i])left=middle+1;
                else right=middle;
            }
            tails[left]=obstacles[i];
            if(left==size)size++;
            answer[i]=left+1;
        }
        return answer;
    }
}
