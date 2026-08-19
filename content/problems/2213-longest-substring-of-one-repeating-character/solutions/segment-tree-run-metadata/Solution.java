class Solution {
    char[] chars,leftChar,rightChar;
    int[] length,prefix,suffix,best;
    private void pull(int node){
        int a=node*2,b=a+1;
        length[node]=length[a]+length[b];
        leftChar[node]=leftChar[a];
        rightChar[node]=rightChar[b];
        prefix[node]=prefix[a];
        suffix[node]=suffix[b];
        best[node]=Math.max(best[a],best[b]);
        if(rightChar[a]==leftChar[b]){
            best[node]=Math.max(best[node],suffix[a]+prefix[b]);
            if(prefix[a]==length[a])prefix[node]+=prefix[b];
            if(suffix[b]==length[b])suffix[node]+=suffix[a];
        }
    }
    private void build(int node,int left,int right){
        if(left==right){
            length[node]=prefix[node]=suffix[node]=best[node]=1;
            leftChar[node]=rightChar[node]=chars[left];
            return;
        }
        int middle=(left+right)/2;
        build(node*2,left,middle);
        build(node*2+1,middle+1,right);
        pull(node);
    }
    private void update(int node,int left,int right,int index,char value){
        if(left==right){
            leftChar[node]=rightChar[node]=value;
            return;
        }
        int middle=(left+right)/2;
        if(index<=middle)update(node*2,left,middle,index,value);
        else update(node*2+1,middle+1,right,index,value);
        pull(node);
    }
    public int[] longestRepeating(String s,String queryCharacters,int[] queryIndices){
        int n=s.length();
        chars=s.toCharArray();
        int size=4*n;
        leftChar=new char[size];
        rightChar=new char[size];
        length=new int[size];
        prefix=new int[size];
        suffix=new int[size];
        best=new int[size];
        build(1,0,n-1);
        int[] answer=new int[queryIndices.length];
        for(int i=0;i<answer.length;i++){
            update(1,0,n-1,queryIndices[i],queryCharacters.charAt(i));
            answer[i]=best[1];
        }
        return answer;
    }
}
