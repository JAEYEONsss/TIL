import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] number = br.readLine().split("");
        int[] times = new int[10];

        int all = 0;

        for (int i = 0; i < number.length; i++) {
            int num = Integer.parseInt(number[i]);
            if (num != 6 && num != 9) {
                times[num] += 1;
            }
            else{
                all += 1;
                if (all == 2) {
                    all = 0;
                    times[9] += 1;
                }
            }
        }
        if (all > 0)
            times[9] += 1;

        int max = times[0];

        for (int i = 1; i < 10; i++) {
            max = Math.max(max, times[i]);
        }

        System.out.println(max);
    }
}
