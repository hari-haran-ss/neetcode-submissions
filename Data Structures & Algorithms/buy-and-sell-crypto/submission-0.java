class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, end = prices.length-1, result = 0;
        while(start < end){
            int ptr = start+1;
            while(ptr <= end && prices[start] < prices[ptr]){
                result = Math.max(result, prices[ptr] - prices[start]);
                ptr++;
            }
            start = ptr;
        }
        return result;
    }
}
