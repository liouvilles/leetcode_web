class Solution {
    public String repeatLimitedString(String s,int repeatLimit){
        int[] count=new int[26];
        for(char ch:s.toCharArray())count[ch-'a']++;
        StringBuilder answer=new StringBuilder();
        int current=25;
        while(current>=0){
            while(current>=0&&count[current]==0)current--;
            if(current<0)break;
            int take=Math.min(count[current],repeatLimit);
            answer.append(String.valueOf((char)('a'+current)).repeat(take));
            count[current]-=take;
            if(count[current]==0)continue;
            int separator=current-1;
            while(separator>=0&&count[separator]==0)separator--;
            if(separator<0)break;
            answer.append((char)('a'+separator));
            count[separator]--;
        }
        return answer.toString();
    }
}
