class Solution { fun maxIceCream(costs:IntArray,coinsValue:Int):Int{costs.sort();var coins=coinsValue;var answer=0;for(cost in costs){if(coins<cost)break;coins-=cost;answer++};return answer} }
