class Solution {
    public int rotatedDigits(int n){
        int answer=0;
        for(int value=1;value<=n;value++){
            int current=value;
            boolean valid=true,changed=false;
            while(current>0){
                int digit=current%10;
                current/=10;
                if(digit==3||digit==4||digit==7){
                    valid=false;
                    break;
                }
                if(digit==2||digit==5||digit==6||digit==9)changed=true;
            }
            if(valid&&changed)answer++;
        }
        return answer;
    }
}
