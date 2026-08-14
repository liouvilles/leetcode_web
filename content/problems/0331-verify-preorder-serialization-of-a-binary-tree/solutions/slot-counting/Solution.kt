class Solution { fun isValidSerialization(preorder:String):Boolean{var slots=1;for(token in preorder.split(',')){if(slots==0)return false;slots--;if(token!="#")slots+=2};return slots==0} }
