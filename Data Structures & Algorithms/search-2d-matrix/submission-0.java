class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0, colStart = 0, rowEnd = matrix.length-1, colEnd = matrix[0].length-1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            int rowMid = (rowStart + rowEnd)/2;
            int colMid = (colStart + colEnd)/2;
            if(matrix[rowMid][colMid] == target)
                return true;
            else if(matrix[rowMid][colMid] < target){
                if(matrix[rowMid][colEnd] >= target)
                    colStart = colMid + 1;
                else
                    rowStart = rowMid + 1;
            }
            else{
                if(matrix[rowMid][colStart] <= target)
                    colEnd = colMid-1;
                else
                    rowEnd = rowMid - 1;
            }
        }
        return false;
    }
}
