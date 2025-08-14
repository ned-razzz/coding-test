package dp.p1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] houseList = new int[n][3];
        for (int i = 0; i < n; i++) {
            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            houseList[i][0] = costs[0];
            houseList[i][1] = costs[1];
            houseList[i][2] = costs[2];
        }

        int[][] table = new int[n][3];
        table[0][0] = houseList[0][0];
        table[0][1] = houseList[0][1];
        table[0][2] = houseList[0][2];

        for (int i = 1; i < n; i++) {
            table[i][0] = houseList[i][0] + Math.min(table[i-1][1], table[i-1][2]);
            table[i][1] = houseList[i][1] + Math.min(table[i-1][0], table[i-1][2]);
            table[i][2] = houseList[i][2] + Math.min(table[i-1][0], table[i-1][1]);
        }

        int min = Math.min(Math.min(table[n - 1][0], table[n - 1][1]), table[n - 1][2]);
        System.out.println(min);
    }
}
