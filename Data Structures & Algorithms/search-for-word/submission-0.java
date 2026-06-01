class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(checkWord(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean checkWord(char[][] board, String word, int r, int c, int i){
        // System.out.println("R "+r+" C "+c+" i "+i);
        if(i == word.length())
            return true;
        // System.out.println("r > len"+(r > board.length - 1)+" c > len "+(c > board[0].length-1));
        if(r < 0 || c < 0 || r > board.length - 1 || c > board[0].length-1 || board[r][c] != word.charAt(i) || board[r][c] == '#')
            return false;
        char temp = board[r][c];
        board[r][c] = '#';
        boolean res = checkWord(board, word, r-1, c, i+1) || checkWord(board, word, r+1, c, i+1) || checkWord(board, word, r, c-1, i+1) || checkWord(board, word, r, c+1, i+1);
        board[r][c] = temp;
        return res;
    }
}
