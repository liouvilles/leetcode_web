class Solution {
    public String longestDiverseString(int a,int b,int c){
        PriorityQueue<int[]> heap=new PriorityQueue<>((x,y)->x[0]!=y[0]?Integer.compare(y[0],x[0]):Integer.compare(x[1],y[1]));
        if(a>0)heap.offer(new int[]{
            a,'a'
        });
        if(b>0)heap.offer(new int[]{
            b,'b'
        });
        if(c>0)heap.offer(new int[]{
            c,'c'
        });
        StringBuilder answer=new StringBuilder();
        while(!heap.isEmpty()){
            int[] first=heap.poll();
            int length=answer.length();
            if(length>=2&&answer.charAt(length-1)==first[1]&&answer.charAt(length-2)==first[1]){
                if(heap.isEmpty())break;
                int[] second=heap.poll();
                answer.append((char)second[1]);
                if(--second[0]>0)heap.offer(second);
                heap.offer(first);
            }else{
                answer.append((char)first[1]);
                if(--first[0]>0)heap.offer(first);
            }
        }
        return answer.toString();
    }
}
