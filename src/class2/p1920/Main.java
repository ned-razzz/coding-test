package class2.p1920;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        int m = Integer.parseInt(br.readLine());
        int[] searches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int search : searches) {
            if (list.contains(search)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
