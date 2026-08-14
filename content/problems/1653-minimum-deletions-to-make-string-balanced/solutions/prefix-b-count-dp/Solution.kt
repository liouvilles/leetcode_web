class Solution { fun minimumDeletions(text:String):Int{var bCount=0;var deletions=0;for(letter in text)if(letter=='b')bCount++ else deletions=minOf(deletions+1,bCount);return deletions} }
