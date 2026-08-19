class Solution {
    private static class TrieNode{
        TrieNode[] next=new TrieNode[26];
        int owners,lastOwner=-1;
    }
    public String[] shortestSubstrings(String[] arr){
        TrieNode root=new TrieNode();
        for(int owner=0;owner<arr.length;owner++)for(int start=0;start<arr[owner].length();start++){
            TrieNode node=root;
            for(int end=start;end<arr[owner].length();end++){
                int letter=arr[owner].charAt(end)-'a';
                if(node.next[letter]==null)node.next[letter]=new TrieNode();
                node=node.next[letter];
                if(node.lastOwner!=owner){node.lastOwner=owner;node.owners++;}
            }
        }
        String[] answer=new String[arr.length];
        for(int owner=0;owner<arr.length;owner++){
            String best="";
            for(int start=0;start<arr[owner].length();start++){
                TrieNode node=root;
                for(int end=start;end<arr[owner].length();end++){
                    node=node.next[arr[owner].charAt(end)-'a'];
                    if(node.owners==1){
                        String candidate=arr[owner].substring(start,end+1);
                        if(best.isEmpty()||candidate.length()<best.length()||candidate.length()==best.length()&&candidate.compareTo(best)<0)best=candidate;
                    }
                }
            }
            answer[owner]=best;
        }
        return answer;
    }
}
