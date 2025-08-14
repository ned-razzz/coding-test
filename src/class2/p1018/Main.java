package class2.p1018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 보드의 전체 크기 입력 (N x M)
        String[] dimensions = br.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        // 보드의 현재 상태 입력
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int countAllBoard = 64;
        for (int x = 0; x <= cols - 8; x++) {
            for (int y = 0; y <= rows - 8; y++) {
                int countB = countWrongColors(board, x, y, 'B');
                int countW = countWrongColors(board, x, y, 'W');
                int countCurrentBoard = Math.min(countB, countW);

                if (countCurrentBoard < countAllBoard) {
                    countAllBoard = countCurrentBoard;
                }
            }
        }
        System.out.println(countAllBoard);
    }

    public static int countWrongColors(char[][] board, int x, int y, char startColor) {
        int count = 0;
        char lineStartColor = startColor;
        for (int i = y; i < y + 8; i++) {
            char currentColor = lineStartColor;
            for (int j = x; j < x + 8; j++) {
                if (currentColor == board[i][j]) {
                    count++;
                }
                currentColor = toggleColor(currentColor);
            }
            lineStartColor = toggleColor(lineStartColor);
        }
        return count;
    }

    public static char toggleColor(char color) {
        if (color == 'B') {
            return 'W';
        } else {
            return 'B';
        }
    }
}
