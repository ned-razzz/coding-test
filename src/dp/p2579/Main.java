package dp.p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단 갯수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 계단 점수 배열
        int[] stairs = new int[n+1];
        stairs[0] = 0; // 계단 아래 시작점은 0점으로 설정
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 1번째 계단 밖에 없으면
        if (n <= 1) {
            System.out.println(stairs[1]);
            return;
        }

        // 초기 0~2 계단 점수 세팅
        int[][] mem = new int[n+1][2];
        // 시작점은 0점으로 설정
        mem[0][0] = stairs[0];
        mem[0][1] = stairs[0];
        // 1번째 계단은 1가지 밖에 없음
        mem[1][0] = stairs[1];
        mem[1][1] = stairs[0];

        // 2번째 계단은 1->2 연속해서 올라갈 수 있음
        mem[2][0] = stairs[1] + stairs[2];
        mem[2][1] = stairs[2];

        for (int i = 3; i <= n; i++) {
            mem[i][0] = mem[i-1][1] + stairs[i];
            mem[i][1] = Math.max(mem[i-2][0], mem[i-2][1]) + stairs[i];
        }

        int result = Math.max(mem[n][0], mem[n][1]);
        System.out.println(result);

        br.close();
    }
}
