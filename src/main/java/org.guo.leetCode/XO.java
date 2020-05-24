package org.guo.leetCode;

public class XO {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                mark(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                mark(board, board.length - 1, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                mark(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                mark(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        board[i][j] = 'M';
        if (i - 1 >= 0 && board[i-1][j] == 'O') {
            mark(board, i-1, j);
        } else if(i+1 < board.length && board[i+1][j] == 'O') {
            mark(board, i+1,j);
        } else if(j-1 >= 0 && board[i][j-1] == 'O') {
            mark(board, i, j-1);
        } else if (j+1 < board[0].length && board[i][j+1] == 'O') {
            mark(board, i, j+1);
        }
    }

    public static void main(String[] args) {
        
    }
}
