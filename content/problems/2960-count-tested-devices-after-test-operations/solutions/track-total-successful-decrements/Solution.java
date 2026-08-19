class Solution {
    public int countTestedDevices(int[] batteryPercentages){
        int tested=0;
        for(int battery:batteryPercentages)if(battery-tested>0)tested++;
        return tested;
    }
}
