package com.example.myapplication;

public class leetcode733 {

    private static int length;
    private static int height;
    private static int result;
    private static int start;

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length == 0) {
            return image;
        }
        if (sr >= 0 && sr <= height - 1 && sc >= 0 && sc <= length - 1) {
            start = image[sr][sc];
            result = color;
            height = image.length;
            length = image[0].length;
            Coloring(image, sr, sc);
        }
        return image;
    }

    private static void Coloring(int[][] image, int sr, int sc) {
        if (image[sr][sc] == start) {
            image[sr][sc] = result;
            if (sr - 1 >= 0) {
                Coloring(image, sr - 1, sc);
            }
            if (sr + 1 <= height - 1) {
                Coloring(image, sr + 1, sc);
            }
            if (sc + 1 <= length - 1) {
                Coloring(image, sr, sc + 1);
            }
            if (sc - 1 >= 0) {
                Coloring(image, sr , sc);
            }
        }
    }

//    public static void main(String[] args) {
//        floodFill(new int[][]{{},{},{}})
//    }
}
