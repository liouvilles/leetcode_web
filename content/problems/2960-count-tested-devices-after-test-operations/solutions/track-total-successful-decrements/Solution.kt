class Solution { fun countTestedDevices(batteryPercentages:IntArray):Int{var tested=0;for(battery in batteryPercentages)if(battery-tested>0)tested++;return tested} }
