class Solution { fun largestAltitude(gain:IntArray):Int{var altitude=0;var highest=0;for(change in gain){altitude+=change;highest=maxOf(highest,altitude)};return highest} }
