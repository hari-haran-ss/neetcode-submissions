class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Integer.MIN_VALUE;
        for(int pile: piles)
            max = Math.max(max, pile);
        int result = max;
        while(min <= max){
            int mid = (min + max)/2;
            if(isPossibleCombination(piles, mid, (double)h)){
                result = Math.min(result, mid);
                max = mid-1;
            }
            else
                min = mid+1;
        }
        return result;
    }

    public boolean isPossibleCombination(int[] piles, int k, double h){
        double totalHours = 0;
        for(int pile: piles){
            totalHours += pile%k == 0 ? pile/k : (pile/k)+1; 
        }
        return totalHours <= h;
    }
}
