import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] ar = new int[][] {
                new int[] {0,1,0},
                new int[] {0,0,1},
                new int[] {1,1,1},
                new int[] {0,0,0}
        };
        new GameOfLife.Solution().gameOfLife(ar);
        Arrays.stream(ar).map(Arrays::toString).forEach(System.out::println);
    }

    static class Solution {
        /*
        According to Wikipedia's article: "The Game of Life, also known simply as Life,
        is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
        The board is made up of an m x n grid of cells,
        where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

        Any live cell with fewer than two live neighbors dies as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population.
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        The next state of the board is determined by applying the above rules simultaneously
        to every cell in the current state of the m x n grid board.
        In this process, births and deaths occur simultaneously.

        Given the current state of the board, update the board to reflect its next state.
         */
        public void gameOfLife(int[][] board) {
            int[][] b = new int[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    int life = 0;
                    if(i - 1 >= 0 && board[i - 1][j] == 1) life++;
                    if(i + 1 < board.length && board[i + 1][j] == 1) life++;
                    if(j - 1 >= 0 && board[i][j - 1] == 1) life++;
                    if(j + 1 < board[0].length && board[i][j + 1] == 1) life++;
                    if((i - 1 >= 0 && j - 1 >= 0) && board[i -1][j - 1] == 1) life++;
                    if((i + 1 < board.length && j + 1 < board[0].length) && board[i + 1][j + 1] == 1) life++;
                    if((i - 1 >= 0 && j + 1 < board[0].length) && board[i - 1][j + 1] == 1) life++;
                    if((i + 1 < board.length && j - 1 >= 0) && board[i + 1][j - 1] == 1) life++;

                    if(board[i][j] == 1) {
                        if(life < 2) {
                            b[i][j] = 0;
                        } else if(life < 4) {
                            b[i][j] = 1;
                        } else {
                            b[i][j] = 0;
                        }
                    } else if(life == 3) {
                        b[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < board.length; i++) {
                System.arraycopy(b[i], 0, board[i], 0, board[0].length);
            }
        }
    }
}
