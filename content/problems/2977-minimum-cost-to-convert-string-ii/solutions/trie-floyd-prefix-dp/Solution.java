class Solution {
    static class Node {
        Node[] next=new Node[26];
        int id=-1;
    }
    Node root;
    private int getId(String word,Map<String,Integer> ids){
        Integer found=ids.get(word);
        if(found!=null)return found;
        int id=ids.size();
        ids.put(word,id);
        Node node=root;
        for(char letter:word.toCharArray()){
            int index=letter-'a';
            if(node.next[index]==null)node.next[index]=new Node();
            node=node.next[index];
        }
        node.id=id;
        return id;
    }
    public long minimumCost(String source,String target,String[] original,String[] changed,int[] cost){
        root=new Node();
        Map<String,Integer> ids=new HashMap<>();
        for(int i=0;i<cost.length;i++){
            getId(original[i],ids);
            getId(changed[i],ids);
        }
        long infinity=Long.MAX_VALUE/4;
        long[][] distance=new long[ids.size()][ids.size()];
        for(int from=0;from<distance.length;from++){
            Arrays.fill(distance[from],infinity);
            distance[from][from]=0;
        }
        for(int i=0;i<cost.length;i++){
            int from=ids.get(original[i]),to=ids.get(changed[i]);
            distance[from][to]=Math.min(distance[from][to],cost[i]);
        }
        for(int middle=0;middle<distance.length;middle++)for(int from=0;from<distance.length;from++)if(distance[from][middle]<infinity)for(int to=0;to<distance.length;to++)if(distance[middle][to]<infinity)distance[from][to]=Math.min(distance[from][to],distance[from][middle]+distance[middle][to]);
        long[] dp=new long[source.length()+1];
        Arrays.fill(dp,infinity);
        dp[0]=0;
        for(int start=0;start<source.length();start++){
            if(dp[start]==infinity)continue;
            if(source.charAt(start)==target.charAt(start))dp[start+1]=Math.min(dp[start+1],dp[start]);
            Node fromNode=root,toNode=root;
            for(int end=start;end<source.length();end++){
                fromNode=fromNode.next[source.charAt(end)-'a'];
                toNode=toNode.next[target.charAt(end)-'a'];
                if(fromNode==null||toNode==null)break;
                if(fromNode.id>=0&&toNode.id>=0&&distance[fromNode.id][toNode.id]<infinity)dp[end+1]=Math.min(dp[end+1],dp[start]+distance[fromNode.id][toNode.id]);
            }
        }
        return dp[source.length()]==infinity?-1:dp[source.length()];
    }
}
