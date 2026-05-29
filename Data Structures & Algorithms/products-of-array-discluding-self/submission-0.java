class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int product = 1, zeros = 0;
        int[] result = new int[len];
        for(int i =0; i<len; i++) {
            result[i] = 0;
            if(nums[i] == 0)
                zeros++;
            else
                product = product * nums[i];
        }
        if(zeros > 1)
            return result;
        for(int i =0; i<len; i++) {
            if(zeros > 0) {
                if(nums[i] == 0)
                    result[i] = product;
            }
            else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}  
