class Solution {
    private static class Node{
        Node[] next=new Node[2];
    }
    private void insert(Node root,int value){
        for(int bit=30;bit>=0;bit--){
            int digit=(value>>bit)&1;
            if(root.next[digit]==null)root.next[digit]=new Node();
            root=root.next[digit];
        }
    }
    private int query(Node root,int value){
        int answer=0;
        for(int bit=30;bit>=0;bit--){
            int digit=(value>>bit)&1,wanted=digit^1;
            if(root.next[wanted]!=null){
                answer|=1<<bit;
                root=root.next[wanted];
            }else root=root.next[digit];
        }
        return answer;
    }
    public int[] maximizeXor(int[] nums,int[][] queries){
        Arrays.sort(nums);
        Integer[] order=new Integer[queries.length];
        for(int i=0;i<order.length;i++)order[i]=i;
        Arrays.sort(order,Comparator.comparingInt(i->queries[i][1]));
        int[] answer=new int[queries.length];
        Node root=new Node();
        int inserted=0;
        for(int index:order){
            while(inserted<nums.length&&nums[inserted]<=queries[index][1])insert(root,nums[inserted++]);
            answer[index]=inserted==0?-1:query(root,queries[index][0]);
        }
        return answer;
    }
}
