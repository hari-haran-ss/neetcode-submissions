class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int p = m+n, c=0, p1=0, p2=0;
        int[] merged = new int[p];
        while(p1 < m && p2 < n){
            if(nums1[p1] < nums2[p2])
                merged[c++] = nums1[p1++];
            else
                merged[c++] = nums2[p2++];
        }
        while(p1 < m){
            merged[c++] = nums1[p1++];
        }
        while(p2 < n){
            merged[c++] = nums2[p2++];
        }
        if(p % 2 == 0)
            return (double)(merged[p/2] + merged[(p/2)-1])/2;
        return merged[p/2];
    }
}
