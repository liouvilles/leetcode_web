class Solution { public String kthLargestNumber(String[] nums,int k){Arrays.sort(nums,(a,b)->a.length()!=b.length()?Integer.compare(b.length(),a.length()):b.compareTo(a));return nums[k-1];} }
