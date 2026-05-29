class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        int prod = 1;
        for(int i=0; i<len-1; i++){
            result[i+1] = result[i] * nums[i];
        }
        for(int i=len-1; i>=0; i--){
            result[i] *= prod;
            prod *= nums[i];
        }
        return result;
    }
}  
