class Solution {
    public int numSimilarGroups(String[] strs){
        DSU dsu=new DSU(strs.length);
        for(int i=0;i<strs.length;i++)for(int j=i+1;j<strs.length;j++)if(similar(strs[i],strs[j]))dsu.union(i,j);
        return dsu.groups;
    }
    private boolean similar(String a,String b){
        int differences=0;
        for(int i=0;i<a.length();i++)if(a.charAt(i)!=b.charAt(i)&&++differences>2)return false;
        return true;
    }
    private static class DSU{
        int[] parent;
        int groups;
        DSU(int n){
            groups=n;
            parent=new int[n];
            for(int i=0;i<n;i++)parent[i]=i;
        }
        int find(int x){
            return parent[x]==x?x:(parent[x]=find(parent[x]));
        }
        void union(int a,int b){
            a=find(a);
            b=find(b);
            if(a!=b){
                parent[b]=a;
                groups--;
            }
        }
    }
}
