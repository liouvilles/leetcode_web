class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int next=a%b;
            a=b;
            b=next;
        }
        return a;
    }
    public long makeSubKSumEqual(int[] arr,int k){
        int groups=gcd(arr.length,k);
        long answer=0;
        for(int start=0;start<groups;start++){
            List<Integer> values=new ArrayList<>();
            for(int index=start;index<arr.length;index+=groups)values.add(arr[index]);
            Collections.sort(values);
            int median=values.get(values.size()/2);
            for(int value:values)answer+=Math.abs((long)value-median);
        }
        return answer;
    }
}
