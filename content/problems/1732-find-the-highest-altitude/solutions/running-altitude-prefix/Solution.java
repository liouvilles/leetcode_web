class Solution { public int largestAltitude(int[] gain){int altitude=0,highest=0;for(int change:gain){altitude+=change;highest=Math.max(highest,altitude);}return highest;} }
