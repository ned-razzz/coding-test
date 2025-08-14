package class2.p10816;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 숫자 카드 입력
        int n = Integer.parseInt(br.readLine());

        int[] cardMap = new int[20_000_001];
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(card -> cardMap[card+10_000_000]++);

        // 탐지할 카드 입력
        int m = Integer.parseInt(br.readLine());
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(cardToDetect -> {
                    sb.append(cardMap[cardToDetect+10_000_000]).append(" ");
                });

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
