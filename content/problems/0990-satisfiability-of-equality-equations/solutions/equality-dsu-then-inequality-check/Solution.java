class Solution {
    public boolean equationsPossible(String[] equations){
        int[] parent=new int[26];
        for(int i=0;i<26;i++)parent[i]=i;
        for(String equation:equations)if(equation.charAt(1)=='=')parent[find(equation.charAt(0)-'a',parent)]=find(equation.charAt(3)-'a',parent);
        for(String equation:equations)if(equation.charAt(1)=='!'&&find(equation.charAt(0)-'a',parent)==find(equation.charAt(3)-'a',parent))return false;
        return true;
    }
    private int find(int x,int[] parent){
        return parent[x]==x?x:(parent[x]=find(parent[x],parent));
    }
}
