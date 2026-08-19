class Solution {
    public boolean canChange(String start,String target){
        int n=start.length(),i=0,j=0;
        while(true){
            while(i<n&&start.charAt(i)=='_')i++;
            while(j<n&&target.charAt(j)=='_')j++;
            if(i==n||j==n)return i==n&&j==n;
            char piece=start.charAt(i);
            if(piece!=target.charAt(j))return false;
            if(piece=='L'&&i<j||piece=='R'&&i>j)return false;
            i++;
            j++;
        }
    }
}
