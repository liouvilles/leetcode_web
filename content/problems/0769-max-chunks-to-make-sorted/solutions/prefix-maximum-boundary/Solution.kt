class Solution { fun maxChunksToSorted(arr:IntArray):Int{var answer=0;var maximum=0;for(i in arr.indices){maximum=maxOf(maximum,arr[i]);if(maximum==i)answer++};return answer} }
