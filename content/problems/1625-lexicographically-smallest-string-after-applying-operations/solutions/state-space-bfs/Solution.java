class Solution {
    public String findLexSmallestString(String text,int a,int b){
        Queue<String> queue=new ArrayDeque<>();
        Set<String> seen=new HashSet<>();
        queue.offer(text);
        seen.add(text);
        String answer=text;
        while(!queue.isEmpty()){
            String current=queue.poll();
            if(current.compareTo(answer)<0)answer=current;
            char[] digits=current.toCharArray();
            for(int i=1;i<digits.length;i+=2)digits[i]=(char)('0'+(digits[i]-'0'+a)%10);
            String added=new String(digits);
            int n=current.length(),shift=b%n;
            String rotated=current.substring(n-shift)+current.substring(0,n-shift);
            if(seen.add(added))queue.offer(added);
            if(seen.add(rotated))queue.offer(rotated);
        }
        return answer;
    }
}
