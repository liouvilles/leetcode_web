class Solution {
    private lateinit var chars:CharArray;
    private lateinit var leftChar:CharArray;
    private lateinit var rightChar:CharArray;
    private lateinit var length:IntArray;
    private lateinit var prefix:IntArray;
    private lateinit var suffix:IntArray;
    private lateinit var best:IntArray;
    private fun pull(node:Int){
        val a=node*2;
        val b=a+1;
        length[node]=length[a]+length[b];
        leftChar[node]=leftChar[a];
        rightChar[node]=rightChar[b];
        prefix[node]=prefix[a];
        suffix[node]=suffix[b];
        best[node]=maxOf(best[a],best[b]);
        if(rightChar[a]==leftChar[b]){
            best[node]=maxOf(best[node],suffix[a]+prefix[b]);
            if(prefix[a]==length[a])prefix[node]+=prefix[b];
            if(suffix[b]==length[b])suffix[node]+=suffix[a]
        }
    };
    private fun build(node:Int,left:Int,right:Int){
        if(left==right){
            length[node]=1;
            prefix[node]=1;
            suffix[node]=1;
            best[node]=1;
            leftChar[node]=chars[left];
            rightChar[node]=chars[left];
            return
        };
        val middle=(left+right)/2;
        build(node*2,left,middle);
        build(node*2+1,middle+1,right);
        pull(node)
    };
    private fun update(node:Int,left:Int,right:Int,index:Int,value:Char){
        if(left==right){
            leftChar[node]=value;
            rightChar[node]=value;
            return
        };
        val middle=(left+right)/2;
        if(index<=middle)update(node*2,left,middle,index,value)else update(node*2+1,middle+1,right,index,value);
        pull(node)
    };
    fun longestRepeating(s:String,queryCharacters:String,queryIndices:IntArray):IntArray{
        val n=s.length;
        chars=s.toCharArray();
        val size=4*n;
        leftChar=CharArray(size);
        rightChar=CharArray(size);
        length=IntArray(size);
        prefix=IntArray(size);
        suffix=IntArray(size);
        best=IntArray(size);
        build(1,0,n-1);
        return IntArray(queryIndices.size){
            i->update(1,0,n-1,queryIndices[i],queryCharacters[i]);
            best[1]
        }
    }
}
