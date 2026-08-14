class Solution { fun minimumSwap(s1:String,s2:String):Int{var xy=0;var yx=0;for(i in s1.indices)if(s1[i]!=s2[i]){if(s1[i]=='x')xy++ else yx++};if((xy+yx)%2==1)return -1;return xy/2+yx/2+xy%2*2} }
