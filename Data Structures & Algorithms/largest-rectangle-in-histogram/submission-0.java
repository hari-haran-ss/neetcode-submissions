class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int len = heights.length, maxArea = 0;
        for(int i=0; i<len; i++){
            int height = heights[i];
            int start = i;
            maxArea = Math.max(maxArea, height);
            while(!stack.isEmpty() && stack.peek().height > height){
                Pair p = stack.pop();
                maxArea = Math.max(maxArea, (i - p.index)*p.height);
                start = p.index;
            }
            stack.push(new Pair(start, height));
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            maxArea = Math.max(maxArea, (len - p.index)*p.height);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        }
        return maxArea;
    }
}

class Pair{
    int index;
    int height;
    public Pair(int index, int height){
        this.index = index;
        this.height = height;
    }
}