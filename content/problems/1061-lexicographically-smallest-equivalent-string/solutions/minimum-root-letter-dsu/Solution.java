class Solution {
    public String smallestEquivalentString(String s1,String s2,String baseStr){
        int[] parent=new int[26];
        for(int i=0;i<26;i++)parent[i]=i;
        for(int i=0;i<s1.length();i++){
            int a=find(s1.charAt(i)-'a',parent),b=find(s2.charAt(i)-'a',parent);
            parent[Math.max(a,b)]=Math.min(a,b);
        }
        StringBuilder answer=new StringBuilder();
        for(char ch:baseStr.toCharArray())answer.append((char)('a'+find(ch-'a',parent)));
        return answer.toString();
    }
    private int find(int x,int[] parent){
        return parent[x]==x?x:(parent[x]=find(parent[x],parent));
    }
}
