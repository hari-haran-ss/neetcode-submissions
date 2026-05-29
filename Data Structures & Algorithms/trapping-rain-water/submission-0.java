class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int start = 0, end = len-1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while(start < end){
            if(height[start] < height[end]){
                if(height[start] > leftMax)
                    leftMax = height[start];
                else
                    result += leftMax - height[start];
                // System.out.println("Left area - start "+start+" height "+height[start]+" leftMax "+leftMax+" result "+result);
                start++;
            }
            else{
                if(height[end] > rightMax){
                    rightMax = height[end];
                }
                else{
                    result += rightMax - height[end];
                }
                // System.out.println("Right area - end "+end+" height "+height[end]+" rightMax "+rightMax+" result "+result);
                end--;
            }
        }
        return result;
    }
}
