class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]]; }
        int finder = 0;
        while (finder != slow) { finder = nums[finder]; slow = nums[slow]; }
        return finder;
    }
};
