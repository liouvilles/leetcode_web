class Solution { fun change(amount:Int,coins:IntArray):Int{val ways=IntArray(amount+1);ways[0]=1;for(coin in coins)for(sum in coin..amount)ways[sum]+=ways[sum-coin];return ways[amount]} }
