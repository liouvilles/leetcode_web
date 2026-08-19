class Solution { fun countDigits(num:Int):Int{var value=num;var answer=0;while(value>0){val digit=value%10;if(digit!=0&&num%digit==0)answer++;value/=10};return answer} }
