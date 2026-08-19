class Solution {
    public boolean isAdditiveNumber(String num){
        int n=num.length();
        for(int i=1;i<n-1;i++){
            if(num.charAt(0)=='0'&&i>1)break;
            for(int j=i+1;j<n;j++){
                if(num.charAt(i)=='0'&&j-i>1)break;
                String a=num.substring(0,i),b=num.substring(i,j);
                int index=j;
                while(index<n){
                    String sum=add(a,b);
                    if(!num.startsWith(sum,index))break;
                    index+=sum.length();
                    a=b;
                    b=sum;
                }
                if(index==n)return true;
            }
        }
        return false;
    }
    private String add(String a,String b){
        StringBuilder out=new StringBuilder();
        int i=a.length()-1,j=b.length()-1,carry=0;
        while(i>=0||j>=0||carry>0){
            int value=carry+(i>=0?a.charAt(i--)-'0':0)+(j>=0?b.charAt(j--)-'0':0);
            out.append(value%10);
            carry=value/10;
        }
        return out.reverse().toString();
    }
}
