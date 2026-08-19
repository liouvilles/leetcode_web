class Solution {
    private static class Node{
        Node[] next=new Node[26];
        boolean end;
    }
    private final Node root=new Node();
    public String replaceWords(List<String> dictionary,String sentence){
        for(String word:dictionary)insert(word);
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++)words[i]=replace(words[i]);
        return String.join(" ",words);
    }
    private void insert(String word){
        Node node=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(node.next[index]==null)node.next[index]=new Node();
            node=node.next[index];
        }
        node.end=true;
    }
    private String replace(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            node=node.next[word.charAt(i)-'a'];
            if(node==null)return word;
            if(node.end)return word.substring(0,i+1);
        }
        return word;
    }
}
