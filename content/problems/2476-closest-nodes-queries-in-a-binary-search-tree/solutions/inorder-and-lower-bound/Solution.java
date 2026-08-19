class Solution {
    private void inorder(TreeNode node,List<Integer> sorted){
        if(node==null)return;
        inorder(node.left,sorted);
        sorted.add(node.val);
        inorder(node.right,sorted);
    }
    private int lowerBound(List<Integer> sorted,int target){
        int left=0,right=sorted.size();
        while(left<right){
            int middle=(left+right)>>>1;
            if(sorted.get(middle)<target)left=middle+1;
            else right=middle;
        }
        return left;
    }
    public List<List<Integer>> closestNodes(TreeNode root,List<Integer> queries){
        List<Integer> sorted=new ArrayList<>();
        inorder(root,sorted);
        List<List<Integer>> answer=new ArrayList<>();
        for(int query:queries){
            int index=lowerBound(sorted,query);
            int upper=index<sorted.size()?sorted.get(index):-1;
            int lower=index<sorted.size()&&sorted.get(index)==query?query:index>0?sorted.get(index-1):-1;
            answer.add(Arrays.asList(lower,upper));
        }
        return answer;
    }
}
