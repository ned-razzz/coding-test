package class3.p2630;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] map; // 전역 변수로 map을 선언하여 매번 파라미터로 넘기지 않도록 수정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        countSolidColored(0, 0, n); // 파라미터를 시작 좌표와 길이로 간소화
        System.out.println(white);
        System.out.println(blue);

        sc.close();
    }

    /**
     * @param row 시작 행
     * @param col 시작 열
     * @param size 현재 사각형의 한 변의 길이
     */
    public static void countSolidColored(int row, int col, int size) {
        // 현재 사각형이 단색인지 확인
        if (isSolidColor(row, col, size)) {
            if (map[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return; // 단색이므로 더 이상 분할하지 않고 종료
        }

        // 단색이 아니면 4분할하여 재귀 호출
        int newSize = size / 2;
        countSolidColored(row, col, newSize); // 1사분면
        countSolidColored(row, col + newSize, newSize); // 2사분면
        countSolidColored(row + newSize, col, newSize); // 3사분면
        countSolidColored(row + newSize, col + newSize, newSize); // 4사분면
    }

    /**
     * 해당 영역이 모두 같은 색인지 확인하는 함수
     * @return 모두 같은 색이면 true, 아니면 false
     */
    public static boolean isSolidColor(int row, int col, int size) {
        int firstColor = map[row][col]; // 기준이 되는 색상 (해당 사각형의 첫 번째 칸)

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 기준 색상과 하나라도 다르면 즉시 false 반환
                if (map[i][j] != firstColor) {
                    return false;
                }
            }
        }

        // 모든 칸의 색이 같으면 true 반환
        return true;
    }
}