class Solution {
    fun canTransform(start:String,end:String):Boolean{
        var i=0;
        var j=0;
        val n=start.length;
        while(true){
            while(i<n&&start[i]=='X')i++;
            while(j<n&&end[j]=='X')j++;
            if(i==n||j==n)return i==n&&j==n;
            if(start[i]!=end[j])return false;
            if(start[i]=='L'&&i<j)return false;
            if(start[i]=='R'&&i>j)return false;
            i++;
            j++
        }
    }
}
