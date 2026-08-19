class Solution {
    fun canChange(start:String,target:String):Boolean{
        val n=start.length;
        var i=0;
        var j=0;
        while(true){
            while(i<n&&start[i]=='_')i++;
            while(j<n&&target[j]=='_')j++;
            if(i==n||j==n)return i==n&&j==n;
            val piece=start[i];
            if(piece!=target[j])return false;
            if(piece=='L'&&i<j||piece=='R'&&i>j)return false;
            i++;
            j++
        }
    }
}
