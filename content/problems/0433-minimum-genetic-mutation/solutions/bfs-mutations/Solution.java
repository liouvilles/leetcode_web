class Solution {
    public int minMutation(String start,String end,String[] bank){
        if(start.equals(end))return 0;
        Set<String> available=new HashSet<>(Arrays.asList(bank));
        if(!available.contains(end))return -1;
        Queue<String> queue=new ArrayDeque<>();
        queue.offer(start);
        char[] genes={
            'A','C','G','T'
        };
        int steps=0;
        while(!queue.isEmpty()){
            steps++;
            for(int size=queue.size();size>0;size--){
                char[] current=queue.poll().toCharArray();
                for(int i=0;i<current.length;i++){
                    char original=current[i];
                    for(char gene:genes){
                        current[i]=gene;
                        String next=new String(current);
                        if(next.equals(end))return steps;
                        if(available.remove(next))queue.offer(next);
                    }
                    current[i]=original;
                }
            }
        }
        return -1;
    }
}
