package class2.p11650;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] posList = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            posList[i][0] = Integer.parseInt(tokens[0]);
            posList[i][1] = Integer.parseInt(tokens[1]);
        }
        br.close();

        Arrays.sort(posList, Comparator.comparing((int[] pos) -> pos[0]).thenComparing((int[] pos) -> pos[1]));

        for (int[] pos : posList) {
            sb.append(pos[0]).append(" ").append(pos[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
