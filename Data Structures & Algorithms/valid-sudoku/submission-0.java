class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Set<Character>[] rowSet = new HashSet[rows];
        Set<Character>[] columnSet = new HashSet[cols];
        Map<Integer, Set<Character>> sub_boxes = new HashMap<Integer, Set<Character>>();
        for(int i=0; i<rows; i++) {
            rowSet[i] = new HashSet<Character>();
        }
        for(int j=0; j< cols; j++) {
            columnSet[j] = new HashSet<Character>();
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j< cols; j++) {
                char val = board[i][j];
                int sub_box = ((i/3)*10) + (j/3);
                // System.out.println("i is "+i+" j is "+j+" and sub_box is "+sub_box);
                // System.out.println("Before check of val "+val+" i is "+i+" j is "+j+" and sub_box is "+sub_box+" and boxes - "+sub_boxes.get(sub_box)+" result - "+(sub_boxes.containsKey(sub_box) && sub_boxes.get(sub_box).contains(val)));
                // System.out.println("val "+val+" i "+i+" j "+j+" sub_box "+sub_box+" boxes - "+sub_boxes.get(sub_box)+" result - "+(sub_boxes.containsKey(sub_box) && sub_boxes.get(sub_box).contains(val)));
                if(val != '.' && (rowSet[i].contains(val) || columnSet[j].contains(val) || (sub_boxes.containsKey(sub_box) && sub_boxes.get(sub_box).contains(val))) ){
                    System.out.println("Returning false for i "+i+" j "+j+" and val "+val);
                    return false;
                }
                else if(val != '.') {
                // else {
                    rowSet[i].add(val);
                    columnSet[j].add(val);
                    if(!sub_boxes.containsKey(sub_box))
                        sub_boxes.put(sub_box, new HashSet<Character>());
                    sub_boxes.get(sub_box).add(val);
                }
            }
        }

        return true;

    }
}
