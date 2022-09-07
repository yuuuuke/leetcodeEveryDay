package com.example.myapplication.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode3 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!map.add(board[i][j])) {
                        return false;
                    }
                }
            }
            map.clear();
        }

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (!map.add(board[i][j])) {
                        return false;
                    }
                }
            }
            map.clear();
        }

        HashSet<Character> map1 = new HashSet<>();
        HashSet<Character> map2 = new HashSet<>();
        HashSet<Character> map3 = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.') {
                    if (!map1.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.') {
                    if (!map2.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!map3.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        map1.clear();
        map2.clear();
        map3.clear();

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.') {
                    if (!map1.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.') {
                    if (!map2.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!map3.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        map1.clear();
        map2.clear();
        map3.clear();

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '.') {
                    if (!map1.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 3; j < 6; j++) {
                if (board[i][j] != '.') {
                    if (!map2.add(board[i][j])) {
                        return false;
                    }
                }
            }
            for (int j = 6; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!map3.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
