class Solution {
    public int[] distributeCandies(int candies,int numPeople){
        int[] answer=new int[numPeople];
        for(int give=1,index=0;candies>0;give++,index++){
            int amount=Math.min(candies,give);
            answer[index%numPeople]+=amount;
            candies-=amount;
        }
        return answer;
    }
}
