class Solution {
    static class Node{
        Node[] next=new Node[2];
        int count;
    }
    private int countLess(int[] nums,int limit){
        Node root=new Node();
        int answer=0;
        for(int value:nums){
            Node node=root;
            for(int bit=15;bit>=0&&node!=null;bit--){
                int digit=(value>>bit)&1,bound=(limit>>bit)&1;
                if(bound==1){
                    if(node.next[digit]!=null)answer+=node.next[digit].count;
                    node=node.next[digit^1];
                }else node=node.next[digit];
            }
            node=root;
            node.count++;
            for(int bit=15;bit>=0;bit--){
                int digit=(value>>bit)&1;
                if(node.next[digit]==null)node.next[digit]=new Node();
                node=node.next[digit];
                node.count++;
            }
        }
        return answer;
    }
    public int countPairs(int[] nums,int low,int high){
        return countLess(nums,high+1)-countLess(nums,low);
    }
}
