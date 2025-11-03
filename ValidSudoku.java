// Time Complexity : O(1) as its 9*9 fixed matrix
// Space Complexity : O(1) as its 9*9 fixed matrix
// Did this code successfully run on Leetcode : Yes
// Approach : To validate a sudoku there should be no repeated number in it's row, column and in its individual 3*3 matrix for 9*9 input Sudoku matrix.
// So we check if there's any repeated value at row level, column level and individual matrix level with the help of three HashSets, one for each case.
// If duplicate is found we return false as it's not a valid sudoku.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>(); // to check row level repeated value
            HashSet<Character> colSet = new HashSet<>(); // to check column level repeated value
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    if (!rowSet.contains(board[i][j])) { //row level check
                        rowSet.add(board[i][j]);
                    } else {
                        return false; //duplicate found not a valid sudoku
                    }
                }
                if (board[j][i] != '.'){
                    if (!colSet.contains(board[j][i])) { //column level check
                        colSet.add(board[j][i]);
                    } else {
                        return false;//duplicate found not a valid sudoku
                    }
                }
            }
        }
        //To check each of the 9 3*3 matrix in a valid sudoku
        for (int i = 0; i < m; i = i + 3) {
            for (int j = 0; j < n; j = j + 3) {
                HashSet<Character> matrix = new HashSet<>(); // to check each 3*3 matrix level repeated value
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (board[r][c] != '.') {
                            if (!matrix.contains(board[r][c])) {
                                matrix.add(board[r][c]);
                            } else {
                                return false;//duplicate found not a valid sudoku
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}