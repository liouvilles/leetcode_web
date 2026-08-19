class Solution {
    public int beautySum(String text){
        int answer=0;
        for(int left=0;left<text.length();left++){
            int[] frequency=new int[26];
            for(int right=left;right<text.length();right++){
                frequency[text.charAt(right)-'a']++;
                int maximum=0,minimum=Integer.MAX_VALUE;
                for(int count:frequency)if(count>0){
                    maximum=Math.max(maximum,count);
                    minimum=Math.min(minimum,count);
                }
                answer+=maximum-minimum;
            }
        }
        return answer;
    }
}
