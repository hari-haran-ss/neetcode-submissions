class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int start = 0, end = heights.length-1;
        while(start < end){
            int h = Math.min(heights[start], heights[end]);
            int w = end - start;
            result = Math.max(result, h*w);
            if(heights[start] < heights[end])
                start++;
            else
                end--;
        }
        return result;
    }
}
