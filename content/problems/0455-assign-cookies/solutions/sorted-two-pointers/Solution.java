class Solution { public int findContentChildren(int[] g,int[] s){Arrays.sort(g);Arrays.sort(s);int child=0;for(int cookie:s)if(child<g.length&&cookie>=g[child])child++;return child;} }
