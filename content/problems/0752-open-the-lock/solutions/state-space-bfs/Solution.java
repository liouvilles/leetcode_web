class Solution {
    public int openLock(String[] deadends,String target){
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000"))return -1;
        Queue<String> queue=new ArrayDeque<>();
        Set<String> seen=new HashSet<>();
        queue.offer("0000");
        seen.add("0000");
        int steps=0;
        while(!queue.isEmpty()){
            for(int size=queue.size();size>0;size--){
                String state=queue.poll();
                if(state.equals(target))return steps;
                char[] digits=state.toCharArray();
                for(int i=0;i<4;i++){
                    char original=digits[i];
                    for(int delta:new int[]{
                        1,-1
                    }){
                        digits[i]=(char)('0'+(original-'0'+delta+10)%10);
                        String next=new String(digits);
                        if(!dead.contains(next)&&seen.add(next))queue.offer(next);
                    }
                    digits[i]=original;
                }
            }
            steps++;
        }
        return -1;
    }
}
