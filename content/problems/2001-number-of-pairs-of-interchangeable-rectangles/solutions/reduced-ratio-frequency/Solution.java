class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
        }
        return a;
    }
    public long interchangeableRectangles(int[][] rectangles){
        Map<String,Integer> frequency=new HashMap<>();
        long answer=0;
        for(int[] rectangle:rectangles){
            int divisor=gcd(rectangle[0],rectangle[1]);
            String key=rectangle[0]/divisor+"/"+rectangle[1]/divisor;
            int count=frequency.getOrDefault(key,0);
            answer+=count;
            frequency.put(key,count+1);
        }
        return answer;
    }
}
